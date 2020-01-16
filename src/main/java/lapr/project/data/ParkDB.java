/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data;

/**
 *
 * @author Fabio Santos
 */
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lapr.project.model.Bike;
import lapr.project.model.Park;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Fabio Santos
 */
public class ParkDB extends DataHandler {

    /**
     * @param idPark
     * @return
     */
    public Park getPark(int idPark) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPark(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setInt(2, idPark);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                String name = rSet.getString(2);
                float latitude = rSet.getFloat(3);
                float longitude = rSet.getFloat(4);
                int capacityNonEletric = rSet.getInt(5);
                int capacityEletric = rSet.getInt(6);
                float altitude = rSet.getFloat(7);
                double vol = rSet.getDouble(8);
                double cur = rSet.getDouble(9);
                return new Park(idPark, name, latitude, longitude, capacityNonEletric, capacityEletric, altitude, vol, cur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Park with ID:" + idPark);
    }

    public String getMaxBike(int idPark) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getMaxEnergy(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setLong(2, idPark);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getString(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Bike with ID:" + idPark);
    }
    
    public String getFirstEletricalBikeMaxEnergy(int idPark) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getFirstEletricalBikeMaxEnergy(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setInt(2, idPark);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getString(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No batteryBikes" );
    }

    public ArrayList<Bike> getBikesOnPark(int idPark) {
        ArrayList<Bike> bikesList = new ArrayList<>();
        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call GETBIKESONPARK(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setInt(2, idPark);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            while (rSet.next()) {

                String idBike = rSet.getString(1);
                String idType = rSet.getString(2);
                int availability = rSet.getInt(3);
                String battery = rSet.getString(4);
                String maxCapacity = rSet.getString(5);
                int weight = rSet.getInt(6);
                double mechanicalCoefficient = rSet.getDouble(7);
                double aerodynamicCoefficient = rSet.getDouble(8);
                float parkLongitude = rSet.getFloat(9);
                float parkLatitude = rSet.getFloat(10);
                double area = rSet.getDouble(11);
                if ("eletric".equalsIgnoreCase(idType)) {
                    Bike eb = new Bike(idBike, idType, availability, battery, maxCapacity, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude, area);
                    bikesList.add(eb);
                } else {
                    Bike b = new Bike(idBike, idType, availability, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude, area);
                    bikesList.add(b);
                }

            }
            return bikesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Sailor with ID:" + idPark);
    }

    public int getAvailableBikes(int idPark) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getPark(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setInt(2, idPark);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                return rSet.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Park with ID:" + idPark);
    }

    public void addPark(Park park) {
        addPark(park.getIdPark(), park.getName(), park.getLatitude(), park.getLongitude(), park.getNormalSlots(), park.getEletricSlots(), park.getAltitude(), park.getVoltage(), park.getCurrent());
    }

    /**
     *
     */
    private void addPark(int idPark, String name, float latitude, float longitude, int capacityNonEletric, 
            int capacityEletric, float altitude, double voltage, double current) {

        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{ call addPark(?,?,?,?,?,?,?,?,?) }");

            callStmt.setInt(1, idPark);
            callStmt.setString(2, name);
            callStmt.setFloat(3, latitude);
            callStmt.setFloat(4, longitude);
            callStmt.setInt(5, capacityNonEletric);
            callStmt.setInt(6, capacityEletric);
            callStmt.setFloat(7, altitude);
            callStmt.setDouble(8, voltage);
            callStmt.setDouble(9, current);
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addParking(String idBike, int idPark, String date) {

        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{ call addParking(?,?,?) }");

            callStmt.setString(1, idBike);
            callStmt.setInt(2, idPark);
            callStmt.setString(3, date);
            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePark(Park a) {
        int i = validateLocationPark(a.getLatitude(), a.getLongitude());
        switch (i) {
            case 1:
                break;
            case 0:
                try {
                    new ParkDB().getPark(a.getIdPark());
                } catch (IllegalArgumentException ex) {
                    a.setIdPark(new ParkDB().generateParkID());
                    new ParkDB().addPark(a);}
                break;
            default:
                throw new IllegalArgumentException("Erro!");
        }
    }

    public static void delete(int idPark) {
        new ParkDB().removePark(idPark);
    }

    public void addBike1(String idBike, int idPark, String data) {

        new ParkDB().addParking(idBike,idPark, data);

    }

    /**
     * @param idPark
     */
    public void removePark(int idPark) {

        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{ call removePark(?) }");

            callStmt.setLong(1, idPark);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeBike(String idBike) {

        try {
            openConnection();
            CallableStatement callStmt = getConnection().prepareCall("{ call removeParking(?) }");

            callStmt.setString(1, idBike);

            callStmt.execute();

            closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param username
     * @return
     */
    public Park getParkUserLocation(String username) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkUserLocation(?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setString(2, username);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idPark = rSet.getInt(1);
                String name = rSet.getString(2);
                float latitude = rSet.getFloat(3);
                float longitude = rSet.getFloat(4);
                int capacityNonEletric = rSet.getInt(5);
                int capacityEletric = rSet.getInt(6);
                float altitude = rSet.getFloat(7);
                double vol = rSet.getDouble(8);
                double cur = rSet.getDouble(9);
                return new Park(idPark, name, latitude, longitude, capacityNonEletric, capacityEletric, altitude, vol, cur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Park for User with username:" + username);
    }

    public Park getParkHavingCoordinates(float longitude, float latitude) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getParkHavingCoordinates(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.CURSOR);
            callStmt.setFloat(2, longitude);
            callStmt.setFloat(3, latitude);

            callStmt.execute();

            ResultSet rSet = (ResultSet) callStmt.getObject(1);

            if (rSet.next()) {
                int idPark = rSet.getInt(1);
                String name = rSet.getString(2);
                float longit = rSet.getFloat(3);
                float lati = rSet.getFloat(4);
                int normalSlots = rSet.getInt(5);
                int electricSlots = rSet.getInt(6);
                float altitude = rSet.getFloat(7);
                double voltage = rSet.getDouble(8);
                double current = rSet.getDouble(9);
                return new Park(idPark, name, longit, lati, normalSlots, electricSlots, altitude, voltage, current);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public int validateLocationPark(float latitude, float longitude) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call validateLocationPark(?,?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            callStmt.setFloat(2, latitude);
            callStmt.setFloat(3, longitude);

            callStmt.execute();

            return callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");

    }

    public int generateParkID() {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call generateParkID() }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);

            callStmt.execute();

            return callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Can't generate new ID");

    }
        
    
    public int getAvailableEletricSlots(int parkID) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getAvailableEletric(?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            callStmt.setInt(2, parkID);

            callStmt.execute();

            return callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");

    }
    
        public int getAvailableNonEletricSlots(int parkID) {

        CallableStatement callStmt = null;
        try {
            callStmt = getConnection().prepareCall("{ ? = call getAvailableNonEletric(?) }");

            callStmt.registerOutParameter(1, OracleTypes.INTEGER);
            callStmt.setInt(2, parkID);

            callStmt.execute();

            return callStmt.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("");

    }
}
