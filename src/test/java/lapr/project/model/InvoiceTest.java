/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Diogo Rolo
 */
public class InvoiceTest {

    public InvoiceTest() {
    }

    /**
     * Test of getUsername method, of class Invoice.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        String expResult = "Diogo";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateMonthYear method, of class Invoice.
     */
    @Test
    public void testGetDateMonthYear() {
        System.out.println("getDateMonthYear");
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        String expResult = "1_18";
        String result = instance.getDateMonthYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmmissionDate method, of class Invoice.
     */
    @Test
    public void testGetEmmissionDate() {
        System.out.println("getEmmissionDate");
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        String expResult = "2018-10-10";
        String result = instance.getEmmissionDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotal method, of class Invoice.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        float expResult = 100f;
        float result = instance.getTotal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIVA method, of class Invoice.
     */
    @Test
    public void testGetIVA() {
        System.out.println("getIVA");
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        float expResult = 0.23f;
        float result = instance.getIVA();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Invoice.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Fabio";
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        instance.setUsername(username);
    }

    /**
     * Test of setDateMonthYear method, of class Invoice.
     */
    @Test
    public void testSetDateMonthYear() {
        System.out.println("setDateMonthYear");
        String dateMonthYear = "2_18";
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        instance.setDateMonthYear(dateMonthYear);
    }

    /**
     * Test of setEmmissionDate method, of class Invoice.
     */
    @Test
    public void testSetEmmissionDate() {
        System.out.println("setEmmissionDate");
        String emmissionDate = "2018-11-10";
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        instance.setEmmissionDate(emmissionDate);
    }

    /**
     * Test of setTotal method, of class Invoice.
     */
    @Test
    public void testSetTotal() {
        System.out.println("setTotal");
        int total = 90;
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 100f);
        instance.setTotal(total);
    }

    /**
     * Test of toString method, of class Invoice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 17f);
        String expResult = "Invoice:\n"
                + "\n"
                + "IVA = 0.23\n"
                + "Username = Diogo\n"
                + "Mes_Ano = 1_18\n"
                + "Emmission Date = 2018-10-10\n"
                + "total a pagar = 17.0euros";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of precoFinalComPontoseIva method, of class Invoice.
     */
    @Test
    public void testPrecoFinalComPontoseIva() {
        System.out.println("precoFinalComPontoseIva");
        int pointsUser = 15;
        Invoice instance = new Invoice("Diogo", "1_18", "2018-10-10", 17f);
        float expResult = 19.065f;
        float result = instance.precoFinalComPontoseIva(pointsUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of totalPontosPodemSerUtilizados method, of class Invoice.
     */
    @Test
    public void testTotalPontosPodemSerUtilizados() {
        System.out.println("totalPontosPodemSerUtilizados");
        int nPoints = 25;
        Invoice instance = new Invoice("Igor", "1_18", "2018-10-10", 1.5f);
        int expResult = 15;
        int result = instance.totalPontosPodemSerUtilizados( nPoints);
        assertEquals(expResult, result);
        
        System.out.println("totalPontosPodemSerUtilizados");
        int nPoints2 = 25;
        Invoice instance2 = new Invoice("Igor", "1_18", "2018-10-10", 2.5f);
        int expResult2 = 5;
        int result2 = instance2.totalPontosPodemSerUtilizados( nPoints2);
        assertEquals(expResult2, result2);
    
    }

}
