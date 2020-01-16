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
public class Receipt {
    
    private final int qty = 1;
    
    private String username;
    private String dateMonthYear;
    private float total;
    private float IVA;
    private float totalComIVA;
    private int points;

    public Receipt(String username, String dateMonthYear, float total, float IVA, float totalComIVA, int points) {
        this.username = username;
        this.dateMonthYear = dateMonthYear;
        this.total = total;
        this.IVA = IVA;
        this.totalComIVA = totalComIVA;
        this.points = points;
    }

    public int getQty() {
        return qty;
    }

    public String getUsername() {
        return username;
    }

    public String getDateMonthYear() {
        return dateMonthYear;
    }

    public float getTotal() {
        return total;
    }

    public float getIVA() {
        return IVA;
    }

    public float getTotalComIVA() {
        return totalComIVA;
    }

    public int getPoints() {
        return points;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDateMonthYear(String dateMonthYear) {
        this.dateMonthYear = dateMonthYear;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    public void setTotalComIVA(float totalComIVA) {
        this.totalComIVA = totalComIVA;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Receipt:\n" 
                + "username --- " + username+"\n"
                + "Qty  " + qty + "    dateMonthYear " + dateMonthYear + "  ------- Total:" + total+"\n"
                +"\t\t\t      -------"+ " IVA:" + IVA+"\n" 
                +"\t\t\t      -------"+" Total final:" + totalComIVA+"\n" 
                +"Points used: " + points
        + "\n\nThank you for your purchase!";
                
    }
    
    
    
}
