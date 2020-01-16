/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;


import java.util.ArrayList;
import java.util.List;
import lapr.project.data.GetParksDB;
import lapr.project.model.Operations;
import lapr.project.model.Park;

/**
 *
 * @author Diogo Rolo
 */
public final class NearestParksController {

    private NearestParksController() {
        throw new IllegalStateException("Utility class");
    }
  
    public static List<Park> nearesParkController(float alt, float lon, float lat) {
        GetParksDB gpdb = new GetParksDB();
        Operations op = new Operations();
        ArrayList<Park> rp = (ArrayList<Park>) gpdb.getParks();
        return op.nearestBicycleParks(lon, lat, alt, rp);
    }

}

