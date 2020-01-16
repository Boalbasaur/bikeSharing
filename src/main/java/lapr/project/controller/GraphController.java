/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import lapr.project.adjacencyMap.Edge;
import lapr.project.adjacencyMap.Graph;
import lapr.project.data.GetParksDB;
import lapr.project.data.TouristPointDB;
import lapr.project.data.WindDB;
import lapr.project.model.Bike;
import lapr.project.model.Operations;
import lapr.project.model.Park;
import lapr.project.model.PathInfo;
import lapr.project.model.TouristPoint;
import lapr.project.model.User;
import lapr.project.model.Wind;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class GraphController {

    private static final String PARK = "Park_";
    private static final String TOURISTPOINT = "TouristPoint_";
    private static final String TOURISTPOINT2="TouristPoint";

    private Graph<String, PathInfo> grafo;
    private HashMap<Integer, TouristPoint> touristPointsMap;
    private HashMap<Integer, Park> parksMap;

    public GraphController() {
        this.grafo = new Graph<>(false);
        this.parksMap = new HashMap<>();
        this.touristPointsMap = new HashMap<>();
    }

    public Graph<String, PathInfo> getGrafo() {
        return grafo;
    }

    public void fillGraph() {
        GetParksDB gpbd = new GetParksDB();
        TouristPointDB tpdb = new TouristPointDB();

        ArrayList<Park> parks = (ArrayList<Park>) gpbd.getParks();
        HashSet<TouristPoint> touristPoints = tpdb.getTouristPoints();

        Set<Park> setP = new HashSet<>(parks);
        for (Park p : setP) {
            String parkId = PARK + p.getIdPark();
            this.parksMap.put(p.getIdPark(), p);
            this.grafo.insertVertex(parkId);
        }

        for (TouristPoint tp : touristPoints) {
            String tpId = TOURISTPOINT + tp.getIdTouristPoint();
            this.touristPointsMap.put(tp.getIdTouristPoint(), tp);
            this.grafo.insertVertex(tpId);
        }
    }

    public Iterable<String> getVertices() {
        return this.grafo.vertices();
    }

    public void removeVertex(String vertexToRemove) {
        this.grafo.removeVertex(vertexToRemove);
        String [] type = vertexToRemove.split("_");
        String pOrTp = type[0];
        if (("Park").equals(pOrTp)) {
            this.parksMap.remove(Integer.parseInt(type[1]));
        } else if ((TOURISTPOINT).equals(pOrTp)) {
            this.touristPointsMap.remove(Integer.parseInt(type[1]));
        }
    }

    public boolean isEdge(String vOrig, String vDest) {
        return this.grafo.validEdge(vOrig, vDest);
    }

    public void insertVertexPark(Park p) {
        String parkId = PARK + p.getIdPark();
        this.parksMap.put(p.getIdPark(), p);
        this.grafo.insertVertex(parkId);
    }

    public void insertVertexTouristPoint(TouristPoint tp) {
        String tpId = TOURISTPOINT + tp.getIdTouristPoint();
        this.touristPointsMap.put(tp.getIdTouristPoint(), tp);
        this.grafo.insertVertex(tpId);
    }

    public void insertEdge(Wind w) {
        double distance = calculateDistance(w);
        String originID = w.getOrigin();
        String destinationID = w.getDestination();
        double windspeed = w.getWindspeed();

        PathInfo pathInfo = new PathInfo(w, distance, 0, originID, destinationID);
        this.grafo.insertEdge(originID, destinationID, pathInfo, windspeed);

    }

    public void insertEdgesOnDB() {
        WindDB wdb = new WindDB();
        double distance;

        Set<Wind> setW = wdb.getWinds();
        for (Wind w : setW) {
            String originID = w.getOrigin();
            String destinationID = w.getDestination();
            double windspeed = w.getWindspeed();
            distance = calculateDistance(w);

            PathInfo pathInfo = new PathInfo(w, distance, 0, originID, destinationID);
            this.grafo.insertEdge(originID, destinationID, pathInfo, windspeed);
        }
    }

    public double calculateDistance(Wind w) {
        String [] originType = w.getOrigin().split("_");
        String [] destinationType = w.getDestination().split("_");
        String tp = TOURISTPOINT2;
        String p = "Park";
        double distance = 0.0;
        float alt1;
        float lat1;
        float lon1;
        float alt2;
        float lat2;
        float lon2;

        if (originType[0].equals(p) && destinationType[0].equals(p)) {
            Park originPark = this.parksMap.get(Integer.parseInt(originType[1]));
            Park destinationPark = this.parksMap.get(Integer.parseInt(destinationType[1]));
            alt1 = originPark.getAltitude();
            lat1 = originPark.getLatitude();
            lon1 = originPark.getLongitude();
            alt2 = destinationPark.getAltitude();
            lat2 = destinationPark.getLatitude();
            lon2 = destinationPark.getLongitude();
            distance = Operations.distanceCalculator(lon1, lat1, alt1, lon2, lat2, alt2);
        } else if (originType[0].equals(p) && destinationType[0].equals(tp)) {
            Park originPark = this.parksMap.get(Integer.parseInt(originType[1]));
            TouristPoint destinationTouristPoint = this.touristPointsMap.get(Integer.parseInt(destinationType[1]));
            alt1 = originPark.getAltitude();
            lat1 = originPark.getLatitude();
            lon1 = originPark.getLongitude();
            alt2 = destinationTouristPoint.getAltitude();
            lat2 = destinationTouristPoint.getLatitude();
            lon2 = destinationTouristPoint.getLongitude();
            distance = Operations.distanceCalculator(lon1, lat1, alt1, lon2, lat2, alt2);
        } else if (originType[0].equals(tp) && destinationType[0].equals(p)) {
            Park destinationPark = this.parksMap.get(Integer.parseInt(destinationType[1]));
            TouristPoint originTouristPoint = this.touristPointsMap.get(Integer.parseInt(originType[1]));
            alt1 = originTouristPoint.getAltitude();
            lat1 = originTouristPoint.getLatitude();
            lon1 = originTouristPoint.getLongitude();
            alt2 = destinationPark.getAltitude();
            lat2 = destinationPark.getLatitude();
            lon2 = destinationPark.getLongitude();
            distance = Operations.distanceCalculator(lon1, lat1, alt1, lon2, lat2, alt2);
        } else if (originType[0].equals(tp) && destinationType[0].equals(tp)) {
            TouristPoint originTouristPoint = this.touristPointsMap.get(Integer.parseInt(originType[1]));
            TouristPoint destinationTouristPoint = this.touristPointsMap.get(Integer.parseInt(destinationType[1]));
            alt1 = originTouristPoint.getAltitude();
            lat1 = originTouristPoint.getLatitude();
            lon1 = originTouristPoint.getLongitude();
            alt2 = destinationTouristPoint.getAltitude();
            lat2 = destinationTouristPoint.getLatitude();
            lon2 = destinationTouristPoint.getLongitude();
            distance = Operations.distanceCalculator(lon1, lat1, alt1, lon2, lat2, alt2);
        }

        return distance;
    }

    public ArrayList<Object> getIdObject(int id) {
        ArrayList<Object> list = new ArrayList<>();
        if (this.parksMap.containsKey(id)) {
            Park p = this.parksMap.get(id);
            list.add(p);
            list.add("Park");
        } else if (this.touristPointsMap.containsKey(id)) {
            TouristPoint tp = this.touristPointsMap.get(id);
            list.add(tp);
            list.add(TOURISTPOINT2);
        }
        return list;
    }

    public void calculateEnergy(Bike bike, ArrayList<Object> arrOrig, ArrayList<Object> arrDest, User user) {
        
        Park originPark = new Park();
        String idOriginPark = PARK;
        
        TouristPoint originTP = new TouristPoint();
        String idOriginTP = TOURISTPOINT;
        
        Park destinationPark = new Park();
        String idDestinationPark = PARK;
        
        TouristPoint destinationTP = new TouristPoint();
        String idDestinationTP = TOURISTPOINT;
        
        String idBike = bike.getIdBike();
        String username = user.getUsername();
        
        double energyNeeded = 0.0;

        if ("Park".equals(arrOrig.get(1))) {
            originPark = (Park) arrOrig.get(0);
            idOriginPark +=  Integer.toString(originPark.getIdPark());
        } else {
            originTP = (TouristPoint) arrOrig.get(0);
            idOriginTP +=  Integer.toString(originTP.getIdTouristPoint());
        }

        if ("Park".equals(arrDest.get(1))) {
            destinationPark = (Park) arrDest.get(0);
            idDestinationPark +=  Integer.toString(destinationPark.getIdPark());
        } else {
            destinationTP = (TouristPoint) arrDest.get(0);
            idDestinationTP +=  Integer.toString(destinationTP.getIdTouristPoint());
        }
               
        if (originPark.getIdPark() != 0 && destinationPark.getIdPark() != 0) {
            energyNeeded = Operations.energyBetween(idOriginPark, idDestinationPark, idBike, username);
        } else if (originPark.getIdPark() != 0 && destinationTP.getIdTouristPoint() != 0) {
            energyNeeded = Operations.energyBetween(idOriginPark, idDestinationTP, idBike, username);
        } else if (originTP.getIdTouristPoint() != 0 && destinationPark.getIdPark() != 0) {
            energyNeeded = Operations.energyBetween(idOriginTP, idDestinationPark, idBike, username);
        } else if (originTP.getIdTouristPoint() != 0 && destinationTP.getIdTouristPoint() != 0){
            energyNeeded = Operations.energyBetween(idOriginTP, idDestinationTP, idBike, username);
        }
                
        if(originPark.getIdPark() != 0 && destinationPark.getIdPark() != 0){
            Edge<String, PathInfo> edge = this.grafo.getEdge(idOriginPark, idDestinationPark);
            edge.getElement().setEnergyNeeded(energyNeeded);
            edge.getElement().setBike(bike);
        } else if (originPark.getIdPark() != 0 && destinationTP.getIdTouristPoint() != 0) {
            Edge<String, PathInfo> edge = this.grafo.getEdge(idOriginPark, idDestinationTP);
            edge.getElement().setEnergyNeeded(energyNeeded);
            edge.getElement().setBike(bike);
        } else if (originTP.getIdTouristPoint() != 0 && destinationPark.getIdPark() != 0) {
            Edge<String, PathInfo> edge = this.grafo.getEdge(idOriginTP, idDestinationPark);
            edge.getElement().setEnergyNeeded(energyNeeded);
            edge.getElement().setBike(bike);
        } else if (originTP.getIdTouristPoint() != 0 && destinationTP.getIdTouristPoint() != 0){
            Edge<String, PathInfo> edge = this.grafo.getEdge(idOriginTP, idDestinationTP);
            edge.getElement().setEnergyNeeded(energyNeeded);
            edge.getElement().setBike(bike);
        }        
    }
}