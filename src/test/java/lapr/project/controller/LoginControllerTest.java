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
 * @author Asus
 */
public class LoginControllerTest {

    /**
     * Test of loginController method, of class LoginController.
     */
    @Test
    public void testLoginController() {
        System.out.println("loginController");
        String username = "administrador";
        String password = "qwerty";
        boolean expResult = false;
        boolean result = LoginController.loginController(username,"wrongPassword");
        assertEquals(expResult, result);
        expResult = true;
        result = LoginController.loginController(username, password);
        assertEquals(expResult, result);
        expResult = false;
        result = LoginController.loginController("NomeDeTesteParaLogin","passwordRandom");
        assertEquals(expResult, result);
        
    }
    
}
