/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Diogo Rolo
 */
public class MonthlyTrips {
    
    private int idMonthlyTrip;
    private String dateMonthYear;
    private String username;
    private float totalPrice;
    private int monthPoints;

    public MonthlyTrips(int idMonthlyTrip, String dateMonthYear, String username, float totalPrice, int montthPoints) {
        this.idMonthlyTrip = idMonthlyTrip;
        this.dateMonthYear = dateMonthYear;
        this.username = username;
        this.totalPrice = totalPrice;
        this.monthPoints = monthPoints;
    }

    public int getMonthPoints() {
        return monthPoints;
    }

    public int getIdMonthlyTrip() {
        return idMonthlyTrip;
    }

    public String getDateMonthYear() {
        return dateMonthYear;
    }

    public String getUsername() {
        return username;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setIdMonthlyTrip(int idMonthlyTrip) {
        this.idMonthlyTrip = idMonthlyTrip;
    }

    public void setDateMonthYear(String dateMonthYear) {
        this.dateMonthYear = dateMonthYear;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setMonthPoints(int monthPoints) {
        this.monthPoints = monthPoints;
    }

    

    
}
