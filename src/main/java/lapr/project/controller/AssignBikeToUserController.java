/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.data.TripDB;
import lapr.project.model.Bike;
import lapr.project.model.Operations;
import lapr.project.model.Park;

/**
 *
 * @author Fabio Santos
 */
public final class AssignBikeToUserController {

    private AssignBikeToUserController() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean assignBikeToUserController(int idPark, String idType, String username, String dateTrip, int origin, int destination) {
        boolean a = false;
        boolean b = false;
        String idBike = "";
        if (idType.equals("eletric") && destination != 0) {
            idBike = Park.getMaxBike(idPark);

            b = Operations.enoughBattery(origin, destination, idBike,username);

        } else {
            List<Bike> list = Park.getBikes(idPark);
            idBike = list.get(0).getIdBike();
        }
        if (!(idType.equals("eletric") && b == false)) {

            new TripDB().addTrip(idBike, username, dateTrip, origin, destination);
            a = true;

        }
        return a;
    }

}
