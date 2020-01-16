/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import lapr.project.model.TouristPoint;
import lapr.project.model.Wind;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class WindDB extends DataHandler {

    public HashSet<Wind> getWinds() {

        HashSet<Wind> windsList = new HashSet<>();

        /* Objeto "callStmt" para invocar a função "getSailor" armazenada na BD.
         *
//         * FUNCTION getSailor(id NUMBER) RETURN pkgSailors.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call GETWINDS() }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet wSet = (ResultSet) callStmt.getObject(1);

            while (wSet.next()) {
                String origin = wSet.getString(1);
                String destination = wSet.getString(2);
                double windspeed = wSet.getDouble(3);
                float crosswind = wSet.getFloat(4);
                double cineticFriction = wSet.getDouble(5);
                Wind w = new Wind(origin, destination, windspeed, crosswind, cineticFriction);
                windsList.add(w);
            }
            return windsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    /**
     * Exemplo de invocação de uma "stored function".
     * <p>
     * '
     *
     * @param IDTouristPoint
     * @return o registo do id especificado ou null, se esse registo não
     * existir.
     */
    public Wind getWind(String originLocation, String destinyLocation) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getWind(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getTouristPoint".
            callStmt.setString(2, originLocation);
            callStmt.setString(3, destinyLocation);

            // Executa a invocação da função "getTouristPoint".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                double windspeed = rSet.getDouble(3);
                float crosswind = rSet.getFloat(4);
                double cineticFriction = rSet.getDouble(5);
                return new Wind(originLocation, destinyLocation, windspeed, crosswind, cineticFriction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No wind between:" + originLocation + "and" + destinyLocation);
    }

    public void addWind(Wind wind) {
        addWind(wind.getOrigin(), wind.getDestination(), wind.getWindspeed(), wind.getCrosswind());
    }

    /**
     * Exemplo de invocação de uma "stored procedure".
     * <p>
     *
     * @param sid o identificador do marinheiro.
     * @param sname o nome do marinheiro.
     * @param rating o "rating" do marinheiro.
     * @param age a idade do marinheiro.
     */
    private void addWind(String originLocation, String destinyLocation, double windspeed, float crosswind) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call addWind(?,?,?,?) }");

            callStmt.setString(1, originLocation);
            callStmt.setString(2, destinyLocation);
            callStmt.setDouble(3, windspeed);
            callStmt.setFloat(4, crosswind);
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exemplo de invocação de uma "stored procedure".
     * <p>
     *
     *
     * @param sid o identificador do marinheiro a remover.
     */
    public void removeWind(String originLocation, String destinyLocation) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call removeWind(?) }");

            callStmt.setString(1, originLocation);
            callStmt.setString(2, destinyLocation);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void delete(String originLocation, String destinyLocation) {
        new WindDB().removeWind(originLocation, destinyLocation);
    }

    public static void save(String originLocation, String destinyLocation, Wind wind) {

        try {
            new WindDB().getWind(originLocation, destinyLocation);
        } catch (IllegalArgumentException ex) {
            //Of the record does not exist, save it
            new WindDB().addWind(originLocation, destinyLocation, wind.getWindspeed(), wind.getCrosswind());
        }
    }
}
