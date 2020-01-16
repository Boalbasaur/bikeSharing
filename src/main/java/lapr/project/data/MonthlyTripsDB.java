/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.MonthlyTrips;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Diogo Rolo
 */
public class MonthlyTripsDB extends DataHandler {

    public MonthlyTrips getMonthlyTrips(int idTrip) {

        /* Objeto "callStmt" para invocar a função "getMonthlyTrips" armazenada na BD.
         *
         * FUNCTION getSailor(id NUMBER) RETURN pkgSailors.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getMonthlyTrips(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getMonthlyTrips".
            callStmt.setInt(2, idTrip);
            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idMonthlyTrip = rSet.getInt(1);
                String nome = rSet.getString(2);
                String dataMonthYear = rSet.getString(3);
                float totalPrice = rSet.getFloat(4);
                int monthPoints = rSet.getInt(5);
                return new MonthlyTrips(idMonthlyTrip, nome, dataMonthYear, totalPrice, monthPoints);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No MonthlyTrip with idTrip:" + idTrip);
    }

    public MonthlyTrips getMonthlyTrips(String username, String dateMonthYear) {

        /* Objeto "callStmt" para invocar a função "getMonthlyTrips" armazenada na BD.
         *
         * FUNCTION getSailor(id NUMBER) RETURN pkgSailors.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getMonthlyTripss(?,?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getMonthlyTrips".
            callStmt.setString(2, username);
            callStmt.setString(3, dateMonthYear);
            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idMonthlyTrip = rSet.getInt(1);
                String dataMonthYears = rSet.getString(2);
                String nome = rSet.getString(3);
                float totalPrice = rSet.getFloat(4);
                int monthPoints = rSet.getInt(5);
                return new MonthlyTrips(idMonthlyTrip, dataMonthYears, nome, totalPrice, monthPoints);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No MonthlyTrip with username " + username + " and " + dateMonthYear);
    }

    public static void save(MonthlyTrips mt) {

        try {
            new MonthlyTripsDB().getMonthlyTrips(mt.getIdMonthlyTrip());
        } catch (IllegalArgumentException ex) {
            //Of the record does not exist, save it
            new MonthlyTripsDB().addMonthlyTrip(mt);
        }

        //TODO: implement the update method
    }

    public void addMonthlyTrip(MonthlyTrips mt) {
        addMonthlyTrip(mt.getIdMonthlyTrip(), mt.getUsername(), mt.getDateMonthYear(), mt.getTotalPrice(), mt.getMonthPoints());
    }

    /**
     *
     * @param uusername
     * @param uname
     * @param ubirthDate
     * @param uemail
     * @param upassword
     * @param ucreditCardNumber
     * @param uheight
     * @param uweight
     * @param utype
     */
    private void addMonthlyTrip(int idTrip, String username, String dateMonthYear, float totalPrice, int monthPoints) {

        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call addMonthlyTrip(?,?,?,?) }");

            callStmt.setInt(1, idTrip);
            callStmt.setString(2, username);
            callStmt.setString(3, dateMonthYear);
            callStmt.setFloat(4, totalPrice);
            callStmt.setInt(5, monthPoints);
            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePrice(int idMonthlyTrip, float tripPrice) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call updateMonthlyTripPrice(?,?) }");

            callStmt.setInt(1, idMonthlyTrip);
            callStmt.setFloat(2, tripPrice);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Trip with such id:" + idMonthlyTrip);
    }

    public void removeMothlyTrip(int idMonthlyTrip) {
        try {
            openConnection();
            /*
             *  Objeto "callStmt" para invocar o procedimento "removeSailor"
             *  armazenado na BD.
             *
             *  PROCEDURE removeSailor(sid NUMBER)
             *  PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
             */
            CallableStatement callStmt = getConnection().prepareCall("{ call removeMonthlyTrip(?) }");

            callStmt.setLong(1, idMonthlyTrip);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MonthlyTrips> getListMonthlyTrips(String username) {
        List<MonthlyTrips> mtList = new ArrayList<>();
        /* Objeto "callStmt" para invocar a função "getSailor" armazenada na BD.
         *
         * FUNCTION getSailor(id NUMBER) RETURN pkgSailors.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;

        try {
            callStmt = getConnection().prepareCall("{ ? = call getMonthlyTripsByUser(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getSailor".
            callStmt.setString(2, username);

            // Executa a invocação da função "getSailor".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".D
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {
                int idMonthlyTrip = rSet.getInt(1);
                String dateMonthYear = rSet.getString(2);
                String usernames = rSet.getString(3);
                float totalPrice = rSet.getFloat(4);
                int monthPoints = rSet.getInt(5);
                MonthlyTrips mt = new MonthlyTrips(idMonthlyTrip, dateMonthYear, usernames, totalPrice, monthPoints);
                mtList.add(mt);
            }
            return mtList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Não existem pagamentos por fazer para o user" + username);
    }
    
    /*
    ADICIONAR METODO QUE VAI ATUALIZAR MONTHPOINTS DO UTILIZADOR(id, points)
    */
        public void updateMonthlyTripPoints(int id, int receivedPoints) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call updateMonthlyTripPoints(?,?) }");

            callStmt.setInt(1, id);
            callStmt.setInt(2, receivedPoints);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
