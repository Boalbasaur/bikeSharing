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
 * @author franc
 */
public class AvailableBicyclesControllerTest {
    
        
    /**
     * Test of getAvailableBicycles method, of class AvailableBicyclesController.
     */
    @Test
    public void testGetAvailableBicycles() {
        System.out.println("getAvailableBicycles");
        int expResult = 2;
        int result = AvailableBicyclesController.getAvailableBicycles(2);
        assertEquals(expResult, result);
    }
    
}
