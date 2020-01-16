/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.AvailableBicyclesController;

/**
 *
 * @author franc
 */
public class AvailableBicyclesUI {

    private AvailableBicyclesUI() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void availableBicyclesUI() {
                
        Scanner read = new Scanner (System.in);
        System.out.println("\nEnter the id of the park: ");
        int idPark = read.nextInt();
        int availableBikes = AvailableBicyclesController.getAvailableBicycles(idPark);
        
        System.out.println("\nPark: " + idPark + "\nThere are " + availableBikes + " in this park.");
    }
}
