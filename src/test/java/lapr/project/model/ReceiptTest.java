/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Diogo Rolo
 */
public class ReceiptTest {
    
    public ReceiptTest() {
    }

    /**
     * Test of getQty method, of class Receipt.
     */
    @Test
    public void testGetQty() {
        System.out.println("getQty");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        int expResult = 1;
        int result = instance.getQty();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Receipt.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);;
        String expResult = "Bro";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateMonthYear method, of class Receipt.
     */
    @Test
    public void testGetDateMonthYear() {
        System.out.println("getDateMonthYear");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        String expResult = "2_18";
        String result = instance.getDateMonthYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class Receipt.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        float expResult = 22F;
        float result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIVA method, of class Receipt.
     */
    @Test
    public void testGetIVA() {
        System.out.println("getIVA");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        float expResult = 0.23F;
        float result = instance.getIVA();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalComIVA method, of class Receipt.
     */
    @Test
    public void testGetTotalComIVA() {
        System.out.println("getTotalComIVA");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        float expResult = 24.5f;
        float result = instance.getTotalComIVA();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoints method, of class Receipt.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        int expResult = 25;
        int result = instance.getPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Receipt.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Broo";
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        instance.setUsername(username);
    }

    /**
     * Test of setDateMonthYear method, of class Receipt.
     */
    @Test
    public void testSetDateMonthYear() {
        System.out.println("setDateMonthYear");
        String dateMonthYear = "1_18";
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        instance.setDateMonthYear(dateMonthYear);
    }

    /**
     * Test of setTotal method, of class Receipt.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        float total = 24F;
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        instance.setTotal(total);
    }

    /**
     * Test of setIVA method, of class Receipt.
     */
    @Test
    public void testSetIVA() {
        System.out.println("setIVA");
        float IVA = 0.0F;
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        instance.setIVA(IVA);
    }

    /**
     * Test of setTotalComIVA method, of class Receipt.
     */
    @Test
    public void testSetTotalComIVA() {
        System.out.println("setTotalComIVA");
        float totalComIVA = 0.0F;
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        instance.setTotalComIVA(totalComIVA);
    }

    /**
     * Test of setPoints method, of class Receipt.
     */
    @Test
    public void testSetPoints() {
        System.out.println("setPoints");
        int points = 0;
        Receipt instance = new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        instance.setPoints(points);
    }

    /**
     * Test of toString method, of class Receipt.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Receipt instance =  new Receipt("Bro", "2_18", 22, 0.23f, 24.5f, 25);
        String result = instance.toString();
        String expResult = "Receipt:\n"
                + "username --- Bro\n"
                + "Qty  1    dateMonthYear 2_18  ------- Total:22.0\n"
                + "			      ------- IVA:0.23\n"
                + "			      ------- Total final:24.5\n"
                + "Points used: 25\n"
                + "\n"
                + "Thank you for your purchase!";
        assertEquals(expResult, result);
    }
    
}
