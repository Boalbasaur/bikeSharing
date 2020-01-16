/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.FreeParkingSpotsController;

/**
 *
 * @author Asus
 */
public class FreeParkingSpotsUI {

    private FreeParkingSpotsUI() {
        throw new IllegalStateException("Utility class");
    }

    public static void freeParkingSpots(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Destination park id: ");
        int parkID = scanner.nextInt();
        int freeSpots = FreeParkingSpotsController.freeParkingSpots(username, parkID);
        if(freeSpots!=-1){
        System.out.println("There are "+freeSpots+" free spots.");
        }
    }
    public static String BikeType() {
        Scanner scanner = new Scanner(System.in);
        String types = "Bike type: \n(1) Road\n(2) Mountain\n(3) Eletric ";
        int option;
        String idType="invalid";
        while ("invalid".equals(idType)) {
            System.out.println(types);
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    idType = "road";
                    break;
                case 2:
                    idType = "mtb";
                    break;
                case 3:
                    idType = "eletric";
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        return idType;
    }
}
