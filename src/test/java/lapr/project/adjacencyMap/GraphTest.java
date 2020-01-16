/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.adjacencyMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lapr.project.model.PathInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class GraphTest {

    /**
     * Test of numVertices method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testNumVertices() {
        Graph<String, PathInfo> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        int expResult = 2;
        int result = graph.numVertices();
        assertEquals(expResult, result);
    }

    /**
     * Test of vertices method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testVertices() {
        Graph<String, PathInfo> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        Vertex<String, PathInfo> v = new Vertex<>(0, "Park_1");
        Vertex<String, PathInfo> v2 = new Vertex<>(1, "Park_2");
        Iterator<String> it = graph.vertices().iterator();
        List<String> result = new ArrayList<>();
        it.forEachRemaining(result::add);
        List<String> expResult = new ArrayList<>();
        expResult.add("Park_1");
        expResult.add("Park_2");
        assertEquals(expResult, result);
    }

    /**
     * Test of validVertex method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testValidVertex() {
        Graph<String, PathInfo> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        boolean expResult = true;
        boolean result = graph.validVertex("Park_1");
        assertEquals(expResult, result);
    }

    /**
     * Test of getKey method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testGetKey() {
        Graph<String, PathInfo> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        int expResult = 0;
        int result = graph.getKey("Park_1");
        assertEquals(expResult, result);
    }

    /**
     * Test of numEdges method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testNumEdges() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        int expResult = 1;
        int result = graph.numEdges();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEdge method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testGetEdge() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Edge<String, String> result = graph.getEdge("Park_1", "Park_2");
        Vertex<String, String> v = new Vertex<>();
        v.setElement("Park_1");
        Vertex<String, String> v2 = new Vertex<>();
        v2.setElement("Park_1");
        Edge<String, String> expResult = new Edge<>("Edge_1", 0, v, v2);
        assertEquals(expResult.getWeight(), result.getWeight());
        
        result = graph.getEdge("Park_3", "Park_4");
        expResult = null;
        assertEquals(expResult, result);
    }

    /**
     * Test of opposite method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testOpposite() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Edge<String, String> edge = graph.getEdge("Park_1", "Park_2");
        String result = graph.opposite("Park_1", edge);
        String expResult = "Park_2";
        assertEquals(expResult, result);
        
        result = graph.opposite("Park_4", edge);
        expResult = null;
        assertEquals(expResult, result);
    }

    /**
     * Test of outDegree method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testOutDegree() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        int expResult = 1;
        int result = graph.outDegree("Park_1");
        assertEquals(expResult, result);
        
        expResult = -1;
        result = graph.outDegree("Park_3");
        assertEquals(expResult, result);
    }

    /**
     * Test of inDegree method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testInDegree() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_2", "Park_1", "Edge_1", 0);
        int expResult = 1;
        int result = graph.inDegree("Park_1");
        assertEquals(expResult, result);
        
        expResult = -1;
        result = graph.inDegree("Park_3");
        assertEquals(expResult, result);
    }

    /**
     * Test of outgoingEdges method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testOutgoingEdges() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Iterator<Edge<String, String>> it = graph.outgoingEdges("Park_1").iterator();
        List<Edge<String, String>> list = new ArrayList<>();
        it.forEachRemaining(list::add);
        int result = list.size();
        int expResult = 1;
        assertEquals(expResult, result);
        
        Iterable<Edge<String, String>> result2 = graph.outgoingEdges("Park_3");
        Iterator<Edge<String, String>> expResult2 = null;
        assertEquals(expResult2, result2);
    }

    /**
     * Test of incomingEdges method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testIncomingEdges() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Iterator<Edge<String, String>> it = graph.incomingEdges("Park_1").iterator();
        List<Edge<String, String>> list = new ArrayList<>();
        it.forEachRemaining(list::add);
        int result = list.size();
        int expResult = 1;
        assertEquals(expResult, result);
        
        Iterable<Edge<String, String>> result2 = graph.incomingEdges("Park_3");
        Iterator<Edge<String, String>> expResult2 = null;
        assertEquals(expResult2, result2);
    }

    /**
     * Test of insertVertex method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testInsertVertex() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        int result = graph.numVertices();
        int expResult = 1;
        assertEquals(expResult, result);
        
        boolean result2 = graph.insertVertex("Park_1");
        boolean expResult2 = false;
        assertEquals(expResult2, result2);
    }

    /**
     * Test of insertEdge method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testInsertEdge() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        int result = graph.numEdges();
        int expResult = 1;
        assertEquals(expResult, result);
        
        boolean result2 = graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        boolean expResult2 = false;
        assertEquals(expResult2, result2);
    }

    /**
     * Test of removeVertex method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testRemoveVertex() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.removeVertex("Park_1");
        int result = graph.numVertices();
        int expResult = 1;
        assertEquals(expResult, result);
        
        boolean result2 = graph.removeVertex("Park_3");
        boolean expResult2 = false;
        assertEquals(expResult2, result2);
    }

    /**
     * Test of removeEdge method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testRemoveEdge() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertVertex("Park_3");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        graph.insertEdge("Park_1", "Park_3", "Edge_2", 0);
        graph.removeEdge("Park_1", "Park_2");
        int result = graph.numEdges();
        int expResult = 1;
        assertEquals(expResult, result);
        
        boolean result2 = graph.removeEdge("Park_7", "Park_5");
        boolean expResult2 = false;
        assertEquals(expResult2, result2);
    }

    /**
     * Test of equals method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testEquals() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertVertex("Park_3");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Graph<String, String> graph2 = new Graph<>(false);
        graph2.insertVertex("Park_1");
        graph2.insertVertex("Park_2");
        graph2.insertVertex("Park_3");
        graph2.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        boolean expResult = true;
        boolean result = graph.equals(graph2);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testHashCode() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertVertex("Park_3");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Graph<String, String> graph2 = new Graph<>(false);
        graph2.insertVertex("Park_1");
        graph2.insertVertex("Park_2");
        graph2.insertVertex("Park_3");
        graph2.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        assertTrue(graph.hashCode() == graph2.hashCode());
    }

    /**
     * Test of validEdge method, of class Graph.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testValidEdge() {
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertVertex("Park_3");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        boolean expResult = true;
        boolean result = graph.validEdge("Park_1", "Park_2");
        assertEquals(expResult, result);
        
        expResult = false;
        result = graph.validEdge("Park_4", "Park_5");
        assertEquals(expResult, result);
    }
    
    /**
     * Test of adjVertices method, of class Graph.
     */
    @Test
    public void testAdjVertices(){
        Graph<String, String> graph = new Graph<>(false);
        graph.insertVertex("Park_1");
        graph.insertVertex("Park_2");
        graph.insertEdge("Park_1", "Park_2", "Edge_1", 0);
        Iterator<String> it = graph.adjVertices("Park_1").iterator();
        List<String> list = new ArrayList<>();
        it.forEachRemaining(list::add);
        
        boolean expResult = true;
        boolean result = list.contains("Park_2");
        assertEquals(expResult, result);
        
        Iterable<String> result2 = graph.adjVertices("Park_3");
        assertEquals(null, result2);
    }

}
