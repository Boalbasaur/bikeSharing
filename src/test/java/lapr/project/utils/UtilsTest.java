/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    /**
     * Test of hoursBetween method, of class Utils.
     */
    @Test
    public void testHoursBetween() {
        System.out.println("hoursBetween");
        Calendar startDate = new GregorianCalendar(2018, 0, 20, 11, 27, 56);
        Calendar endDate = new GregorianCalendar(2018, 0, 20, 13, 27, 56);
        Utils mockUtils = new Utils();
        long expResult = 2;
        long result = mockUtils.hoursBetween(startDate, endDate);
        System.out.println(mockUtils.hoursBetween(startDate, endDate));
        assertEquals(expResult, result);
    }
    
}
