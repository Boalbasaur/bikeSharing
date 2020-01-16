/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Park;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class DistanceToParkControllerTest {  

    /**
     * Test of getPark method, of class Park.
     */
    @Test
    public void testGetPark() {
        System.out.println("getPark");
        int id = 1;
        Park park = new Park(1, "name", 20f, 30f, 2, 2, 1,0,0);
        Park result = DistanceToParkController.getPark("1");
        assertEquals(park.getIdPark(), result.getIdPark());
    }

    /**
     * Test of getParkUserLocation method, of class DistanceToParkController.
     */
    @Test
    public void testGetParkUserLocation() {
        System.out.println("getParkUserLocation");
        Park park = new Park(666, "testePorto", 41, -8, 1000, 100, 84,0,0);
        Park result = DistanceToParkController.getParkUserLocation("testes");
        assertEquals(park.getIdPark(), result.getIdPark());
    }

    /**
     * Test of getDistanceBetweenTwoParks method, of class DistanceToParkController.
     */
    @Test
    public void testGetDistanceBetweenTwoParks() {
        System.out.println("getDistanceBetweenTwoParks");
        Park toCheck = new Park(667, "testeLisboa", 38, -9, 1500, 0, 11,0,0);
        Park userPark = new Park(666, "testePorto", 41, -8, 1000, 100, 84,0,0);
        int result = (int) DistanceToParkController.getDistanceBetweenTwoParks(toCheck, userPark);
        assertEquals(367, result);
    }
    
}
