/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;


import java.util.List;
import lapr.project.data.ParkDB;
import lapr.project.model.Bike;
import lapr.project.model.Park;

/**
 *
 * @author Fabio Santos
 */
public final class UpdateParkController {

    private UpdateParkController() {
        throw new IllegalStateException("Utility class");
    }
    

    public static void newPark(int id_park, String name, float x, float y, int normalSlots, int eletricSlots, float altitude, double voltage, double current) {

        Park pk = new Park(id_park, name, x, y, normalSlots, eletricSlots, altitude,voltage,current);
        ParkDB p = new ParkDB();
        p.savePark(pk);
    }

    public static List<Bike> getBikesOnPark(int idPark) {
       return Park.getBikes(idPark);
    }

    public static Park getPark(int id_park) {
        return Park.getPark(id_park);
    }

    public static void addBike(int id_park, String idBike, String data) {
        Park a = getPark(id_park);
        new ParkDB().addBike1(idBike,id_park, data);
    }

    public static void removeBike(int id_park,String idBike) {
        Park a = getPark(id_park);
        new ParkDB().removeBike(idBike);
    }
    
    public static void deletePark(int idPark){
        Park pk = getPark(idPark);
        ParkDB.delete(idPark);
    }
}
