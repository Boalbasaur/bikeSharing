/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.adjacencyMap.Graph;
import lapr.project.model.Bike;
import lapr.project.model.Park;
import lapr.project.model.PathInfo;
import lapr.project.model.TouristPoint;
import lapr.project.model.User;
import lapr.project.model.Wind;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Daniela Vinagreiro
 */
public class CalculateCaloriesControllerTest {

    public CalculateCaloriesControllerTest() {
    }

    /**
     * Test of calculateCaloriesController method, of class
     * CalculateCaloriesController.
     */
    @Test
    public void testCalculateCaloriesControllerRoadBike() {
        System.out.println("calculateCaloriesController");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User",0, 1f);
        String bikeType = "road";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);

        double bikeWeight = 10;
        double expResult = 3.563990334652244 * Math.pow(10, 16);
        double result = CalculateCaloriesController.calculateCaloriesController(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCaloriesController method, of class
     * CalculateCaloriesController.
     */
    @Test
    public void testCalculateCaloriesControllerMountainBike() {
        System.out.println("calculateCaloriesController");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User",0, 1f);
        String bikeType = "mtb";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 15;
        double expResult = 5.3466759415540864 * Math.pow(10, 16);
        double result = CalculateCaloriesController.calculateCaloriesController(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateCaloriesController method, of class
     * CalculateCaloriesController.
     */
    @Test
    public void testCalculateCaloriesControllerEletricallyBike() {
        System.out.println("calculateCaloriesController");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 7.609267f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User",0,1f);
        String bikeType = "eletric";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 20;
        double expResult = 1.6782856597287662E16;
        double result = CalculateCaloriesController.calculateCaloriesController(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of getWind method, of class CalculateCaloriesController.
     */
    @Test
    public void testGetWind() {
        System.out.println("getWind");
        String nameOrigin = "Park_1";
        String nameDestiny = "Park_3";
        
        Graph<String, PathInfo> grafo = new Graph <String, PathInfo>(true);
        
        grafo.insertVertex(nameOrigin);
        grafo.insertVertex(nameDestiny);
        PathInfo eInf = new PathInfo(1f, 1f, 1, 1, "Park_1", "Park_3");
        grafo.insertEdge(nameOrigin, nameDestiny, eInf, 1);
        
        Wind expResult = new Wind ("Park_1", "Park_3", 1f, 1f,20);
        
        Wind result = CalculateCaloriesController.getWind(nameOrigin, nameDestiny, grafo);
        assertEquals(expResult.getOrigin(), result.getOrigin());
        assertEquals(expResult.getDestination(), result.getDestination());
        assertEquals(expResult.getWindspeed(), result.getWindspeed());
        assertEquals(expResult.getCrosswind(), result.getCrosswind());
    }

    /**
     * Test of getUser method, of class CalculateCaloriesController.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String username = "Daniela";
        User expResult = new User ("daniela", "Daniela", "1170813@isep.ipp.pt", "qwerty","01234567891234562", 175.0,75.0, "User",2,10f);
        User result = CalculateCaloriesController.getUser(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBike method, of class CalculateCaloriesController.
     */
    @Test
    public void testGetBike() {
        System.out.println("getBike");
        String idBike = "4";
        Bike expResult = new Bike("4", "eletric",1, "200", "1", 10, 3f, 4f, 456f, 456f,1);
        Bike result = CalculateCaloriesController.getBike(idBike);
        assertEquals(expResult.getIdBike(), result.getIdBike());
        assertEquals(expResult.getIdType(), result.getIdType());
        assertEquals(expResult.getBattery(), result.getBattery());
        assertEquals(expResult.getMaxCapacity(), result.getMaxCapacity());
    }

    /**
     * Test of getPark method, of class CalculateCaloriesController.
     */
    @Test
    public void testGetPark() {
        System.out.println("getPark");
        int id = 3;
        Park expResult = new Park (3,"Aveiro",250,250,0,500,250,0,0);
        Park result = CalculateCaloriesController.getPark(id);
        assertEquals(expResult.getIdPark(), result.getIdPark());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getLongitude(), result.getLongitude());
        assertEquals(expResult.getLatitude(), result.getLatitude());
        assertEquals(expResult.getNormalSlots(), result.getNormalSlots());
        assertEquals(expResult.getEletricSlots(), result.getEletricSlots());
        assertEquals(expResult.getAltitude(), result.getAltitude());
   
    }

    /**
     * Test of getTouristPoint method, of class CalculateCaloriesController.
     */
    @Test
    public void testGetTouristPoint() {
        System.out.println("getTouristPoint");
        int id = 1;
        TouristPoint expResult = new TouristPoint (1,"Torre dos Clérigos", 48.5f, 48.6f, 28.4f);
        TouristPoint result = CalculateCaloriesController.getTouristPoint(id);
        assertEquals(expResult, result);
    }
}




