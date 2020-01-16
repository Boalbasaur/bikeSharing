/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.TouristPointDB;
import lapr.project.model.TouristPoint;

/**
 *
 * @author Daniela Vinagreiro
 */
public final class TouristPointController {

    private TouristPointController() {
        throw new IllegalStateException("Utility class");
    }

    public static void newTouristPoint(int idTouristPoint, String name, float latitude, float longitude, float altitude) {
        TouristPointDB tp = new TouristPointDB();
        tp.saveTouristPoint(new TouristPoint(idTouristPoint, name, latitude, longitude, altitude));
    }

     public static TouristPoint getTouristPoint(int id) {
        return new TouristPointDB().getTouristPoint(id);
    }


    public static void deleteTouristPoint(int idTouristPoint) {
        TouristPointDB.delete(idTouristPoint);
    }

}