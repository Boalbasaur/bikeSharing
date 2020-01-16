/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.DecimalFormat;
import java.util.HashSet;
import lapr.project.adjacencyMap.Graph;
import lapr.project.model.Park;
import lapr.project.model.PathInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Asus
 */
public class SuggestedRoutesControllerTest {

    private Graph<String, PathInfo> grafo;

    public SuggestedRoutesControllerTest() {
        grafo = new Graph<>(true);
        grafo.insertVertex("Park_1");
        grafo.insertVertex("Park_2");
        grafo.insertVertex("Park_3");
        grafo.insertVertex("TouristPoint_1");
        grafo.insertVertex("TouristPoint_2");

        grafo.insertEdge("Park_1", "Park_2", new PathInfo(1f, 1f, 16, 17, "Park_1", "Park_2"), 0);
        grafo.insertEdge("Park_1", "Park_3", new PathInfo(1f, 1f, 15, 16, "Park_1", "Park_3"), 0);
        grafo.insertEdge("Park_1", "TouristPoint_1", new PathInfo(1f, 1f, 11, 21, "Park_1", "TouristPoint_1"), 0);
        grafo.insertEdge("Park_1", "TouristPoint_2", new PathInfo(1f, 1f, 10, 20, "Park_1", "TouristPoint_2"), 0);

        grafo.insertEdge("Park_2", "Park_1", new PathInfo(1f, 1f, 14, 16, "Park_2", "Park_1"), 0);
        grafo.insertEdge("Park_2", "Park_3", new PathInfo(1f, 1f, 14, 16, "Park_2", "Park_3"), 0);
        grafo.insertEdge("Park_2", "TouristPoint_1", new PathInfo(1f, 1f, 11, 21, "Park_1", "TouristPoint_1"), 0);
        grafo.insertEdge("Park_2", "TouristPoint_2", new PathInfo(1f, 1f, 11, 21, "Park_1", "TouristPoint_2"), 0);

        grafo.insertEdge("Park_3", "Park_1", new PathInfo(1f, 1f, 11, 21, "Park_3", "Park_1"), 0);
        grafo.insertEdge("Park_3", "Park_2", new PathInfo(1f, 1f, 11, 21, "Park_3", "Park_2"), 0);
        grafo.insertEdge("Park_3", "TouristPoint_1", new PathInfo(1f, 1f, 11, 21, "Park_3", "TouristPoint_1"), 0);
        grafo.insertEdge("Park_3", "TouristPoint_2", new PathInfo(1f, 1f, 11, 21, "Park_3", "TouristPoint_2"), 0);

        grafo.insertEdge("TouristPoint_1", "Park_1", new PathInfo(1f, 1f, 11, 21, "TouristPoint_1", "Park_1"), 0);
        grafo.insertEdge("TouristPoint_1", "Park_2", new PathInfo(1f, 1f, 11, 21, "TouristPoint_1", "Park_2"), 0);
        grafo.insertEdge("TouristPoint_1", "Park_3", new PathInfo(1f, 1f, 11, 21, "TouristPoint_1", "Park_3"), 0);
        grafo.insertEdge("TouristPoint_1", "TouristPoint_2", new PathInfo(1f, 1f, 11, 21, "TouristPoint_1", "TouristPoint_2"), 0);

        grafo.insertEdge("TouristPoint_2", "Park_1", new PathInfo(1f, 1f, 11, 21, "TouristPoint_2", "Park_1"), 0);
        grafo.insertEdge("TouristPoint_2", "Park_2", new PathInfo(1f, 1f, 11, 21, "TouristPoint_2", "Park_2"), 0);
        grafo.insertEdge("TouristPoint_2", "Park_3", new PathInfo(1f, 1f, 11, 21, "TouristPoint_2", "Park_3"), 0);
        grafo.insertEdge("TouristPoint_2", "TouristPoint_1", new PathInfo(1f, 1f, 11, 21, "TouristPoint_2", "TouristPoint_1"), 0);

    }

    /**
     * Test of getRouteShortestDistance method, of class
     * SuggestedRoutesController.
     */
    @Test
    public void testGetRouteShortestDistance() {
        System.out.println("getRouteShortestDistance");
        int idOrigin = 1;
        int idDestination = 3;
        String origin = "Park_" + idOrigin;
        String destination = "Park_" + idDestination;

        double fillDouble = 17.87;
        float fillFloat = 17.87f;
        double distanceAux = 15;
        grafo.insertVertex(origin);
        grafo.insertVertex(destination);
        PathInfo eInf = new PathInfo(fillFloat, fillFloat, distanceAux, fillDouble, origin, destination);
        grafo.insertEdge("Park_" + idOrigin, "Park_" + idDestination, eInf, fillDouble);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String distance = decimalFormat.format(distanceAux);
        String expResult = "Route : " + Park.getPark(idOrigin).getName() + " -> " + Park.getPark(idDestination).getName() + "  , distance of " + distance + " km.";
        String result = SuggestedRoutesController.getRouteShortestDistance(idOrigin, idDestination, grafo);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRouteShortestDistanceWithTP method, of class
     * SuggestedRoutesController.
     */
    @Test
    public void testGetRouteShortestDistanceWithTP() {
        System.out.println("getRouteShortestDistanceWithTP");
        boolean isDistance = true;
        int idParkOrigin = 1;
        int idParkDestination = 3;
        HashSet<String> lista = new HashSet<>();
        lista.add("TouristPoint_1");
        lista.add("TouristPoint_2");
        int numSuggestions = 3;
        boolean isDescending = true;
        String expResult = "Route : Porto -> Torre dos Clérigos -> Aliados -> Aveiro  , distance of 33km\n"
                + "Route : Porto -> Aliados -> Torre dos Clérigos -> Aveiro  , distance of 32km\n"
                + "\n";
        String result = SuggestedRoutesController.getRouteShortestWithTP(grafo, idParkOrigin, idParkDestination, lista, isDistance, numSuggestions, isDescending);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRouteShortestDistanceWithTP2() {
        System.out.println("getRouteShortestDistanceWithTP2");
        boolean isDistance = true;
        int idParkOrigin = 1;
        int idParkDestination = 50;
        HashSet<String> lista = new HashSet<>();
        lista.add("TouristPoint_1");
        lista.add("TouristPoint_4");
        int numSuggestions = 3;
        boolean isDescending = false;
        String expResult = null;
        String result = SuggestedRoutesController.getRouteShortestWithTP(grafo, idParkOrigin, idParkDestination, lista, isDistance, numSuggestions, isDescending);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRouteLowestEnergySpent() {
        System.out.println("GetRouteLowestEnergySpent");
        boolean isDistance = false;
        int idParkOrigin = 1;
        int idParkDestination = 3;
        HashSet<String> lista = new HashSet<>();
        lista.add("TouristPoint_1");
        lista.add("TouristPoint_2");
        int numSuggestions = 3;
        boolean isDescending = false;
        String expResult = "\nRoute : Porto -> Aliados -> Torre dos Clérigos -> Aveiro  , spending only 62kW\nRoute : Porto -> Torre dos Clérigos -> Aliados -> Aveiro  , spending only 63kW";
        String result = SuggestedRoutesController.getRouteShortestWithTP(grafo, idParkOrigin, idParkDestination, lista, isDistance, numSuggestions, isDescending);
        assertEquals(expResult, result);
    }
}
