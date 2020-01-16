package lapr.project.model;

import lapr.project.data.BikeDB;

/**
 *
 * @author franc
 */
public class Bike {

    private final String description;
    private String idType;
    private int availability;
    private String battery;
    private String maxCapacity;
    private int weight;
    private double mechanicalCoefficient;
    private double aerodynamicCoefficient;
    private float parkLongitude;
    private float parkLatitude;
    private double area;
    private static final int AVAILABILITY_BY_DEFAULT = 1;
    private static final double ROAD_BIKE_WEIGHT = 10;
    private static int DEFAULT_WEIGHT = 10;

    public Bike(String description, String idType) {
        this.description = description;
        this.idType = idType;
        this.availability = AVAILABILITY_BY_DEFAULT;
        this.weight = DEFAULT_WEIGHT;
        this.battery = null;
        this.maxCapacity = null;
        this.weight = 0;
        this.mechanicalCoefficient = 0;
        this.aerodynamicCoefficient = 0;
        this.parkLongitude = 0;
        this.parkLatitude = 0;
        this.area = 0;
    }

    public Bike(String description, String idType, String battery, String maxCapacity, int weight, double mechanicalCoefficient,
            double aerodynamicCoefficient,
            float parkLongitude,
            float parkLatitude,double area) {
        this.description = description;
        this.idType = idType;
        this.availability = AVAILABILITY_BY_DEFAULT;
        this.battery = battery;
        this.maxCapacity = maxCapacity;
        this.weight = weight;
        this.mechanicalCoefficient = mechanicalCoefficient;
        this.aerodynamicCoefficient = aerodynamicCoefficient;
        this.parkLongitude = parkLongitude;
        this.parkLatitude = parkLatitude;
        this.area = area;
    }

    public Bike(String description, String idType, int availability, int weight, double mechanicalCoefficient,
            double aerodynamicCoefficient,
            float parkLongitude,
            float parkLatitude,double area) {
        this.description = description;
        this.idType = idType;
        this.availability = availability;
        this.weight = weight;
        this.mechanicalCoefficient = mechanicalCoefficient;
        this.aerodynamicCoefficient = aerodynamicCoefficient;
        this.parkLongitude = parkLongitude;
        this.parkLatitude = parkLatitude;
        this.area = area;
    }

    public Bike(String description, String idType, int availability, String battery, String maxCapacity, int weight, double mechanicalCoefficient,
            double aerodynamicCoefficient,
            float parkLongitude,
            float parkLatitude, double area) {
        this.description = description;
        this.idType = idType;
        this.availability = availability;
        this.battery = battery;
        this.maxCapacity = maxCapacity;
        this.weight = weight;
        this.mechanicalCoefficient = mechanicalCoefficient;
        this.aerodynamicCoefficient = aerodynamicCoefficient;
        this.parkLongitude = parkLongitude;
        this.parkLatitude = parkLatitude;
        this.area = area;
    }

    public static Bike getBike(String idBike) {
        return new BikeDB().getBike(idBike);
    }

    public static int getDEFAULT_WEIGHT() {
        return DEFAULT_WEIGHT;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getMaxCapacity() {
        return maxCapacity;
    }

    public String getIdBike() {
        return description;
    }

    public String getIdType() {
        return idType;
    }

    public int getAvailability() {
        return availability;
    }

    public String getBattery() {
        return battery;
    }

    public double getRoadWeight() {
        return ROAD_BIKE_WEIGHT;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    /**
     * @return the mechanicalCoefficient
     */
    public double getMechanicalCoefficient() {
        return mechanicalCoefficient;
    }

    /**
     * @param mechanicalCoefficient the mechanicalCoefficient to set
     */
    public void setMechanicalCoefficient(double mechanicalCoefficient) {
        this.mechanicalCoefficient = mechanicalCoefficient;
    }

    /**
     * @return the aerodynamicCoefficient
     */
    public double getAerodynamicCoefficient() {
        return aerodynamicCoefficient;
    }

    /**
     * @param aerodynamicCoefficient the aerodynamicCoefficient to set
     */
    public void setAerodynamicCoefficient(double aerodynamicCoefficient) {
        this.aerodynamicCoefficient = aerodynamicCoefficient;
    }

    /**
     * @return the parkLongitude
     */
    public float getParkLongitude() {
        return parkLongitude;
    }

    /**
     * @param parkLongitude the parkLongitude to set
     */
    public void setParkLongitude(float parkLongitude) {
        this.parkLongitude = parkLongitude;
    }

    /**
     * @return the parkLatitude
     */
    public float getParkLatitude() {
        return parkLatitude;
    }

    /**
     * @param parkLatitude the parkLatitude to set
     */
    public void setParkLatitude(float parkLatitude) {
        this.parkLatitude = parkLatitude;
    }
    
    @Override
    public String toString() {
        return String.format("ID Bike: %s Type: %s Availability: %d",
                description, idType, availability);
    }
}
