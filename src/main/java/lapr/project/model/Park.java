/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Fabio Santos
 */
import java.util.List;
import java.util.ListIterator;
import lapr.project.data.ParkDB;

/**
 *
 * @author Fabio Santos
 */
public class Park {

    private int idPark;
    private String name;
    private float longitude;
    private float latitude;
    private float altitude;
    private int normalSlots;
    private int eletricSlots;
    private double voltage;
    private double current;


    public Park(int id_park, String name, float longitude, float latitude, int normalSlots, int eletricSlots, float altitude, double voltage, double current) {
        this.idPark = id_park;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.normalSlots = normalSlots;
        this.eletricSlots = eletricSlots;
        this.voltage = voltage;
        this.current = current;
    }
    
    public Park (){
    }

    public static Park getPark(int id) {
        return new ParkDB().getPark(id);
    }

    public static Park getParkUserLocation(String username) {
        return new ParkDB().getParkUserLocation(username);
    }

    public static double getDistanceBetweenTwoParks(Park toCheck, Park userPark) {
        float userLongitude = userPark.getLongitude();
        float userLatitude = userPark.getLatitude();
        float userAltitude = userPark.getAltitude();
        float toCheckLongitude = toCheck.getLongitude();
        float toCheckLatitude = toCheck.getLatitude();
        float toCheckALtitude = toCheck.getAltitude();
        return Operations.distanceCalculator(toCheckLongitude, toCheckLatitude, toCheckALtitude, userLongitude, userLatitude, userAltitude);
    }

    public static List<Bike> getBikes(int id) {
        return new ParkDB().getBikesOnPark(id);
    }
    
    public static Bike getFirstBikeOnPark(int idPark){
        List<Bike> bikes = getBikes(idPark);
        ListIterator<Bike> itr = bikes.listIterator();
        Bike bike1;
        while(itr.hasNext()){
            bike1= itr.next();
            if(bike1.getAvailability() == 1){
                return bike1;
            }
        }
        return null;
    }
    
    public static String getFirstEltricalBikeMaxEnergy(int idPark){
        ParkDB pdb = new ParkDB();
        return pdb.getFirstEletricalBikeMaxEnergy(idPark);
    }

    public double getChargingSpeed() {
        return ((current * voltage) / 1000) / eletricSlots;
    }

    public static int getAvailableBikes(int idPark) {
        return new ParkDB().getAvailableBikes(idPark);
    }

    public static String getMaxBike(int idPark) {
        return new ParkDB().getMaxBike(idPark);
    }

    public double getVoltage() {
        return voltage;
    }

    public double getCurrent() {
        return current;
    }

    public int getIdPark() {
        return idPark;
    }

    public String getName() {
        return name;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public float getLatitude() {
        return this.latitude;
    }

    public int getNormalSlots() {
        return normalSlots;
    }

    public int getEletricSlots() {
        return eletricSlots;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setNormalSlots(int normalSlots) {
        this.normalSlots = normalSlots;
    }

    public void setEletricSlots(int eletricSlots) {
        this.eletricSlots = eletricSlots;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    
}
