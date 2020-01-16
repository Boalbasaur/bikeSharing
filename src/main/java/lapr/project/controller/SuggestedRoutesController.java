/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import lapr.project.adjacencyMap.Graph;
import lapr.project.adjacencyMap.GraphAlgorithms;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.PathInfo;
import lapr.project.model.TouristPoint;

/**
 *
 * @author Asus
 */
public final class SuggestedRoutesController {

    private SuggestedRoutesController() {
        throw new IllegalStateException("Utility class");
    }

    private static final String PARK = "Park_";

    public static String getRouteShortestDistance(int idOrigin, int idDestination, Graph<String, PathInfo> grafo) {

        LinkedList<String> shortPath = new LinkedList<>();
        double distanceAux = GraphAlgorithms.shortestPathDistance(grafo, PARK + idOrigin, PARK + idDestination, shortPath);

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String distance = decimalFormat.format(distanceAux);
        String originName = Park.getPark(idOrigin).getName();

        String result = "Route : " + originName;
        int size = shortPath.size();
        String[] aux;

        StringBuilder bld = new StringBuilder();
        String stringAux;
        for (int i = 1; i < size; i++) {
            aux = shortPath.get(i).split("_");
            if ("park".equalsIgnoreCase(aux[0])) {
                stringAux = " -> " + Park.getPark(Integer.parseInt(aux[1])).getName();
                bld.append(stringAux);
            } else {
                stringAux = " -> " + TouristPoint.getTouristPoint(Integer.parseInt(aux[1])).getDescription();
                bld.append(stringAux);
            }
        }
        return result + bld.toString() + "  , distance of " + distance + " km.";
    }

    public static String getRouteShortestWithTP(Graph<String, PathInfo> grafo, int idParkOrigin, int idParkDestination, Set<String> lista, boolean isDistance, int num, boolean inverse) {
        Park origin = Park.getPark(idParkOrigin);

        String vOrigin = PARK + idParkOrigin;
        String vDestination = PARK + idParkDestination;

        PriorityQueue<Path> caminhoFinal = new PriorityQueue<>();

        GraphAlgorithms.shortestPathsList(grafo, vOrigin, vDestination, lista, caminhoFinal, isDistance);
        LinkedList<LinkedList<String>> minimum;
        double minCost;
        Path pathAux;
        if (caminhoFinal.peek().getRoute().isEmpty()) {
            System.out.println("Não existe caminho entre " + vOrigin + " e " + vDestination + " passando pelos pontos pedidos.");
            return null;
        }
        int cont = 0;
        
        StringBuilder bld = new StringBuilder();
        String stringAux;
        while (!caminhoFinal.peek().getRoute().isEmpty() && cont < num) {
            pathAux = caminhoFinal.poll();
            minimum = pathAux.getRoute();
            if (isDistance) {
                minCost = pathAux.getDistance();
            } else {
                minCost = pathAux.getEnergyNeeded();
            }

            //criar path
            LinkedList<String> path = new LinkedList<>();
            for (LinkedList<String> linkedList : minimum) {
                for (String location : linkedList) {
                    if (path.isEmpty() || !path.getLast().equals(location)) {
                        path.addLast(location);
                    }
                }

            }

            int distanceEnergyAux = (int) minCost;
            String distanceEnergy = Integer.toString(distanceEnergyAux);
            String originName = origin.getName();
            stringAux="\nRoute : " + originName;
            bld.append(stringAux);
            int size = path.size();
            String[] aux;
            for (int i = 1; i < size; i++) {
                aux = path.get(i).split("_");
                if ("park".equalsIgnoreCase(aux[0])) {
                    stringAux=" -> " + Park.getPark(Integer.parseInt(aux[1])).getName();
                    bld.append(stringAux);
                } else {
                    stringAux=" -> " + TouristPoint.getTouristPoint(Integer.parseInt(aux[1])).getDescription();
                    bld.append(stringAux);
                }
            }
            if (isDistance) {
                stringAux="  , distance of " + distanceEnergy + "km";
                bld.append(stringAux);
            } else {
                stringAux="  , spending only " + distanceEnergy + "kW";
                bld.append(stringAux);
            }
            cont++;
        }
        String result=bld.toString();
        if (inverse) {
            result = inverseOrder(result);
        }
        return result;
    }

    private static String inverseOrder(String oldString) {
        List<String> list = new ArrayList<>(Arrays.asList(oldString.split("\n")));
        Collections.reverse(list);
        String aux;
        StringBuilder bld = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            aux = list.get(i) + "\n";
            bld.append(aux);
        }
        return bld.toString();
    }
}
