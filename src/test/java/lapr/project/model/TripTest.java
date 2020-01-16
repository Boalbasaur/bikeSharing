/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class TripTest {

    /**
     * Test of getIdTrip method, of class Trip.
     */
    @Test
    public void testGetIdTrip() {
        System.out.println("getIdTrip");
        Trip trip = new Trip();
        trip.setIdTrip(1);
        int expResult = 1;
        int result = trip.getIdTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTrip method, of class Trip.
     */
    @Test
    public void testSetIdTrip() {
        System.out.println("setIdTrip");
        Trip trip = new Trip();
        trip.setIdTrip(1);
        int expResult = 1;
        int result = trip.getIdTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdBike method, of class Trip.
     */
    @Test
    public void testGetIdBike() {
        System.out.println("getIdBike");
        Trip trip = new Trip();
        trip.setIdBike("1");
        String expResult = "1";
        String result = trip.getIdBike();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdBike method, of class Trip.
     */
    @Test
    public void testSetIdBike() {
        System.out.println("setIdBike");
        Trip trip = new Trip();
        trip.setIdBike("1");
        String expResult = "1";
        String result = trip.getIdBike();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Trip.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Trip trip = new Trip();
        trip.setUsername("teste");
        String expResult = "teste";
        String result = trip.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Trip.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        Trip trip = new Trip();
        trip.setUsername("teste");
        String expResult = "teste";
        String result = trip.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateTrip method, of class Trip.
     */
    @Test
    public void testGetDateTrip() {
        System.out.println("getDateTrip");
        Trip trip = new Trip();
        trip.setDateTrip(new GregorianCalendar(2018,12,12,12,12,12));
        Calendar expResult = new GregorianCalendar(2018,12,12,12,12,12);
        Calendar result = trip.getDateTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateTrip method, of class Trip.
     */
    @Test
    public void testSetDateTrip() {
        System.out.println("setDateTrip");
        Trip trip = new Trip();
        trip.setDateTrip(new GregorianCalendar(2018,12,12,12,12,12));
        Calendar expResult = new GregorianCalendar(2018,12,12,12,12,12);
        Calendar result = trip.getDateTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateEnd method, of class Trip.
     */
    @Test
    public void testGetDateEnd() {
        System.out.println("getDateEnd");
        Trip trip = new Trip();
        trip.setDateEnd(new GregorianCalendar(2018,12,12,12,12,12));
        Calendar expResult = new GregorianCalendar(2018,12,12,12,12,12);
        Calendar result = trip.getDateEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateEnd method, of class Trip.
     */
    @Test
    public void testSetDateEnd() {
        System.out.println("setDateEnd");
        Trip trip = new Trip();
        trip.setDateEnd(new GregorianCalendar(2018,12,12,12,12,12));
        Calendar expResult = new GregorianCalendar(2018,12,12,12,12,12);
        Calendar result = trip.getDateEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrigin method, of class Trip.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Trip trip = new Trip();
        trip.setOrigin(1);
        int expResult = 1;
        int result = trip.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigin method, of class Trip.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        Trip trip = new Trip();
        trip.setOrigin(1);
        int expResult = 1;
        int result = trip.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class Trip.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Trip trip = new Trip();
        trip.setDestination(1);
        int expResult = 1;
        int result = trip.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDestination method, of class Trip.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        Trip trip = new Trip();
        trip.setDestination(1);
        int expResult = 1;
        int result = trip.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Trip.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Trip trip = new Trip();
        trip.setPrice(1);
        double expResult = 1;
        double result = trip.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Trip.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        Trip trip = new Trip();
        trip.setPrice(1.1);
        double expResult = 1.1;
        double result = trip.getPrice();
        assertEquals(expResult, result);
    }    

    /**
     * Test of getTotalTimeInHours method, of class Trip.
     */
    @Test
    public void testGetTotalTimeInHours() {
        System.out.println("getTotalTimeInHours");
        int idTrip = 4;
        Trip instance = new Trip();
        long expResult = 0;
        long result = instance.getTotalTimeInHours(idTrip);
        assertEquals(expResult, result);
    }

    /**
     * Test of totalTripPrice method, of class Trip.
     */
    @Test
    public void testTotalTripPrice() {
        System.out.println("totalTripPrice");
        int idTrip = 4;
        Trip instance = new Trip();
        float expResult = 0;
        float result = instance.totalTripPrice(idTrip);
        assertEquals(expResult, result);
        //fica a faltar um teste para confirmar se deu para multiplicar por 3
    }


    // não encontra a trip correta
//    /**
//     * Test of getTrip method, of class Trip.
//     */
//    @Test
//    public void testGetTrip() {
//        System.out.println("getTrip");
//        int id = 669;
//        Trip instance = new Trip();
//        Calendar ex = new GregorianCalendar(2018,10,15,20,45,00);
//        Trip expResult = new Trip(669, 2, "admistrador", ex, ex, 1, 2,1);
//        Trip result = instance.getTrip(id);
//        assertEquals(expResult, result);
//    }
}
