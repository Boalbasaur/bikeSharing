/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.ParkDB;
import lapr.project.data.UserDB;
import lapr.project.model.Park;
import lapr.project.ui.FreeParkingSpotsUI;

/**
 *
 * @author Asus
 */
public final class FreeParkingSpotsController {

    private FreeParkingSpotsController() {
        throw new IllegalStateException("Utility class");
    }

    public static int freeParkingSpots(String username, int parkID) {
        String bikeType;
        try {
            bikeType = findType(username);
        } catch (IllegalArgumentException ex) {
            bikeType = FreeParkingSpotsUI.BikeType();
        }
        return freeSpots(parkID, bikeType);
    }

    public static String findType(String username) {
        return new UserDB().getBikeType(username);
    }

    public static int freeSpots(int parkID, String bikeType) {
        Park park;
        try {
            park = new ParkDB().getPark(parkID);
        } catch (IllegalArgumentException ex) {
            System.out.println("Park id is invalid!");
            return -1;
        }
        if ("eletric".equalsIgnoreCase(bikeType)) {
            return new ParkDB().getAvailableEletricSlots(parkID);
        }
        return new ParkDB().getAvailableNonEletricSlots(parkID);
    }
}
