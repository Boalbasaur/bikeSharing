/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.Park;

/**
 *
 * @author franc
 */
public final class AvailableBicyclesController {

    private AvailableBicyclesController() {
        throw new IllegalStateException("Utility class");
    }

    public static int getAvailableBicycles(int idPark) {
        int bikes = Park.getAvailableBikes(idPark);
        return bikes;
    }
    
}
