/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.UserDB;
import lapr.project.model.User;

/**
 *
 * @author Daniela Vinagreiro
 */
public final class UserRegistrationController {

    private UserRegistrationController() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void setData (String name, String username, String email, String password, String creditCardNumber, double height, double weight, double avgSpeed){
         UserDB.save(new User (name, username, email, password, creditCardNumber, height, weight, avgSpeed));
         
    }


    
}

