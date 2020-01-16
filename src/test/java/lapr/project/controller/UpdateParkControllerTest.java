/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;


import java.util.List;
import lapr.project.model.Bike;
import lapr.project.model.Park;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabio Santos
 */
public class UpdateParkControllerTest {

    public UpdateParkControllerTest() {
    }

    /**
     * Test of newPark method, of class UpdateParkController.
     */
    @Test
    public void testNewPark() {
        System.out.println("newPark");
        int id_park = 0;
        String name = "Porto";
        float x = 123.0F;
        float y = 123.0F;
        int normalSlots = 0;
        int eletricSlots = 0;
        float altitude = 0.0F;
        UpdateParkController.newPark(id_park, name, x, y, normalSlots, eletricSlots, altitude,0,0);;
        
    }

    /**
     * Test of getBikesOnPark method, of class UpdateParkController.
     */
    @Test
    public void testGetBikesOnPark() {
        System.out.println("getBikesOnPark");
       
        
        List<Bike> result = UpdateParkController.getBikesOnPark(1);
        assertEquals(2, result.size());
        
    }

    /**
     * Test of getPark method, of class UpdateParkController.
     */
    @Test
    public void testGetPark() {
        System.out.println("getPark");
        int id_park = 1;
       
        Park result = UpdateParkController.getPark(id_park);
        assertEquals(1, result.getIdPark());
       
    }

}
