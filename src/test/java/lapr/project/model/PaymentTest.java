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
 * @author Asus
 */
public class PaymentTest {
    
    public PaymentTest() {
    }
    

    /**
     * Test of getIdPayment method, of class Payment.
     */
    @Test
    public void testGetIdPayment() {
        System.out.println("getIdPayment");
        Payment instance = new Payment(1,1,"10/10/2010");
        int expResult = 1;
        int result = instance.getIdPayment();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPayment method, of class Payment.
     */
    @Test
    public void testSetIdPayment() {
        System.out.println("setIdPayment");
        int idPayment = 2;
        Payment instance = new Payment(1,1,"10/10/2010");
        instance.setIdPayment(idPayment);
        int expResult = 2;
        int result = instance.getIdPayment();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdInvoice method, of class Payment.
     */
    @Test
    public void testGetIdInvoice() {
        System.out.println("getIdInvoice");
        Payment instance = new Payment(1,1,"10/10/2010");
        int expResult = 1;
        int result = instance.getIdInvoice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdInvoice method, of class Payment.
     */
    @Test
    public void testSetIdInvoice() {
        System.out.println("setIdInvoice");
        int idInvoice = 2;
        Payment instance = new Payment(1,1,"10/10/2010");
        instance.setIdInvoice(idInvoice);
        int expResult = 2;
        int result = instance.getIdInvoice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPaymentDate method, of class Payment.
     */
    @Test
    public void testGetPaymentDate() {
        System.out.println("getPaymentDate");
        Payment instance = new Payment(1,1,"10/10/2010");
        String expResult = "10/10/2010";
        String result = instance.getPaymentDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPaymentDate method, of class Payment.
     */
    @Test
    public void testSetPaymentDate() {
        System.out.println("setPaymentDate");
        String paymentDate = "12/10/2010";
        Payment instance = new Payment(1,1,"10/10/2010");
        instance.setPaymentDate(paymentDate);
        String expResult = "12/10/2010";
        String result = instance.getPaymentDate();
        assertEquals(expResult, result);
    }
    
}
