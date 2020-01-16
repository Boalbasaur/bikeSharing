/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class Path implements Comparable<Path> {

    private LinkedList<LinkedList<String>> route;
    private double distance;
    private double energyNeeded;
    private int elevation;

    public Path(LinkedList<LinkedList<String>> route, double distance, double energyNeeded, int elevation) {
        this.route = route;
        this.distance = distance;
        this.energyNeeded = energyNeeded;
        this.elevation = elevation;
    }

    public Path(LinkedList<LinkedList<String>> route, double distanceOrEnergy, boolean isDistance) {
        this.route = route;
        if(isDistance){
        this.distance = distanceOrEnergy;
        this.energyNeeded=-1;
        }else{
        this.energyNeeded = distanceOrEnergy;
        this.distance=-1;
        }
    }

    /**
     * @return the route
     */
    public LinkedList<LinkedList<String>> getRoute() {
        return route;
    }

    /**
     * @param route the path to set
     */
    public void setRoute(LinkedList<LinkedList<String>> route) {
        this.route = route;
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
     * @return the energyNeeded
     */
    public double getEnergyNeeded() {
        return energyNeeded;
    }

    /**
     * @param energyNeeded the energyNeeded to set
     */
    public void setEnergyNeeded(double energyNeeded) {
        this.energyNeeded = energyNeeded;
    }

    /**
     * @return the elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * @param elevation the elevation to set
     */
    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    @Override
    public int compareTo(Path other) {
        if (Math.round(this.distance)==-1) {
            return Double.compare(this.energyNeeded, other.energyNeeded);
        }
        return Double.compare(this.distance, other.distance);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.route);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.energyNeeded) ^ (Double.doubleToLongBits(this.energyNeeded) >>> 32));
        hash = 67 * hash + this.elevation;
        return hash;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Path other = (Path) obj;
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(other.distance)) {
            return false;
        }
        if (Double.doubleToLongBits(this.energyNeeded) != Double.doubleToLongBits(other.energyNeeded)) {
            return false;
        }
        if (this.elevation != other.elevation) {
            return false;
        }
        return Objects.equals(this.route, other.route);
    }

}
