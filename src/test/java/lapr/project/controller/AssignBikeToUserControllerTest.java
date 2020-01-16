/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fabio Santos
 */
public class AssignBikeToUserControllerTest {

    public AssignBikeToUserControllerTest() {
    }

    /**
     * Test of AssignBikeToUserController method, of class
     * AssignBikeToUserController.
     */


    @Test
    public void testAssignBikeToUserController1() {
        System.out.println("AssignBikeToUserController");
        int idPark = 1;
        String idtype = "mtb";
        String username = "administrador";
        String dateTrip = "18.10.15 20:45:00,000000000";
        
        int origin = 1;
        int destination = 2;
        
        assertTrue(AssignBikeToUserController.assignBikeToUserController(idPark, idtype, username, dateTrip, origin, destination));

    }
    
    @Test
    public void testAssignBikeToUserController2() {
        System.out.println("AssignBikeToUserController");
        int idPark = 1;
        String idtype = "eletric";
        String username = "administrador";
        String dateTrip = "18.10.15 20:45:00,000000000";
        
        int origin = 1;
        int destination = 0;
        
        assertFalse(AssignBikeToUserController.assignBikeToUserController(idPark, idtype, username, dateTrip, origin, destination));

    }

}
