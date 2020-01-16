/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Diogo Rolo
 */
public class OperationsTest {

    public OperationsTest() {

    }

    /**
     * Test of nearestBicycleParks method, of class Operations.
     */
    @Test
    public void testNearestBicycleParks() {
        ArrayList<Park> listaParquesMaisProximos = new ArrayList<>();
        HashMap<Park, Double> distParqueList = new HashMap<>();
        Operations instance = new Operations();
        ArrayList<Park> rp = new ArrayList<>();


        Park p1 = new Park(1, "Parque1", 12.152699f, 8.609267f, 30, 20, 7.609267f,0,0);
        Park p2 = new Park(2, "Parque2", 9.152699f, 6.609267f, 20, 25, 4.609267f,0,0);
        Park p3 = new Park(3, "Parque3", 21.152699f, 8.609267f, 10, 21, 5.609267f,0,0);
        Park p4 = new Park(4, "Parque4", 43.152699f, 8.609267f, 10, 20, 7.609267f,0,0);
        Park p5 = new Park(5, "Parque5", 33.152699f, 8.60926f, 7, 12, 4.609267f,0,0);
        Park p6 = new Park(6, "Parque6", 35.152699f, 8.609267f, 4, 23, 5.609267f,0,0);
        Park p7 = new Park(7, "Parque7", 25.152699f, 2.609267f, 50, 40, 7.609267f,0,0);

        rp.add(p1);
        rp.add(p2);
        rp.add(p3);
        rp.add(p4);
        rp.add(p5);
        rp.add(p6);
        rp.add(p7);

        System.out.println("nearestBicycleParks");
        float lon = (float) 40.152699;
        float lat = (float) 8.609267;
        float alt = (float) 7.609267;
        ArrayList<Park> expResult = new ArrayList<>();

        expResult.add(p4);
        expResult.add(p6);
        expResult.add(p5);
        expResult.add(p7);
        expResult.add(p3);

        List<Park> result = instance.nearestBicycleParks(lon, lat, alt, rp);
        assertEquals(expResult, result);
    }

    /**
     * Test of distanceCalculator method, of class Operations.
     */
    @Test
    public void testDistanceCalculator() {
        System.out.println("distanceCalculator");
        Operations instance = new Operations();
        float lon1 = 40.152699f;
        float lat1 = 8.609267f;
        float altitudeAtual = 7.609267f;

        float lon2 = 12.152699f;
        float lat2 = 8.609267f;
        float altitudeParque = 7.609267f;

        float expResult = 3077.5252063714147f;
        float result = (float) Operations.distanceCalculator(lon1, lat1, altitudeAtual, lon2, lat2, altitudeParque);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForRoadBikeHeadwindZero() {
        System.out.println("caloriesCalculater road bike, headwind zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String bikeType = "road";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 10;
        double expResult = 3.563990334652244 * Math.pow(10, 16);
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForRoadBikeHeadwindNotZero() {
        System.out.println("caloriesCalculater road bike, headwind not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0,10f);
        String bikeType = "road";
        Wind wind = new Wind(nameO, nameD, 1.0, 1f,20);
        double bikeWeight = 10;
        double expResult = 3.5640633419682584E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForRoadBikeSlopeNotZeroHeadwindZero() {
        System.out.println("caloriesCalculater road bike slope not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 9.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String bikeType = "road";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 10;
        double expResult = 3.5640041928833348E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForRoadBikeSlopeNotZeroHeadwindNotZero() {
        System.out.println("caloriesCalculater road bike slop and headwind not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 9.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0,10f);
        String bikeType = "road";
        Wind wind = new Wind(nameO, nameD, 1.0, 1f,20);
        double bikeWeight = 10;
        double expResult = 3.564077200279206E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);

    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForMountainBikeHeadwindZero() {
        System.out.println("caloriesCalculater mountain bike, headwind zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0,10f);
        String bikeType = "mtb";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 15;
        double expResult = 5.3466759415540864 * Math.pow(10, 16);
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForMountainBikeHeadwindNotZero() {
        System.out.println("caloriesCalculater mountain bike, headwind not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0,10f);
        String bikeType = "mtb";
        Wind wind = new Wind(nameO, nameD, 1.0, 1f,20);
        double bikeWeight = 15;
        double expResult = 5.3467854666713296E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForMountainBikeSlopeNotZeroHeadwindZero() {
        System.out.println("caloriesCalculater mountain bike slope not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 9.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0,10f);
        String bikeType = "mtb";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 15;
        double expResult = 5.34669317989592E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForMountainBikeSlopeNotZeroHeadwindNotZero() {
        System.out.println("caloriesCalculater mountain bike slope and headwind not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 9.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0,10f);
        String bikeType = "mtb";
        Wind wind = new Wind(nameO, nameD, 1.0, 1f,20);
        double bikeWeight = 15;
        double expResult = 5.3468027051329664E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForEletricallyBikeSlopeNotZeroHeadwindZero() {
        System.out.println("caloriesCalculater eletrically bike slope and headwind zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 9.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String bikeType = "eletric";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 20;
        double expResult = 1.0692015309525112E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForEletricallyBikeSlopeNotZeroHeadwindNotZero() {
        System.out.println("caloriesCalculater eletrically bike slope not zero, headwind not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 12.152699f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 9.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String bikeType = "eletric";
        Wind wind = new Wind(nameO, nameD, 1.0, 1f,20);
        double bikeWeight = 20;
        double expResult = 1.0692234331712724E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of caloriesCalculater method, of class Operations.
     */
    @Test
    public void testCaloriesCalculaterForEletricallyBikeHeadwindZero() {
        System.out.println("caloriesCalculater Eletrically bike, headwind zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 7.609267f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String bikeType = "eletric";
        Wind wind = new Wind(nameO, nameD, 0.0, 0f,20);
        double bikeWeight = 20;
        double expResult = 1.6782856597287662E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalorieCalculaterForEletricallyBikeHeadwindNotZero() {
        System.out.println("caloriesCalculater eletrically bike, headwind not zero");
        String nameO = "";
        String nameD = "";
        float longitudeOrigin = 40.152699f;
        float latitudeOrigin = 8.609267f;
        float altitudeOrigin = 7.609267f;
        float longitudeDestiny = 7.609267f;
        float latitudeDestiny = 8.609267f;
        float altitudeDestiny = 7.609267f;
        int duration = 55;
        User user = new User("João Miguel", "joaoMiguel96", "joaoMiguel@gmail.com", "joao123miguel321", "1234567890123456", 1.88, 78, "User", 0, 10f);
        String bikeType = "eletric";
        Wind wind = new Wind(nameO, nameD, 1.0, 1f,20);
        double bikeWeight = 20;
        double expResult = 1.6782982241030248E16;
        double result = Operations.caloriesCalculater(latitudeOrigin, longitudeOrigin, altitudeOrigin, latitudeDestiny, longitudeDestiny, altitudeDestiny, duration, user, bikeType, bikeWeight, wind);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertWtoCalories method, of class Operations.
     */
    @Test
    public void testConvertWtoCaloriesForRoadBike() {
        System.out.println("convertWtoCalories");
        double W = (4.521733689 * Math.pow(10, 10));
        double expResult = (4.521733689 * Math.pow(10, 10) * 1000) / 69.78;
        double result = Operations.convertWtoCalories(W);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertWtoCalories method, of class Operations.
     */
    @Test
    public void testConvertWtoCaloriesForMountainBike() {
        System.out.println("convertWtoCalories");
        double W = 6.783473585484439 * Math.pow(10, 13);
        double expResult = 9.721228984643792 * Math.pow(10, 14);
        double result = Operations.convertWtoCalories(W);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertWtoCalories method, of class Operations.
     */
    @Test
    public void testConvertWtoCaloriesForEletricallyBike() {
        System.out.println("convertWtoCalories");
        double W = (4.521733689 * Math.pow(10, 10));
        double expResult = (4.521733689 * Math.pow(10, 10) * 1000) / 69.78;
        double result = Operations.convertWtoCalories(W);
        assertEquals(expResult, result);
    }

    @Test
    public void testenoughBattery() {
        System.out.println("enough battery");
        int idPark = 666;
        int idPark1 = 667;
        String idBike = "4";
        String username = "Fabio";
        assertTrue(Operations.enoughBattery(idPark, idPark1, idBike, username));
    }

    @Test
    public void testenoughBattery1() {
        System.out.println("enough battery");
        int idPark = 3;
        int idPark1 = 2;
        String idBike = "4";
        String username = "Fabio";
        assertFalse(Operations.enoughBattery(idPark, idPark1, idBike, username));
    }

    @Test
    public void testenergyBetween() {
        System.out.println("enough battery");
        String idPark = "Park_3";
        String idPark1 = "Park_2";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 2.977062026083473E7);
    }

    @Test
    public void testenergyBetween1() {
        System.out.println("enough battery");
        String idPark = "TouristPoint_1";
        String idPark1 = "TouristPoint_2";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 21983.578475001596);
    }
     
      @Test
    public void testenergyBetween4() {
        System.out.println("enough battery");
        String idPark = "Park_3";
        String idPark1 = "TouristPoint_1";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 1.687116094452483E7);
    }

    @Test
    public void testenergyBetween2() {
        System.out.println("enough battery");
        String idPark = "Park_3";
        String idPark1 = "Park_666";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 1.4244003920856101E7);
    }

    @Test
    public void testenergyBetween3() {
        System.out.println("enough battery");
        String idPark = "Park_666";
        String idPark1 = "Park_1";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 1.5724457733984424E7);
    }
    
     @Test
    public void testenergyBetween5() {
        System.out.println("enough battery");
        String idPark = "Park_666";
        String idPark1 = "Park_2";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 1.9550461808644198E7);
    }
      @Test
    public void testenergyBetween7() {
        System.out.println("enough battery");
        String idPark = "TouristPoint_1";
        String idPark1 = "Park_1";
        String idBike = "4";
        String username = "Fabio";
        assertEquals(Operations.energyBetween(idPark, idPark1, idBike, username), 3032223.8583535915);
    }


    @Test
    public void testTimeToCharge() {
        Bike a = new Bike("4", "eletric", 0, "200", "1", 10, 1f, 2f, 2f, 2f,1);
        Park c = new Park(3, "Aveiro", 250, 250, 0, 500, 250,1,2);
        double b = Operations.timeToCharge(c, a);
        assertEquals(b, 500000.0);
    }

    /**
     * Test of calculateBearing method, of class Operations.
     */
    @Test
    public void testCalculateBearing() {
        System.out.println("calculateBearing");
        float latOrigin = (float) -82.46390546167895;
        float longOrigin = (float) -118.63819250000006;
        float latDestiny = (float) 60.35996;
        float longDestiny = (float) -20.03663;
        double expResult = 85.24640557693544;
        double result = Operations.calculateBearing(latOrigin, longOrigin, latDestiny, longDestiny);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateWindDirectionRelatedToTheRoute method, of class
     * Operations.
     */
    @Test
    public void testCalculateWindDirectionRelatedToTheRoutePerpendicularWind() {
        System.out.println("calculateWindDirectionRelatedToTheRoute Perpendicular wind");
        float crosswind = 90;
        double windspeed = 1;
        float latOrigin = 22;
        float longOrigin = 22;
        float latDestiny = 11;
        float longDestiny = 11;
        double expResult = -0.9159189346936857;
        double result = Operations.calculateWindDirectionRelatedToTheRoute(crosswind, windspeed, latOrigin, longOrigin, latDestiny, longDestiny);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalculateWindDirectionRelatedToTheRouteAlphaBetween90And270() {
        System.out.println("calculateWindDirectionRelatedToTheRoute alpha between 90 and 270");
        float crosswind = 180;
        double windspeed = 1;
        float latOrigin = (float) -82.46390546167895;
        float longOrigin = (float) -118.63819250000006;
        float latDestiny = (float) 60.35996;
        float longDestiny = (float) -20.03663;
        double expResult = -0.874779970206268;
        double result = Operations.calculateWindDirectionRelatedToTheRoute(crosswind, windspeed, latOrigin, longOrigin, latDestiny, longDestiny);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalculateWindDirectionRelatedToTheRouteAlphaIs90Or270() {
        System.out.println("calculateWindDirectionRelatedToTheRoute alpha is 90 or 270");
        float crosswind = 90;
        double windspeed = 1;
        float latOrigin = (float) 65.23486410441492;
        float longOrigin = (float) -17.15473302734381;
        float latDestiny = (float) 65.23486410441492;
        float longDestiny = (float) -17.15473302734381;
        double expResult = 0;
        double result = Operations.calculateWindDirectionRelatedToTheRoute(crosswind, windspeed, latOrigin, longOrigin, latDestiny, longDestiny);
        assertEquals(expResult, result);
    }

}
