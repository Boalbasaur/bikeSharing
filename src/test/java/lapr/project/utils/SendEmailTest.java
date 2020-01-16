/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class SendEmailTest {

    /**
     * Test of sendEmail method, of class SendEmail.
     */
    @Test
    public void testSendEmail() {
        System.out.println("sendEmail");
        String message = "Success!!!";
        SendEmail instance = new SendEmail();
        String receiverEmail = "1170657@isep.ipp.pt";
        String expResult = "Error";
        String result = instance.sendEmail(receiverEmail, message);
        assertEquals(expResult, result);
    }
    
}
