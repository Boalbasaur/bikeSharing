/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Daniela Vinagreiro
 */
public class UserRegistrationControllerTest {
    
    public UserRegistrationControllerTest() {
    }
    
    

    /**
     * Test of setData method, of class UserRegistrationController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        String name = "Miguel";
        String username = "miguelito99";
        String email = "miguel99@gmail.com";
        String password = "321olaespaco";
        String creditCardNumber = "2134567898023456";
        double height = 1.99;
        double weight = 88;
        double avgSpeed=10f;
        UserRegistrationController.setData(name, username, email, password, creditCardNumber, height, weight, avgSpeed);
    }
    
}
