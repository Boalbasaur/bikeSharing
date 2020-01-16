/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.controller.UpdateBikeController;
import lapr.project.controller.UpdateParkController;
import lapr.project.model.Bike;
import lapr.project.model.Park;

/**
 *
 * @author franc
 */
public class UpdateBikeUI {

    private UpdateBikeUI() {
        throw new IllegalStateException("Utility class");
    }
    

    public static void updateBicyclesUI() {

        int op;
        do {
            op = menuOptions();
            switch (op) {
                case 1:
                    addBikeUI();
                    break;

                case 2:
                    updateBikeUI();
                    break;

                case 3:
                    removeBikeUI();
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (op != 4);

    }

    public static void addBikeUI() {
        Scanner ler = new Scanner(System.in);
        String idType = "invalid";
        String battery;
        String maxCapacity;
        int option;
        String types = ("\n\n(1) Road bike \n(2) Mountain bike \n(3) Electric bike \n\nType of new bike:");
        while ("invalid".equals(idType)) {
            System.out.println(types);
            option = Integer.parseInt(ler.nextLine());
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
        System.out.println("Description: ");
        String description = ler.nextLine();
        System.out.println("Weight: ");
        int weight = ler.nextInt();
        System.out.println("Mechanical Coefficient: ");
        double mechanicalCoefficient = ler.nextDouble();
        System.out.println("Aerodynamic Coefficient: ");
        double aerodynamicCoefficient = ler.nextDouble();
        System.out.println("Weight: ");
        float parkLongitude = ler.nextFloat();
        System.out.println("Weight: ");
        float parkLatitude = ler.nextFloat();
        System.out.println("Area:");
        double area = ler.nextDouble();

        if ("eletric".equals(idType)) {
            System.out.println("Battery of electric bike: ");
            battery = ler.nextLine();
            System.out.println("Battery of electric bike: ");
            maxCapacity = ler.nextLine();
            UpdateBikeController.addData(description, idType, battery, maxCapacity, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude,area);
        } else {
            UpdateBikeController.addData(description, idType, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude);
        }

    }

    public static void updateBikeUI() {
        Scanner ler = new Scanner(System.in);
        String message1 = ("\nEnter the ID of the bike you want to update: ");
        System.out.println(message1);
        String id;
        int p;
        boolean check = false;
        do {
            id = ler.nextLine();
            check = existsBike(id);
            System.out.println("\nInsert a valid ID: ");
            id = ler.nextLine();
        } while (check == false);
        Bike bike = UpdateBikeController.getBike(id);

        String message2 = ("\n\n What information do you want to update? \n(1)Availability \n(2)Park \n");
        System.out.println(message2);
        int op = Integer.parseInt(ler.nextLine());
        if (op == 1) {
            System.out.println("\nInsert new availability value : \n(0) Not Available \n(1) Available \n");
            int a = Integer.parseInt(ler.nextLine());
            while (a != 0 || a != 1) {
                System.out.println("\nInsert a valid option: ");
            }
            bike.setAvailability(a);
            System.out.println("\nChanges executed with success! \n");
        } else {
            System.out.println("\nInsert the id of the park: ");
            do {
                p = Integer.parseInt(ler.nextLine());
                check = UpdateParkUI.existsPark(p);
                System.out.println("\nInsert a valid park id: ");
            } while (check == false);
            Park park = UpdateParkController.getPark(p);
            //park.addBike(bike.getIdBike());
            System.out.println("\nChanges executed with success! \n");
        }

    }

    public static void removeBikeUI() {
        Scanner ler = new Scanner(System.in);
        String message = ("\nEnter the ID of the bike you want to delete: ");
        System.out.println(message);
        String id;
        boolean check = false;
        do {
            id = ler.nextLine();
            check = existsBike(id);
            System.out.println("\nInsert a valid ID: ");
            id = ler.nextLine();
        } while (check == false);
        Bike bike = UpdateBikeController.getBike(id);
        System.out.println("\nEnter the ID of the park of the selected bike : ");
        int idPark = Integer.parseInt(ler.nextLine());

        System.out.println("\nDo you want to delete the selected bike? \n(1) Yes \n(2) No");
        int op = Integer.parseInt(ler.nextLine());
        if (op == 1) {
            UpdateBikeController.deleteBike(bike.getIdBike(), idPark);
            System.out.println("Bike deleted successfully!\n");
        } else {
            updateBicyclesUI();
        }
    }

    public static int menuOptions() {
        Scanner ler = new Scanner(System.in);
        System.out.printf("\n\n(1) Add bike \n(2) Update bike information \n(3) Remove bike \n(4) Back \nChoose your option:");
        int op = ler.nextInt();
        ler.nextLine();
        return op;
    }

    private static boolean existsBike(String idBike) {
        Bike check = UpdateBikeController.getBike(idBike);
        if (check == null) {
            return false;
        } else {
            return true;
        }
    }

}
