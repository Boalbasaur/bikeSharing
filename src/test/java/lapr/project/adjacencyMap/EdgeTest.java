/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.adjacencyMap;

import lapr.project.model.Park;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class EdgeTest {

    /**
     * Test of getElement method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testGetElement() {
        Edge<String,String> edge = new Edge<>();
        edge.setElement("teste");
        String expResult = "teste";
        String result = edge.getElement();
        assertEquals(expResult, result);
    }

    /**
     * Test of setElement method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testSetElement() {
        System.out.println("setElement");
        String eInf = "teste";
        Edge<String,String> edge = new Edge<>();
        edge.setElement(eInf);
        assertEquals(eInf, eInf);
    }

    /**
     * Test of getWeight method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testGetWeight() {
        System.out.println("getWeight");
        Edge<String,String> edge = new Edge<>();
        double expResult = 0.0;
        double result = edge.getWeight();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of setWeight method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testSetWeight() {
        System.out.println("setWeight");
        double ew = 0.0;
        Edge<String,String> edge = new Edge<>();
        edge.setWeight(ew);
        double expResult = 0.0;
        double result = edge.getWeight();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getVOrig method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testGetVOrig() {
        Vertex<Park, String> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Edge<Park,String> edge = new Edge<>();
        edge.setVOrig(v);
        Park result = edge.getVOrig();
        assertEquals(p, result);
    }

    /**
     * Test of setVOrig method, of class Edge.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testSetVOrig() {
        Vertex<Park,String> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Edge<Park,String> edge = new Edge<>();
        edge.setVOrig(v);
        Park result = edge.getVOrig();
        assertEquals(p, result);
    }

    /**
     * Test of getVDest method, of class Edge.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetVDest() {
        Vertex<Park,String> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Edge<Park,String> edge = new Edge<>();
        edge.setVDest(v);
        Park result = edge.getVDest();
        assertEquals(p, result);
    }

    /**
     * Test of setVDest method, of class Edge.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testSetVDest() {
        Vertex<Park,String> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Edge<Park,String> edge = new Edge<>();
        edge.setVDest(v);
        Park result = edge.getVDest();
        assertEquals(p, result);
    }

    /**
     * Test of equals method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testEquals() {
        Vertex<Park,String> vDest = new Vertex<>();
        Vertex<Park,String> vOrig = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        vDest.setElement(p);
        Edge<Park,String> edge1 = new Edge<>();
        edge1.setVDest(vDest);
        edge1.setVOrig(vOrig);
        Edge<Park,String> edge2 = new Edge<>();
        edge2.setVOrig(vOrig);
        edge2.setVDest(vDest);
        boolean expResult = true;
        boolean result = edge1.equals(edge2);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testHashCode() {
        Vertex<Park,String> vDest = new Vertex<>();
        Vertex<Park,String> vOrig = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        vDest.setElement(p);
        vOrig.setElement(p);
        Edge<Park,String> edge = new Edge<>();
        edge.setVDest(vDest);
        edge.setVOrig(vOrig);
        Edge<Park,String> edge2 = new Edge<>();
        edge2.setVDest(vDest);
        edge2.setVOrig(vOrig);
        assertTrue(edge.hashCode() == edge2.hashCode());
    }

    /**
     * Test of compareTo method, of class Edge.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testCompareTo() {
        Edge<Park,String> edge = new Edge<>();
        edge.setWeight(2.0);
        Edge<Park,String> edge2 = new Edge<>();
        edge2.setWeight(2.0);
        int expResult = 0;
        int result = edge.compareTo(edge2);
        assertEquals(expResult, result);
        
        edge.setWeight(3.0);
        edge2.setWeight(2.0);
        expResult = 1;
        result = edge.compareTo(edge2);
        assertEquals(expResult, result);
        
        edge.setWeight(2.0);
        edge2.setWeight(3.0);
        expResult = -1;
        result = edge.compareTo(edge2);
        assertEquals(expResult, result);
    }
}
