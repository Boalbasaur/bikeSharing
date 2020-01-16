package lapr.project.controller;

import lapr.project.data.BikeDB;
import lapr.project.data.ParkDB;
import lapr.project.model.Bike;
import lapr.project.model.Park;

/**
 *
 * @author franc
 */
public final class UpdateBikeController {

    private UpdateBikeController() {
        throw new IllegalStateException("Utility class");
    }

    public static Bike getBike(String idBike) {
        return Bike.getBike(idBike);
    }

    public static void addData(String description, String idType, String battery, String max, int weight, double mechanicalCoefficient, double aerodynamicCoefficient, float parkLongitude, float parkLatitude, double area) {
        Bike bike = new Bike(description, idType, battery, max, weight, mechanicalCoefficient, aerodynamicCoefficient, parkLongitude, parkLatitude, area);
        new BikeDB().saveBike(bike);
    }

    public static void addData(String description, String idType, int weight, double mechanicalCoefficient, double aerodynamicCoefficient, float parkLongitude, float parkLatitude) {
        Bike bike = new Bike(description, idType);
        new BikeDB().saveBike(bike);
    }

    public static void deleteBike(String idBike, int idPark) {
        Park p = UpdateParkController.getPark(idPark);
        new ParkDB().removeBike(idBike);
        Bike b = Bike.getBike(idBike);
        new BikeDB().deleteBike(b);
    }

}
