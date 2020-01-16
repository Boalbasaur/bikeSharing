/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.TouristPointController;
import lapr.project.model.TouristPoint;

/**
 *
 * @author Daniela Vinagreiro
 */
public class UpdateTouristPointUI {

    private UpdateTouristPointUI() {
        throw new IllegalStateException("Utility class");
    }
    
    
    
    public static void updateTouristPointUI() {

        int op;
        do {
            op = menuOptions();
            switch (op) {
                case 1:
                    newTouristPointUI();
                    break;
                    
                case 2:
                    deleteTouristPoint();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (op != 4);

    }

    public static void newTouristPointUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id Tourist Point:");
        int idTouristPoint = input.nextInt();
        System.out.println("Name:");
        String name = input.nextLine();
        System.out.println("Latitude:");
        float latitude = input.nextFloat();
        System.out.println("Longitude:");
        float longitude = input.nextFloat();
        System.out.println("Altitude:");
        float altitude = input.nextFloat();

        TouristPointController.newTouristPoint(idTouristPoint, name, latitude, longitude, altitude);

    }


    public static void getTouristPoint() {
        Scanner input = new Scanner(System.in);
        System.out.println("id tourist point");
        int a = input.nextInt();
        TouristPoint touristPoint = TouristPointController.getTouristPoint(a);
    }

    public static void deleteTouristPoint() {
        Scanner input = new Scanner(System.in);
        System.out.println("id park:");
        int idTouristPoint = input.nextInt();
        TouristPointController.deleteTouristPoint(idTouristPoint);
    }

    public static int menuOptions() {
        Scanner ler = new Scanner(System.in);
        System.out.printf("\n\n(1) Add/Update Tourist Point \n(2) Delete touristPoint \n(3) Back \nChoose your option:");
        int op = ler.nextInt();
        ler.nextLine();
        return op;
    }
    
    public static boolean existsTouristPoint(int idTouristPoint) {
        TouristPoint check = TouristPointController.getTouristPoint(idTouristPoint);
        if (check == null) {
            return false;
        } else {
            return true;
        }
    }
}
