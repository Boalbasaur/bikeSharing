/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;


import java.util.List;
import java.util.Scanner;
import lapr.project.controller.UpdateParkController;
import lapr.project.model.Bike;
import lapr.project.model.Park;

/**
 *
 * @author Fabio Santos
 */
public class UpdateParkUI {

    private UpdateParkUI() {
        throw new IllegalStateException("Utility class");
    }

    public static void updateParkUI() {

        int op;
        do {
            op = menuOptions();
            switch (op) {
                case 1:
                    newParkUI();
                    break;

                case 2:
                    getBikesOnParkUI();
                    break;

                case 3:
                    addBike();
                    break;

                case 4:
                    removeBike();
                    break;
                case 5:
                    deletePark();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } while (op != 6);

    }

    public static void newParkUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id Park:");
        int idPark = input.nextInt();
        System.out.println("Nome:");
        String name = input.nextLine();
        System.out.println("latitude:");
        float lat = input.nextFloat();
        System.out.println("longetividade:");
        float longe = input.nextFloat();
        System.out.println("altitude:");
        float altitude = input.nextFloat();
        System.out.println("normal slots:");
        int nSlots = input.nextInt();
        System.out.println("eletric slots:");
        int eSlots = input.nextInt();
        System.out.println("Park Voltage:");
        double vol = input.nextDouble();
        System.out.println("Park Current:");
        double cur = input.nextDouble();
        UpdateParkController.newPark(idPark, name, lat, longe, nSlots, eSlots, altitude,vol,cur);

    }

    public static List<Bike> getBikesOnParkUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("id park:");
        int idPark = input.nextInt();
        return UpdateParkController.getBikesOnPark(idPark);
    }

    public static void getPark() {
        Scanner input = new Scanner(System.in);
        System.out.println("id Park");
        int a = input.nextInt();
        UpdateParkController.getPark(a);
    }

    public static void addBike() {

        Scanner input = new Scanner(System.in);
        System.out.println("id park:");
        int idPark = input.nextInt();
        System.out.println("id bike:");
        String idBike = input.nextLine();
        System.out.println("id parking:");
        int idParking = input.nextInt();
        System.out.println("data:");
        String data = input.nextLine();
        UpdateParkController.addBike(idPark, idBike, data);
    }

    public static void removeBike() {
        Scanner input = new Scanner(System.in);
        System.out.println("id park:");
        int idPark = input.nextInt();
        System.out.println("id bike:");
        String idBike = input.nextLine();
        UpdateParkController.removeBike(idPark, idBike);
    }

    public static void deletePark() {
        Scanner input = new Scanner(System.in);
        System.out.println("id park:");
        int idPark = input.nextInt();
        UpdateParkController.deletePark(idPark);
    }

    public static int menuOptions() {
        Scanner ler = new Scanner(System.in);
        System.out.printf("\n\n(1) Add/Update Park \n(2) Get a List of bikes On the park\n(3) Add bike on park \n(4) Remove bike on park \n(5) Delete park \n(6) Back \nChoose your option:");
        int op = ler.nextInt();
        ler.nextLine();
        return op;
    }
    
    public static boolean existsPark(int idPark) {
        Park check = UpdateParkController.getPark(idPark);
        if (check == null) {
            return false;
        } else {
            return true;
        }
    }
}