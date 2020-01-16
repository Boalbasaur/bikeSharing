/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Bike;
import lapr.project.model.Operations;
import lapr.project.model.Park;

/**
 *
 * @author Fabio Santos
 */
public final class ParkReportController {

    private ParkReportController() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Bike> getBikesOnPark(int idPark) {
        return Park.getBikes(idPark);
    }

    public static double[] ParkReportController(int idPark) {
        List<Bike> bikes = getBikesOnPark(idPark);
        double[] timeForEach = new double[bikes.size()];
        int i = 0;
        for (Bike a : bikes) {
            if ("eletric".equalsIgnoreCase(a.getIdType())) {
                timeForEach[i] = Operations.timeToCharge(Park.getPark(idPark),a);
                i++;
            }else{
                timeForEach[i] = 0;
                i++;
            }

        }
        return timeForEach;
    }

}

