/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Asus
 */
public class PathInfo {

    private Wind wind;
    private double distance;
    private double EnergyNeeded;
    private String origin;
    private String destination;
    private Bike bike;

    public PathInfo(Wind wind, double distance, double EnergyNeeded, String origin, String destination) {
        this.wind = wind;
        this.distance = distance;
        this.EnergyNeeded = EnergyNeeded;
        this.origin = origin;
        this.destination = destination;
    }

    public PathInfo(float windspeed, float crosswind, double distance, double EnergyNeeded, String origin, String destination, double cineticFriction) {
        this.wind = new Wind(origin, destination, windspeed, crosswind, cineticFriction);
        this.distance = distance;
        this.EnergyNeeded = EnergyNeeded;
        this.origin=origin;
        this.destination=destination;
    }
    
    public PathInfo(float windspeed, float crosswind, double distance, double EnergyNeeded, String origin, String destination) {
        this.wind = new Wind(origin, destination, windspeed, crosswind,0);
        this.distance = distance;
        this.EnergyNeeded = EnergyNeeded;
        this.origin=origin;
        this.destination=destination;
        
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    /**
     * @return the wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * @param wind the wind to set
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * @param origin
     * @param destination
     * @param windspeed
     * @param crosswind
     */
    public void setWind(String origin, String destination, float windspeed, float crosswind,double cineticFriction) {
        this.wind = new Wind(origin, destination, windspeed, crosswind, cineticFriction);
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return the EnergyNeeded
     */
    public double getEnergyNeeded() {
        return EnergyNeeded;
    }

    /**
     * @param EnergyNeeded the EnergyNeeded to set
     */
    public void setEnergyNeeded(double EnergyNeeded) {
        this.EnergyNeeded = EnergyNeeded;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "This path from " + origin + " to " + destination + " is " + distance + "km  long, it spends around " + EnergyNeeded + "kW?, the wind speed is " + wind.getWindspeed() + "m/s and the cross wind is " + wind.getCrosswind() + "m/s.";
    }
}
