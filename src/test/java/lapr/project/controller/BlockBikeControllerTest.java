/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import lapr.project.model.Trip;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class BlockBikeControllerTest {
    
    public BlockBikeControllerTest() {
    }

    /**
     * Test of getTripNotBlocked method, of class BlockBikeController.
     */
    @Test
    public void testGetTripNotBlocked() {
        System.out.println("getTripNotBlocked");
        Calendar begin = new GregorianCalendar(2018, 12, 01, 00, 00, 00);
        begin.setTimeInMillis(0);
        Trip t1 = new Trip(666, "666", "testes", begin, null, 666, 667, 1.0);
        String username = "testes";
        BlockBikeController controller = new BlockBikeController();
        Trip t2 = controller.getTripNotBlocked(username);
        String expResult = t1.getUsername();
        String result = t2.getUsername();
        assertEquals(expResult, result);
        expResult = t1.getIdBike();
        result = t2.getIdBike();
        assertEquals(expResult, result);
        int expResult2 = t1.getIdTrip();
        int result2 = t2.getIdTrip();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getTrip method, of class BlockBikeController.
     */
    @Test
    public void testGetTrip() {
        System.out.println("getTrip");
        Calendar begin = new GregorianCalendar(2018, 12, 01, 00, 00, 00);
        begin.setTimeInMillis(0);
        Trip t1 = new Trip(666, "666", "testes", begin, begin, 666, 667, 1.0);
        int id = 666;
        BlockBikeController controller = new BlockBikeController();
        Trip t2 = controller.getTrip(id);
        String expResult = t1.getUsername();
        String result = t2.getUsername();
        assertEquals(expResult, result);
        expResult = t1.getIdBike();
        result = t2.getIdBike();
        assertEquals(expResult, result);
        int expResult2 = t1.getIdTrip();
        int result2 = t2.getIdTrip();
        assertEquals(expResult2, result2);
    }

    
}
