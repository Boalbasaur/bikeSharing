/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Diogo Rolo
 */
public class MonthlyTripsTest {
    
    public MonthlyTripsTest() {
    }

    /**
     * Test of getDateMonthYear method, of class MonthlyTrips.
     */
    @Test
    public void testGetDateMonthYear() {
        System.out.println("getDateMonthYear");
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        String expResult = "1_18";
        String result = instance.getDateMonthYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class MonthlyTrips.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        String expResult = "Diogo";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdTrip method, of class MonthlyTrips.
     */
    @Test
    public void testGetIdTrip() {
        System.out.println("getIdTrip");
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        int expResult = 1;
        int result = instance.getIdMonthlyTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalPrice method, of class MonthlyTrips.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        float expResult = 30;
        float result = instance.getTotalPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateMonthYear method, of class MonthlyTrips.
     */
    @Test
    public void testSetDateMonthYear() {
        System.out.println("setDateMonthYear");
        String dateMonthYear = "2_18";
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        instance.setDateMonthYear(dateMonthYear);
    }

    /**
     * Test of setUsername method, of class MonthlyTrips.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Bruno";
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        instance.setUsername(username);
    }

    /**
     * Test of setIdTrip method, of class MonthlyTrips.
     */
    @Test
    public void testSetIdTrip() {
        System.out.println("setIdTrip");
        int idTrip = 0;
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        instance.setIdMonthlyTrip(idTrip);
    }

    /**
     * Test of setTotalPrice method, of class MonthlyTrips.
     */
    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        int totalPrice = 0;
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        instance.setTotalPrice(totalPrice);
    }

    /**
     * Test of getMonthPoints method, of class MonthlyTrips.
     */
    @Test
    public void testGetMonthPoints() {
        System.out.println("getMonthPoints");
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        int expResult = 0;
        int result = instance.getMonthPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdMonthlyTrip method, of class MonthlyTrips.
     */
    @Test
    public void testGetIdMonthlyTrip() {
        System.out.println("getIdMonthlyTrip");
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        int expResult = 1;
        int result = instance.getIdMonthlyTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdMonthlyTrip method, of class MonthlyTrips.
     */
    @Test
    public void testSetIdMonthlyTrip() {
        System.out.println("setIdMonthlyTrip");
        int idMonthlyTrip = 2;
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);
        instance.setIdMonthlyTrip(idMonthlyTrip);
    }

    /**
     * Test of setMonthPoints method, of class MonthlyTrips.
     */
    @Test
    public void testSetMonthPoints() {
        System.out.println("setMonthPoints");
        int monthPoints = 3;
        MonthlyTrips instance = new MonthlyTrips(1, "1_18", "Diogo", 30,0);;
        instance.setMonthPoints(monthPoints);
    }
    
}
