/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Daniela Vinagreiro
 */
public class WindTest {
    
    private final Wind wind1;
    private final Wind wind2;

    public WindTest() {
         wind1 = new Wind("Park_1", "Park_2", 45.50f, 55f,20);
         wind2 = new Wind("Park_1", "Park_3",22.50f, 34f,20);
    }

    /**
     * Test of getWindspeed method, of class Wind.
     */
    @Test
    public void testGetWindspeed() {
        System.out.println("getWindspeed");
        float expResult = 45.50f;
        double result = wind1.getWindspeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCrosswind method, of class Wind.
     */
    @Test
    public void testGetCrosswind() {
        System.out.println("getCrosswind");
        float expResult = 55f;
        float result = wind1.getCrosswind();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWindspeed method, of class Wind.
     */
    @Test
    public void testSetWindspeed() {
        System.out.println("setWindspeed");
        float windspeed = 22.50f;
        wind2.setWindspeed(windspeed);
    }

    /**
     * Test of setCrosswind method, of class Wind.
     */
    @Test
    public void testSetCrosswind() {
        System.out.println("setCrosswind");
        float crosswind = 34f;
        wind2.setCrosswind(crosswind);
    }

    /**
     * Test of toString method, of class Wind.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Wind" + "windspeed=" + 45.50f + ", crosswind=" + 55f;
        String result = wind1.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrigin method, of class Wind.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Wind w = new Wind("Park_1", "Park_2", 0, 0,20);
        String expResult = "Park_1";
        String result = w.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrigin method, of class Wind.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String origin = "Park_1";
        Wind w = new Wind("Park_3", "Park_2", 0, 0,20);
        w.setOrigin(origin);
    }

    /**
     * Test of getDestination method, of class Wind.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Wind w = new Wind("Park_1", "Park_2", 0, 0,20);
        String expResult = "Park_2";
        String result = w.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDestination method, of class Wind.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "Park_1";
        Wind w = new Wind("Park_3", "Park_2", 0, 0,20);
        w.setDestination(destination);
    }
    
    @Test
    public void testSetFriction() {
        System.out.println("setFriciton");
        double d = 20;
        Wind w = new Wind("Park_3", "Park_2", 0, 0,20);
        w.setCineticFriction(d);
    }
    
    @Test
    public void testGetFriction(){
        System.out.println("getFriction");
        double d = 20;
        Wind w = new Wind("Park_3", "Park_2", 0, 0,20);
        assertEquals(w.getCineticFriction(),20);
    }

}
