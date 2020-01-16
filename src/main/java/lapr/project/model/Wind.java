/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Daniela Vinagreiro
 */
public class Wind {

    private String origin;
    private String destination;
    private double windspeed;
    private float crosswind;
    private double cineticFriction;

    public Wind(String origin, String destination, double windspeed, float crosswind, double friction) {
        this.origin = origin;
        this.destination = destination;
        this.crosswind = crosswind;
        this.windspeed = windspeed;
        this.cineticFriction = friction;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public float getCrosswind() {
        return crosswind;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public void setCrosswind(float crosswind) {
        this.crosswind = crosswind;
    }

    public double getCineticFriction() {
        return cineticFriction;
    }

    public void setCineticFriction(double cineticFriction) {
        this.cineticFriction = cineticFriction;
    }

    @Override
    public String toString() {
        return "Wind" + "windspeed=" + windspeed + ", crosswind=" + crosswind;
    }

}
