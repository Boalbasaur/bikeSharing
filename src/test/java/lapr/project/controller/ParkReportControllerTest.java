/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Bike;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabio Santos
 */
public class ParkReportControllerTest {
    
    @Test
    public void testGetBikesOnPark() {
        System.out.println("getBikesOnPark");
       
        
        List<Bike> result = ParkReportController.getBikesOnPark(1);
        assertEquals(2, result.size());
        
    }
    @Test
    public void testParkReportController(){
        System.out.println("parkReportController");
        double[] result =ParkReportController.ParkReportController(3);
        double expResult = 8333.333333333334;
        
        assertEquals(result[0],expResult);
    }
    
}
