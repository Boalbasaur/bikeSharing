/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Asus
 */
public class PathTest {
    private final Path test;
    private final Path test2;
    
    public PathTest() {
        LinkedList<LinkedList<String>> route= new LinkedList<> ();
        LinkedList<String> routeAux1=new LinkedList<> ();
        routeAux1.add("a");
        routeAux1.add("b");
        routeAux1.add("c");
        LinkedList<String> routeAux2=new LinkedList<> ();
        routeAux1.add("d");
        routeAux1.add("e");
        routeAux1.add("f");
        route.add(routeAux1);
        route.add(routeAux2);
        double distance=2;
        double energyNeeded=5;
        int elevation=4;
        test=new Path(route, distance, energyNeeded, elevation);
        
        route= new LinkedList<> ();
        routeAux1=new LinkedList<> ();
        routeAux1.add("a");
        routeAux1.add("b");
        routeAux1.add("c");
        routeAux2=new LinkedList<> ();
        routeAux1.add("d");
        routeAux1.add("e");
        routeAux1.add("f");
        route.add(routeAux1);
        route.add(routeAux2);
        distance=-1;
        energyNeeded=4;
        elevation=4;
        test2=new Path(route, distance, energyNeeded, elevation);
    }
    
    /**
     * Test of getRoute method, of class Path.
     */
    @Test
    public void testGetRoute() {
        System.out.println("getRoute");
        Path instance = test;
        LinkedList<LinkedList<String>> route= new LinkedList<> ();
        LinkedList<String> routeAux1=new LinkedList<> ();
        routeAux1.add("a");
        routeAux1.add("b");
        routeAux1.add("c");
        LinkedList<String> routeAux2=new LinkedList<> ();
        routeAux1.add("d");
        routeAux1.add("e");
        routeAux1.add("f");
        route.add(routeAux1);
        route.add(routeAux2);
        LinkedList<LinkedList<String>> expResult = route;
        LinkedList<LinkedList<String>> result = instance.getRoute();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetRoute method, of class Path.
     */
    @Test
    public void testSetRoute() {
        System.out.println("setRoute");
        LinkedList<LinkedList<String>> route= new LinkedList<> ();
        LinkedList<String> routeAux1=new LinkedList<> ();
        routeAux1.add("q");
        routeAux1.add("w");
        routeAux1.add("e");
        LinkedList<String> routeAux2=new LinkedList<> ();
        routeAux1.add("r");
        routeAux1.add("t");
        routeAux1.add("y");
        route.add(routeAux1);
        route.add(routeAux2);
        Path instance = test;
        instance.setRoute(route);
        LinkedList<LinkedList<String>> expResult = route;
        LinkedList<LinkedList<String>> result = instance.getRoute();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class Path.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Path instance = test;
        double expResult = 2;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setDistance method, of class Path.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        double distance = 10;
        Path instance = test;
        instance.setDistance(distance);
        double expResult = distance;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getEnergyNeeded method, of class Path.
     */
    @Test
    public void testGetEnergyNeeded() {
        System.out.println("getEnergyNeeded");
        Path instance = test;
        double expResult = 5;
        double result = instance.getEnergyNeeded();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setEnergyNeeded method, of class Path.
     */
    @Test
    public void testSetEnergyNeeded() {
        System.out.println("setEnergyNeeded");
        double energyNeeded = 49;
        Path instance = test;
        instance.setEnergyNeeded(energyNeeded);
        double expResult = 49;
        double result = instance.getEnergyNeeded();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getElevation method, of class Path.
     */
    @Test
    public void testGetElevation() {
        System.out.println("getElevation");
        Path instance = test;
        int expResult = 4;
        int result = instance.getElevation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setElevation method, of class Path.
     */
    @Test
    public void testSetElevation() {
        System.out.println("setElevation");
        int elevation = 1;
        Path instance = test;
        instance.setElevation(elevation);
        int expResult = 1;
        int result = instance.getElevation();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Path.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Path other = test;
        Path instance = test2;
        int expResult = -1;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        expResult = 1;
        result = other.compareTo(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = test2;
        Path instance = test;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals");
        Object obj = test;
        Path instance = test;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Object obj = "E";
        Path instance = test;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals");
        Object obj = null;
        Path instance = test;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals");
        LinkedList<LinkedList<String>> route= new LinkedList<> ();
        LinkedList<String> routeAux1=new LinkedList<> ();
        routeAux1.add("a");
        routeAux1.add("b");
        routeAux1.add("c");
        LinkedList<String> routeAux2=new LinkedList<> ();
        routeAux1.add("d");
        routeAux1.add("e");
        routeAux1.add("f");
        route.add(routeAux1);
        route.add(routeAux2);
        double distance=2;
        double energyNeeded=4.8;
        int elevation=4;
        Path p=new Path(route, distance, energyNeeded, elevation);
        Object obj = p;
        Path instance = test;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals6() {
        System.out.println("equals");
        LinkedList<LinkedList<String>> route= new LinkedList<> ();
        LinkedList<String> routeAux1=new LinkedList<> ();
        routeAux1.add("a");
        routeAux1.add("b");
        routeAux1.add("c");
        LinkedList<String> routeAux2=new LinkedList<> ();
        routeAux1.add("d");
        routeAux1.add("e");
        routeAux1.add("f");
        route.add(routeAux1);
        route.add(routeAux2);
        double distance=2;
        double energyNeeded=5;
        int elevation=3;
        Path p=new Path(route, distance, energyNeeded, elevation);
        Object obj = p;
        Path instance = test;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of equals method, of class Path.
     */
    @Test
    public void testEquals7() {
        System.out.println("equals");
        LinkedList<LinkedList<String>> route= new LinkedList<> ();
        LinkedList<String> routeAux1=new LinkedList<> ();
        routeAux1.add("K");
        routeAux1.add("b");
        routeAux1.add("c");
        LinkedList<String> routeAux2=new LinkedList<> ();
        routeAux1.add("d");
        routeAux1.add("e");
        routeAux1.add("f");
        route.add(routeAux1);
        route.add(routeAux2);
        double distance=2;
        double energyNeeded=5;
        int elevation=4;
        Path p=new Path(route, distance, energyNeeded, elevation);
        Object obj = p;
        Path instance = test;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Path.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Path instance = test;
        int expResult = -671365531;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
}
