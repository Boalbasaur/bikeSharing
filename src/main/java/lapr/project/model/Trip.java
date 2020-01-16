/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Calendar;
import lapr.project.data.TripDB;
import lapr.project.utils.Utils;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class Trip {

    private int idTrip;
    private String idBike;
    private String username;
    private Calendar dateTrip;
    private Calendar dateEnd;
    private int origin;
    private int destination;
    private double price;

    public Trip(int idTrip, String idBike, String username, Calendar dateTrip, Calendar dateEnd, int origin, int destination, double price) {
        this.idTrip = idTrip;
        this.idBike = idBike;
        this.username = username;
        this.dateTrip = dateTrip;
        this.dateEnd = dateEnd;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public Trip() {

    }

    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public String getIdBike() {
        return idBike;
    }

    public void setIdBike(String idBike) {
        this.idBike = idBike;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Calendar getDateTrip() {
        return dateTrip;
    }

    public void setDateTrip(Calendar dateTrip) {
        this.dateTrip = dateTrip;
    }

    public Calendar getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Calendar dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTotalTimeInHours(int idTrip) {
        Utils u = new Utils();
        TripDB t = new TripDB();
        Trip tri = t.getTrip(idTrip);
        Calendar dataEnd = tri.getDateTrip();
        Calendar dataTrip = tri.getDateEnd();
        return u.hoursBetween(dataEnd, dataTrip);
    }

    public float totalTripPrice(int idTrip) {
        float cost = 0;
        long totalHours = getTotalTimeInHours(idTrip);
        if (totalHours > 1) {
            cost = (float) totalHours * 3;
            return cost;
        }
        return cost;
    }

    /**
     *
     * @param username
     * @return
     */
    public Trip getTripNotBlocked(String username) {
        return new TripDB().getTripNotBlocked(username);
    }
    
    public Trip getTripHavingBikeID(String idBike){
        return new TripDB().getTripHavingBikeID(idBike);
    }

    public void blockBike(String idBike) {
        TripDB t = new TripDB();
        t.blockBike(idBike);
    }

    public Trip getTrip(int id) {
        return new TripDB().getTrip(id);
    }
}
