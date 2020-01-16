/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.DistanceToParkController;
import lapr.project.model.Park;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class DistanceToParkUI {
    
    public boolean distanceToPark(String username) {
        Scanner scanner = new Scanner(System.in);
        String confirm = "";
        Park parkToCheck = null;
        Park userPark;
        double distance = 0;
        
        while (!confirm.equals("S")) {
            if(confirm.equals("N")){
                return false;
            }
            System.out.println("Do you want to calculate the distance to another park from your current location? (S or N)");
            confirm = scanner.next();
        }
        
        while(parkToCheck == null){
            System.out.println("Please insert the park's ID");
            confirm = scanner.next();
            parkToCheck = DistanceToParkController.getPark(confirm);
            if(parkToCheck == null){
                System.out.println("The park id you inserted doesn't exist!\nPlease insert a valid park id.\n");
            }
        }
        
        userPark = DistanceToParkController.getParkUserLocation(username);
        distance += DistanceToParkController.getDistanceBetweenTwoParks(parkToCheck, userPark);
        
        System.out.println("The distance between the park with id '" + parkToCheck.getIdPark() +"' and your current park is of " + distance + "km.");
        
        return true;
    }
}
