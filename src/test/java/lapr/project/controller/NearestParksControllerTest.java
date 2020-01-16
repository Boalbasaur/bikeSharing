/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Park;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Diogo Rolo
 */
public class NearestParksControllerTest {
    
    public NearestParksControllerTest() {
    }

    /**
     * Test of nearesParkController method, of class NearestParksController.
     */
    @Test
    public void testNearesParkController() {
        System.out.println("nearesParkController");
        float alt = 40.152699f;
        float lon = 8.609267f;
        float lat = 7.609267f;
        ArrayList<Park> expResult = new ArrayList<>();
        Park p =  new Park(1,"Porto", 123.0f, 123.0f, 1000, 150, 123.0f,0,0);;
        Park p1 = new Park(2,"Lisboa", 456.0f, 456.0f, 1500, 0, 456.0f,0,0);;
        Park p2 = new Park(3,"Aveiro", 250.0f, 250.0f, 0, 500, 250.0f,0,0);;
        Park p3 = new Park(666,"testePorto", 41.0f, -8.0f, 1000, 100, 84.0f,0,0);;
        Park p4 = new Park(667,"testeLisboa", 38.0f, -9.0f, 1500, 0, 11.0f,0,0);;
        expResult.add(p);
        expResult.add(p1);
        expResult.add(p2);
        expResult.add(p3);
        expResult.add(p4);
        List<Park> result = NearestParksController.nearesParkController(alt, lon, lat);
        expResult.equals(result);
    }
    
}

