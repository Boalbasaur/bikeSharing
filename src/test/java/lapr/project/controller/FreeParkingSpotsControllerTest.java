/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Asus
 */
public class FreeParkingSpotsControllerTest {
    
    public FreeParkingSpotsControllerTest() {
    }

    /**
     * Test of freeParkingSpots method, of class FreeParkingSpotsController.
     */
    @Test
    public void testFreeParkingSpots() {
        System.out.println("freeParkingSpots");
        String username = "Filipa";
        int parkID = 1;
        int expResult = 1;
        int result = FreeParkingSpotsController.freeParkingSpots(username, parkID);
        assertEquals(expResult, result);
    }

    /**
     * Test of findType method, of class FreeParkingSpotsController.
     */
    @Test
    public void testFindType() {
        System.out.println("findType");
        String username = "Filipa";
        String expResult = "road";
        String result = FreeParkingSpotsController.findType(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of freeSpots method, of class FreeParkingSpotsController.
     */
    @Test
    public void testFreeSpots() {
        System.out.println("freeSpots");
        int parkID = 1;
        String bikeType = "road";
        int expResult = 1;
        int result = FreeParkingSpotsController.freeSpots(parkID, bikeType);
        assertEquals(expResult, result);
        bikeType = "eletric";
        expResult = 1;
        result = FreeParkingSpotsController.freeSpots(parkID, bikeType);
        assertEquals(expResult, result);
        parkID=0;
        expResult = -1;
        result = FreeParkingSpotsController.freeSpots(parkID, bikeType);
        assertEquals(expResult, result);
    }
    
}
