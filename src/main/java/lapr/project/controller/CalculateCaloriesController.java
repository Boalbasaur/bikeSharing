/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.adjacencyMap.Graph;
import lapr.project.data.BikeDB;
import lapr.project.data.ParkDB;
import lapr.project.data.TouristPointDB;
import lapr.project.data.UserDB;
import lapr.project.model.Bike;
import lapr.project.model.Operations;
import lapr.project.model.Park;
import lapr.project.model.PathInfo;
import lapr.project.model.TouristPoint;
import lapr.project.model.User;
import lapr.project.model.Wind;

/**
 *
 * @author Daniela Vinagreiro
 */
public final class CalculateCaloriesController {

    private CalculateCaloriesController() {
        throw new IllegalStateException("Utility class");
    }

    public static Wind getWind(String nameOrigin, String nameDestiny, Graph<String, PathInfo> grafo) {

        return grafo.getEdge(nameOrigin, nameDestiny).getElement().getWind();
    }

    public static User getUser(String username) {
        return new UserDB().getUser(username);
    }

    public static Bike getBike(String idBike) {
        return new BikeDB().getBike(idBike);
    }

    public static Park getPark(int id) {
        return new ParkDB().getPark(id);
    }

    public static TouristPoint getTouristPoint(int id) {
        return new TouristPointDB().getTouristPoint(id);
    }

    public static double calculateCaloriesController(float latitudeOrigin, float longitudeOrigin, float altitudeOrigin, float latitudeDestiny, float longitudeDestiny, float altitudeDestiny, int duration, User user, String bikeType, double bikeWeight, Wind wind) {

        return Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny,
                longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);

    }

}
