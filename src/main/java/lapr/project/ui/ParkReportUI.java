/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import lapr.project.controller.ParkReportController;
import lapr.project.model.Bike;

/**
 *
 * @author Fabio Santos
 */
public class ParkReportUI {

    private ParkReportUI() {
        throw new IllegalStateException("Utility class");
    }
    

    public static void parkReportUI() {
        Scanner input = new Scanner(System.in);
        System.out.println("id park:");
        int idPark = input.nextInt();
        List<Bike> bikes = ParkReportController.getBikesOnPark(idPark);
        double[] timeForEachBike = ParkReportController.ParkReportController(idPark);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for (int i = 0; i < bikes.size(); i++) {
            System.out.println(bikes.get(i).getIdBike() + " time to charge: " + decimalFormat.format(timeForEachBike[i]) + "hours");
        }
    }
}
