/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Fabio Santos
 */
public class RequestTest {
    
    public RequestTest() {
    }
    

    /**
     * Test of getIdRequest method, of class Request.
     */
    @Test
    public void testGetIdRequest() {
        System.out.println("getIdRequest");
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        int expResult = 1;
        int result = instance.getIdRequest();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIdRequest method, of class Request.
     */
    @Test
    public void testSetIdRequest() {
        System.out.println("setIdRequest");
        int idRequest = 1;
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        instance.setIdRequest(idRequest);
        
    }

    /**
     * Test of getIdPark method, of class Request.
     */
    @Test
    public void testGetIdPark() {
        System.out.println("getIdPark");
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        int expResult = 1;
        int result = instance.getIdPark();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setIdPark method, of class Request.
     */
    @Test
    public void testSetIdPark() {
        System.out.println("setIdPark");
        int idPark = 1;
       Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        instance.setIdPark(idPark);
        
    }

    /**
     * Test of getUsername method, of class Request.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        String expResult = "username";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setUsername method, of class Request.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        instance.setUsername(username);

    }

    /**
     * Test of getDateRequest method, of class Request.
     */
    @Test
    public void testGetDateRequest() {
        System.out.println("getDateRequest");
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        String expResult = "18.12.16 04:15:32,653787000";
        String result = instance.getDateRequest();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setDateRequest method, of class Request.
     */
    @Test
    public void testSetDateRequest() {
        System.out.println("setDateRequest");
        String dateRequest = "18.12.16 04:15:32,653787000";
        Request instance = new Request(1, 1, "username", "18.12.16 04:15:32,653787000");
        instance.setDateRequest(dateRequest);
       
    }
    
}
