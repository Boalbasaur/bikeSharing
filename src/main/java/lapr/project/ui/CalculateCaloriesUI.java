/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.Scanner;
import lapr.project.adjacencyMap.Graph;
import lapr.project.model.Park;
import lapr.project.controller.CalculateCaloriesController;
import lapr.project.model.Bike;
import lapr.project.model.User;
import static lapr.project.model.Park.getPark;
import lapr.project.model.PathInfo;
import lapr.project.model.TouristPoint;
import static lapr.project.model.TouristPoint.getTouristPoint;
import lapr.project.model.Wind;

/**
 *
 * @author Daniela Vinagreiro
 */
public class CalculateCaloriesUI {

    private CalculateCaloriesUI() {
        throw new IllegalStateException("Utility class");
    }

    public static void calculateCaloriesUI(String username, Graph<String, PathInfo> grafo) {
        Scanner sc = new Scanner(System.in);
        float latitudeOrigin;
        float longitudeOrigin;
        float altitudeOrigin;
        float latitudeDestiny;
        float longitudeDestiny;
        float altitudeDestiny;
        String nameOrigin = "";
        String nameDestiny = "";

        int actualPlace = actualPlace();
        if (actualPlace == 1) {
            System.out.println("Id origin park:");
            int origin = sc.nextInt();
            nameOrigin = "Park_" + origin;
            Park parkOrigin = CalculateCaloriesController.getPark(origin);
            latitudeOrigin = parkOrigin.getLatitude();
            longitudeOrigin = parkOrigin.getLongitude();
            altitudeOrigin = parkOrigin.getAltitude();
        } else {
            System.out.println("Id tourist point:");
            int origin = sc.nextInt();
            nameOrigin = "TouristPoint_" + origin;
            TouristPoint touristPoint = CalculateCaloriesController.getTouristPoint(origin);
            latitudeOrigin = touristPoint.getLatitude();
            longitudeOrigin = touristPoint.getLongitude();
            altitudeOrigin = touristPoint.getAltitude();
        }

        int whereTo = whereTo();
        if (whereTo == 1) {
            System.out.println("Id destiny park:");
            int destiny = sc.nextInt();
            Park parkDestiny = getPark(destiny);
            latitudeDestiny = parkDestiny.getLatitude();
            longitudeDestiny = parkDestiny.getLongitude();
            altitudeDestiny = parkDestiny.getAltitude();
        } else {
            System.out.println("Id destiny tourist point:");
            int destiny = sc.nextInt();
            TouristPoint touristPointDestiny = getTouristPoint(destiny);
            latitudeDestiny = touristPointDestiny.getLatitude();
            longitudeDestiny = touristPointDestiny.getLongitude();
            altitudeDestiny = touristPointDestiny.getAltitude();
        }

        Wind wind = CalculateCaloriesController.getWind(nameOrigin, nameDestiny, grafo);

        System.out.println("Duration of the trip: (in minutes)");
        int duration = sc.nextInt();
        User user = CalculateCaloriesController.getUser(username);

        System.out.println("Id bike:");
        String idBike = sc.nextLine();

        Bike bike = CalculateCaloriesController.getBike(idBike);
        String bikeType = bike.getIdType();
        double bikeWeight=bike.getWeight();
        double calories = CalculateCaloriesController.calculateCaloriesController(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        System.out.println("You've spent " + Math.round(calories) + " calories");
    }

    public static int bikeType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bike type: \n(1) Road\n(2) Mountain\n(3) Eletric ");
        return scanner.nextInt();
    }

    public static int actualPlace() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where you at? \n(1) Park\n(2) Tourist Point\n");
        return scanner.nextInt();
    }

    public static int whereTo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You want to go to a?\n(1) Park\n(2) TouristPoint\n");
        return scanner.nextInt();
    }
}
