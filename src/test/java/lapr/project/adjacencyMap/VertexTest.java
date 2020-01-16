/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.adjacencyMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lapr.project.model.Park;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class VertexTest {

    /**
     * Test of getKey method, of class Vertex.
     */
    @Test
    public void testGetKey() {
        Vertex<Park,String> v = new Vertex<>();
        v.setKey(30);
        int expResult = 30;
        int result = v.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKey method, of class Vertex.
     */
    @Test
    public void testSetKey() {
        Vertex<Park,String> v = new Vertex<>();
        v.setKey(30);
        int expResult = 30;
        int result = v.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of getElement method, of class Vertex.
     */
    @Test
    public void testGetElement() {
        Vertex<Park, Park> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Park result = v.getElement();
        assertEquals(p, result);
    }

    /**
     * Test of setElement method, of class Vertex.
     */
    @Test
    public void testSetElement() {
        Vertex<Park, Park> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Park result = v.getElement();
        assertEquals(p, result);
    }

    /**
     * Test of addAdjVert method, of class Vertex.
     */
    @Test
    public void testAddAdjVert() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.addAdjVert(p, e);
        Park result = v.getAdjVert(e);
        assertEquals(p, result);
    }

    /**
     * Test of getAdjVert method, of class Vertex.
     */
    @Test
    public void testGetAdjVert() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.addAdjVert(p, e);
        Park result = v.getAdjVert(e);
        assertEquals(p, result);
    }

    /**
     * Test of remAdjVert method, of class Vertex.
     */
    @Test
    public void testRemAdjVert() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        Park p2 = new Park(1, "Park_test1", 1, 1, 1, 1, 1,0,0);
        v.addAdjVert(p, e);
        v.remAdjVert(p);
        v.addAdjVert(p2, e);
        Park result = v.getAdjVert(e);
        assertEquals(p2, result);
    }

    /**
     * Test of getEdge method, of class Vertex.
     */
    @Test
    public void testGetEdge() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        Park p2 = new Park(1, "Park_test1", 1, 1, 1, 1, 1,0,0);
        e.setWeight(2);
        e.setVOrig(v);
        v.setElement(p);
        v.addAdjVert(p2, e);
        Edge<Park, Park> result = v.getEdge(p2);
        assertEquals(e, result);
    }

    /**
     * Test of numAdjVerts method, of class Vertex.
     */
    @Test
    public void testNumAdjVerts() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        Park p2 = new Park(1, "Park_test1", 1, 1, 1, 1, 1,0,0);
        v.setElement(p);
        v.addAdjVert(p2, e);
        int expResult = 1;
        int result = v.numAdjVerts();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllAdjVerts method, of class Vertex.
     */
    @Test
    public void testGetAllAdjVerts() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        Park p2 = new Park(1, "Park_test1", 1, 1, 1, 1, 1,0,0);
        v.setElement(p);
        v.addAdjVert(p2, e);
        Iterator<Park> it = v.getAllAdjVerts().iterator();
        List<Park>  result = new ArrayList<>();
        List<Park>  expResult = new ArrayList<>();
        expResult.add(p2);
        it.forEachRemaining(result::add);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllOutEdges method, of class Vertex.
     */
    @Test
    public void testGetAllOutEdges() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        Park p2 = new Park(1, "Park_test1", 1, 1, 1, 1, 1,0,0);
        v.setElement(p);
        v.addAdjVert(p2, e);
        Iterator<Edge<Park, Park>> it = v.getAllOutEdges().iterator();
        List<Edge<Park, Park>> result = new ArrayList<>();
        List<Edge<Park, Park>> expResult = new ArrayList<>();
        expResult.add(e);
        it.forEachRemaining(result::add);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Vertex.
     */
    @Test
    public void testEquals() {
        Vertex<Park, Park> v = new Vertex<>();
        Edge<Park, Park> e = new Edge<>();
        Park p = new Park(1000, "Park_test", 0, 0, 0, 0, 0,0,0);
        Park p2 = new Park(1001, "Park_test", 0, 0, 0, 0, 0,0,0);
        e.setElement(p2);
        v.addAdjVert(p2, e);
        v.setElement(p);
        v.setKey(1);
        Vertex<Park, Park> v2 = new Vertex<>();
        v2.setElement(p);
        v2.setKey(1);
        v2.addAdjVert(p2, e);
        boolean expResult = true;
        boolean result = v.equals(v2);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Vertex.
     */
    @Test
    public void testHashCode() {
        Vertex<Park, Park> v = new Vertex<>();
        Park p = new Park(0, "Park_test", 0, 0, 0, 0, 0,0,0);
        v.setElement(p);
        Vertex<Park, Park> v2 = new Vertex<>();
        v2.setElement(p);
        assertTrue(v.hashCode() == v2.hashCode());
    }
}
