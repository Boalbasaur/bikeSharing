/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Asus
 */
public class PathInfoTest {

    private PathInfo pathInfo;
    public PathInfoTest() {
        pathInfo = new PathInfo(1f, 1f, 1, 1, "Park_1", "Park_3");
    }

    /**
     * Test of getWind method, of class PathInfo.
     */
    @Test
    public void testGetWind() {
        System.out.println("getWind");
        PathInfo instance = pathInfo;
        Wind expResult = new Wind("Park_1", "Park_3",1f,1f,20);
        Wind result = instance.getWind();
        assertEquals(expResult.getCrosswind(), result.getCrosswind());
        assertEquals(expResult.getDestination(), result.getDestination());
        assertEquals(expResult.getWindspeed(), result.getWindspeed());
        assertEquals(expResult.getOrigin(), result.getOrigin());
    }

    /**
     * Test of setWind method, of class PathInfo.
     */
    @Test
    public void testSetWind_Wind() {
        System.out.println("setWind");
        Wind wind = new Wind("Park_1", "Park_2",2f,2f,20);
        PathInfo instance = pathInfo;
        instance.setWind(wind);
        Wind expResult = new Wind("Park_1", "Park_2",2f,2f,20);
        Wind result = instance.getWind();
        assertEquals(expResult.getCrosswind(), result.getCrosswind());
        assertEquals(expResult.getDestination(), result.getDestination());
        assertEquals(expResult.getWindspeed(), result.getWindspeed());
        assertEquals(expResult.getOrigin(), result.getOrigin());
    }

    /**
     * Test of setWind method, of class PathInfo.
     */
    @Test
    public void testSetWind_4args() {
        System.out.println("setWind");
        String origin = "Park_1";
        String destination = "Park_2";
        float windspeed = 2.0F;
        float crosswind = 2.0F;
        double friction = 20;
        PathInfo instance = pathInfo;
        instance.setWind(origin, destination, windspeed, crosswind,friction);
        Wind expResult = new Wind("Park_1", "Park_2",2f,2f,20);
        Wind result = instance.getWind();
        assertEquals(expResult.getCrosswind(), result.getCrosswind());
        assertEquals(expResult.getDestination(), result.getDestination());
        assertEquals(expResult.getWindspeed(), result.getWindspeed());
        assertEquals(expResult.getOrigin(), result.getOrigin());
    }

    /**
     * Test of getDistance method, of class PathInfo.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        PathInfo instance = pathInfo;
        double expResult = 1.0;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setDistance method, of class PathInfo.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        double distance = 2.0;
        PathInfo instance = pathInfo;
        instance.setDistance(distance);
        double expResult = 2.0;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getEnergyNeeded method, of class PathInfo.
     */
    @Test
    public void testGetEnergyNeeded() {
        System.out.println("getEnergyNeeded");
        PathInfo instance = pathInfo;
        double expResult = 1.0;
        double result = instance.getEnergyNeeded();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setEnergyNeeded method, of class PathInfo.
     */
    @Test
    public void testSetEnergyNeeded() {
        System.out.println("setEnergyNeeded");
        double EnergyNeeded = 2.0;
        PathInfo instance = pathInfo;
        instance.setEnergyNeeded(EnergyNeeded);
        double expResult = 2.0;
        double result = instance.getEnergyNeeded();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getOrigin method, of class PathInfo.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        PathInfo instance = pathInfo;
        String expResult = "Park_1";
        String result = instance.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigin method, of class PathInfo.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String origin = "Park_2";
        PathInfo instance = pathInfo;
        instance.setOrigin(origin);
        String expResult = "Park_2";
        String result = instance.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class PathInfo.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        PathInfo instance = pathInfo;
        String expResult = "Park_3";
        String result = instance.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDestination method, of class PathInfo.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "Park_2";
        PathInfo instance = pathInfo;
        instance.setDestination(destination);
        String expResult = "Park_2";
        String result = instance.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PathInfo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PathInfo instance = pathInfo;
        String expResult = "This path from Park_1 to Park_3 is 1.0km  long, it spends around 1.0kW?, the wind speed is 1.0m/s and the cross wind is 1.0m/s.";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
