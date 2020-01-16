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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Daniela Vinagreiro
 */
public class TouristPointDB extends DataHandler {

    /**
     * Exemplo de invocação de uma "stored function".
     * <p>
     * '
     *
     * @param IDTouristPoint
     * @return o registo do id especificado ou null, se esse registo não
     * existir.
     */
    public TouristPoint getTouristPoint(int IDTouristPoint) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getTouristPoint(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getTouristPoint".
            callStmt.setInt(2, IDTouristPoint);

            // Executa a invocação da função "getTouristPoint".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idTouristPoint = rSet.getInt(1);
                String name = rSet.getString(2);
                float latitude = rSet.getFloat(3);
                float longitude = rSet.getFloat(4);
                float altitude = rSet.getFloat(5);

                return new TouristPoint(idTouristPoint, name, latitude, longitude, altitude);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Tourist Point with ID:" + IDTouristPoint);
    }

    public int generateTouristParkID() {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call generateTouristParkID() }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Especifica o parâmetro de entrada da função "getTouristPoint".

            // Executa a invocação da função "getTouristPoint".
            callStmt.execute();

            return callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Can't generate new ID");

    }

    public void saveTouristPoint(TouristPoint tp) {
        int i = validateLocationTouristPoint(tp.getLatitude(), tp.getLongitude());
        switch (i) {
            case 1:
                break;
            case 0:
                try {
                new TouristPointDB().getTouristPoint(tp.getIdTouristPoint());
                } catch (IllegalArgumentException ex) {
                //Of the record does not exist, save it
                tp.setIdTouristPoint(new TouristPointDB().generateTouristParkID());
                new TouristPointDB().addTouristPoint(tp);
                }
                break;
            default:
                throw new IllegalArgumentException("Erro!");
        }
    }

    public void addTouristPoint(TouristPoint touristPoint) {
        addTouristPoint(touristPoint.getIdTouristPoint(), touristPoint.getDescription(), touristPoint.getLatitude(), touristPoint.getLongitude(), touristPoint.getAltitude());
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
    private void addTouristPoint(int idTouristPoint, String name, float latitude, float longitude, float altitude) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call addTouristPoint(?,?,?,?,?) }");

            callStmt.setInt(1, idTouristPoint);
            callStmt.setString(2, name);
            callStmt.setFloat(3, latitude);
            callStmt.setFloat(4, longitude);
            callStmt.setFloat(5, altitude);
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
     * @param IDTouristPoint
     */
    public void removeTouristPoint(int IDTouristPoint) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call removeTouristPoint(?) }");

            callStmt.setLong(1, IDTouristPoint);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void delete(int IDTouristPoint) {
        new TouristPointDB().removeTouristPoint(IDTouristPoint);
    }

    public HashSet<TouristPoint> getTouristPoints() {

        HashSet<TouristPoint> touristPointList = new HashSet<>();

        /* Objeto "callStmt" para invocar a função "getSailor" armazenada na BD.
         *
//         * FUNCTION getSailor(id NUMBER) RETURN pkgSailors.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call GETTOURISTPOINTS() }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                int idTouristPoint = rSet.getInt(1);
                String idName = rSet.getString(2);
                float longitude = rSet.getFloat(3);
                float latitude = rSet.getFloat(4);
                float altitude = rSet.getFloat(5);
                TouristPoint tp = new TouristPoint(idTouristPoint, idName, longitude, latitude, altitude);
                touristPointList.add(tp);
            }
            return touristPointList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public TouristPoint getTouristPointHavingCoordinates(float longitude, float latitude) {

        /* Objeto "callStmt" para invocar a função "getBike" armazenada na BD.
         *
         * FUNCTION getBike(id NUMBER) RETURN pkgBikes.ref_cursor
         * PACKAGE pkgBikes AS TYPE ref_cursor IS REF CURSOR; END pkgBikes;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getTouristPointHavingCoordinates(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getBike".
            callStmt.setFloat(2, longitude);
            callStmt.setFloat(3, latitude);

            // Executa a invocação da função "getBike".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idTouristPoint = rSet.getInt(1);
                String description = rSet.getString(2);
                float lat = rSet.getFloat(3);
                float longi = rSet.getFloat(3);
                float altitude = rSet.getFloat(3);
                return new TouristPoint(idTouristPoint, description, lat, longi, altitude);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public int validateLocationTouristPoint(float latitude, float longitude) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call VALIDATELOCATIONTOURISTPOINT(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setFloat(2, latitude);
            callStmt.setFloat(3, longitude);

            // Executa a invocação da função "getSailor".
            callStmt.execute();
            // Guarda o cursor retornado num objeto "ResultSet".D

            return callStmt.getInt(1);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

}
