/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import lapr.project.model.Trip;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class TripDB extends DataHandler{
    
    /**
     * @param username
     * @return 
     */
    public Trip getTripNotBlocked(String username) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getTripNotBlocked(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, username);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idTrip = rSet.getInt(1);
                String idBike = rSet.getString(2);
                String userName = rSet.getString(3);
                Timestamp dateTrip = rSet.getTimestamp(4);
                Calendar beginDate = Calendar.getInstance();
                beginDate.setTimeInMillis(dateTrip.getTime());
                Timestamp endDate = rSet.getTimestamp(5);
                Calendar finishDate = Calendar.getInstance();
                int origin = rSet.getInt(6);
                int destination = rSet.getInt(7);
                int price = rSet.getInt(8);
                if(endDate != null){
                    finishDate.setTimeInMillis(endDate.getTime());
                    return new Trip(idTrip, idBike, userName, beginDate, finishDate, origin, destination, price);
                }
                return new Trip(idTrip, idBike, userName, beginDate, null, origin, destination, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Trip with username:" + username);
    }
    
    /**
     * @param idBike
     * @param longitude
     * @param latitude
     */
    public void blockBike(String idBike) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call blockBike(?) }");

            callStmt.setString(1, idBike);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void addTrip(String idBike, String username, String date,int origin,int destination) {

        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{ call ADDTRIP(?,?,?,?,?) }");

            
            callStmt.setString(1, idBike);
            callStmt.setString(2, username);
            callStmt.setString(3, date);   
            callStmt.setInt(4, origin);
            callStmt.setInt(5, destination);
         
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addTripNotNull(int idBike, String username, String date,String endDate,int origin,int destination,float price) {

        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{ call ADDTRIPNOTNULL(?,?,?,?,?,?,?) }");

            
            callStmt.setInt(1, idBike);
            callStmt.setString(2, username);
            callStmt.setString(3, date);
            callStmt.setString(4, endDate);
            callStmt.setInt(5, origin);
            callStmt.setInt(6, destination);
            callStmt.setFloat(7,price);
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Trip getTrip(int id){
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getTrip(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setInt(2, id);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idTrip = rSet.getInt(1);
                String idBike = rSet.getString(2);
                String userName = rSet.getString(3);
                Timestamp dateTrip = rSet.getTimestamp(4);
                Calendar beginDate = Calendar.getInstance();
                beginDate.setTimeInMillis(dateTrip.getTime());
                Timestamp endDate = rSet.getTimestamp(5);
                Calendar finishDate = Calendar.getInstance();
                int origin = rSet.getInt(6);
                int destination = rSet.getInt(7);
                int price = rSet.getInt(8);
                if(endDate != null){
                    finishDate.setTimeInMillis(endDate.getTime());
                    return new Trip(idTrip, idBike, userName, beginDate, finishDate, origin, destination, price);
                }
                return new Trip(idTrip, idBike, userName, beginDate, null, origin, destination, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Trip with id:" + id);
    }
    
      public void updateTripPrice(int idTrip, float price) {
        try {
            openConnection();

            CallableStatement callStmt = getConnection().prepareCall("{ call updateTripPrice(?,?) }");

            callStmt.setInt(1, idTrip);
            callStmt.setFloat(2, price);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Trip with such id:" + idTrip);
    }
      
            public Trip getTripHavingBikeID(String idBike) {

        /* Objeto "callStmt" para invocar a função "getTripNotBlocked" armazenada na BD.
         *
         * FUNCTION getTripNotBlocked(username varchar) RETURN pkgTrip.ref_cursor
         * PACKAGE pkgSailors AS TYPE ref_cursor IS REF CURSOR; END pkgSailors;
         */
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getTripHavingBikeID(?) }");

            // Regista o tipo de dados SQL para interpretar o resultado obtido.
            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            // Especifica o parâmetro de entrada da função "getTripNotBlocked".
            callStmt.setString(2, idBike);

            // Executa a invocação da função "getTripHavingBikeID".
            callStmt.execute();

            // Guarda o cursor retornado num objeto "ResultSet".
            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idTrip = rSet.getInt(1);
                String id = rSet.getString(2);
                String userName = rSet.getString(3);
                Timestamp dateTrip = rSet.getTimestamp(4);
                Calendar beginDate = Calendar.getInstance();
                beginDate.setTimeInMillis(dateTrip.getTime());
                Timestamp endDate = rSet.getTimestamp(5);
                Calendar finishDate = Calendar.getInstance();
                int origin = rSet.getInt(6);
                int destination = rSet.getInt(7);
                int price = rSet.getInt(8);
                if(endDate != null){
                    finishDate.setTimeInMillis(endDate.getTime());
                    return new Trip(idTrip, id, userName, beginDate, finishDate, origin, destination, price);
                }
                return new Trip(idTrip, idBike, userName, beginDate, null, origin, destination, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Trip with idBike:" + idBike);
    }
}
