/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Park;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public final class DistanceToParkController {

    private DistanceToParkController() {
        throw new IllegalStateException("Utility class");
    }

    public static Park getPark(String confirm) {
        return Park.getPark(Integer.parseInt(confirm));
    }
    
    public static Park getParkUserLocation(String username) {
        return Park.getParkUserLocation(username);
    }
    
    public static double getDistanceBetweenTwoParks(Park toCheck, Park userPark){
        return Park.getDistanceBetweenTwoParks(toCheck, userPark);
    }    
}
