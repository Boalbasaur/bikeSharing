/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Bike;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class UpdateBikeControllerTest {
    
    /**
     * Test of getBike method, of class UpdateBikeController.
     */
    @Test
    public void testGetBike() {
        System.out.println("getBike");
        String idBike = "1";
        
        Bike result = UpdateBikeController.getBike(idBike);
        assertEquals("1", result.getIdBike());
    }
    
    

    
}
