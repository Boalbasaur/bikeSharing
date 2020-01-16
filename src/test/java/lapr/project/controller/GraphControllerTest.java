/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lapr.project.adjacencyMap.Edge;
import lapr.project.adjacencyMap.Graph;
import lapr.project.model.Bike;
import lapr.project.model.Park;
import lapr.project.model.PathInfo;
import lapr.project.model.TouristPoint;
import lapr.project.model.User;
import lapr.project.model.Wind;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 */
public class GraphControllerTest {

    /**
     * Test of preencherGrafo method, of class MainController.
     */
    @Test
    public void testFillGraph() {
        System.out.println("preencherGrafo");
        List<String> myList = new ArrayList<>();
        GraphController controller = new GraphController();
        controller.fillGraph();
        Iterator<String> it = controller.getVertices().iterator();
        it.forEachRemaining(myList::add);

        boolean result = myList.contains("Park_1");
        boolean expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_3");
        assertEquals(expResult, result);

        result = myList.contains("TouristPoint_1");
        assertEquals(expResult, result);

        result = myList.contains("Park_100000");
        expResult = false;
        assertEquals(expResult, result);

        result = myList.contains("Park_2");
        expResult = true;
        assertEquals(expResult, result);

//        it = controller.getVertices().iterator();
//        controller.removeVertex("Park_2");
//        myList.clear();
//        it.forEachRemaining(myList::add);
//        
//        result = myList.contains("Park_2");
//        expResult = false;
//        assertEquals(expResult, result);
    }

    /**
     * Test of inserirArestas method, of class MainController.
     */
    @Test
    public void testInsertEdgesOnDB() {
        GraphController controller = new GraphController();
        controller.fillGraph();
        controller.insertEdgesOnDB();

        boolean result = controller.isEdge("Park_1", "Park_3");
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of getGrafo method, of class GraphController.
     */
    @Test
    public void testGetGrafo() {
        System.out.println("getGrafo");
        GraphController controller = new GraphController();
        controller.fillGraph();
        Graph<String, PathInfo> graph = controller.getGrafo();
        Iterator<String> it = controller.getVertices().iterator();
        List<String> myList = new ArrayList<>();
        it.forEachRemaining(myList::add);

        boolean result = myList.contains("Park_1");
        boolean expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_2");
        expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_3");
        expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_666");
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of getVertices method, of class GraphController.
     */
    @Test
    public void testGetVertices() {
        GraphController controller = new GraphController();
        controller.fillGraph();
        Iterator<String> it = controller.getVertices().iterator();
        List<String> myList = new ArrayList<>();
        it.forEachRemaining(myList::add);

        boolean result = myList.contains("Park_1");
        boolean expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_2");
        expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_3");
        expResult = true;
        assertEquals(expResult, result);

        result = myList.contains("Park_666");
        expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of removeVertex method, of class GraphController.
     */
    @Test
    public void testRemoveVertex() {
        System.out.println("removeVertex");
        GraphController controller = new GraphController();
        controller.fillGraph();
        String vertexToRemove = "Park_1";
        controller.removeVertex(vertexToRemove);
        Iterator<String> it = controller.getVertices().iterator();
        List<String> myList = new ArrayList<>();
        it.forEachRemaining(myList::add);

        boolean result = myList.contains("Park_1");
        boolean expResult = false;
        assertEquals(expResult, result);

    }

    /**
     * Test of isEdge method, of class GraphController.
     */
    @Test
    public void testIsEdge() {
        System.out.println("isEdge");
        GraphController controller = new GraphController();
        controller.fillGraph();
        String vOrig = "Park_1";
        String vDest = "Park_2";
        boolean expResult = false;
        boolean result = controller.isEdge(vOrig, vDest);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertVertexPark method, of class GraphController.
     */
    @Test
    public void testInsertVertexPark() {
        System.out.println("insertVertexPark");
        Park p = new Park(1000, "teste", 0, 0, 0, 0, 0, 0, 0);
        GraphController controller = new GraphController();
        controller.insertVertexPark(p);
        int result = controller.getGrafo().numVertices();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of insertVertexTouristPoint method, of class GraphController.
     */
    @Test
    public void testInsertVertexTouristPoint() {
        System.out.println("insertVertexTouristPoint");
        TouristPoint tp = new TouristPoint(1000, "teste", 0, 0, 0);
        GraphController controller = new GraphController();
        controller.insertVertexTouristPoint(tp);
        int result = controller.getGrafo().numVertices();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of insertEdge method, of class GraphController.
     */
    @Test
    public void testInsertEdge() {
        System.out.println("insertEdge");
        Park p1 = new Park(1001, "teste1", 0, 0, 0, 0, 0, 0, 0);
        Park p2 = new Park(1002, "teste2", 0, 0, 0, 0, 0, 0, 0);

        Wind w = new Wind("Park_1001", "Park_1002", 0.0, 0.0f, 45.7);
        GraphController controller = new GraphController();
        controller.insertVertexPark(p1);
        controller.insertVertexPark(p2);
        controller.insertEdge(w);
        int result = controller.getGrafo().numEdges();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateDistance method, of class GraphController.
     */
    @Test
    public void testCalculateDistance() {
        Park p1 = new Park(1001, "teste1", 0, 0, 0, 0, 0, 0, 0);
        Park p2 = new Park(1002, "teste2", 0, 0, 0, 0, 0, 0, 0);
        Wind w = new Wind("Park_1001", "Park_1002", 0.0, 0.0f, 45.7);
        GraphController controller = new GraphController();
        controller.insertVertexPark(p1);
        controller.insertVertexPark(p2);
        double expResult = 0.0;
        double result = controller.calculateDistance(w);
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getIdObject method, of class GraphController.
     */
    @Test
    public void testGetIdObject() {
        int id = 0;
        Park p = new Park(11111111, "teste", 0.0f, 0.0f, 1000, 500, 0.0f, 9.5, 67.8);
        TouristPoint tp = new TouristPoint(111111, "teste", 0.0f, 0.0f, 0.0f);
        GraphController controller = new GraphController();

        controller.insertVertexPark(p);
        ArrayList<Object> expResult = new ArrayList<>();
        expResult.add(p);
        expResult.add("Park");
        ArrayList<Object> result = controller.getIdObject(p.getIdPark());
        assertEquals(expResult, result);

        result.clear();
        expResult.clear();
        expResult.add(tp);
        controller.insertVertexTouristPoint(tp);
        expResult.add("TouristPoint");
        result = controller.getIdObject(tp.getIdTouristPoint());
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateEnergy method, of class GraphController.
     */
    @Test
    public void testCalculateEnergy() {
        GraphController controller = new GraphController();
        Park p = new Park(1, "origem1", (float) 41.157944, (float) -8.629105, 1000, 500, (float) 86.0, 70.6, 45.7);
        Park p1 = new Park(2, "destination1", (float) 38.722252, (float) -9.139337, 1000, 500, (float) 56.0, 89.0, 65.2);
        TouristPoint tp = new TouristPoint(1, "destination2", (float) -9.139337, (float) 38.722252, (float) 56.0);
        TouristPoint tp1 = new TouristPoint(2, "origem2", (float) -8.629105, (float) 41.157944, (float) 86.0);
        Wind w = new Wind("Park_1", "TouristPoint_1", 0.0, (float) 0.0, 0.0);
        Wind w1 = new Wind("TouristPoint_2", "Park_2", 0.0, (float) 0.0, 0.0);
        Wind w2 = new Wind("TouristPoint_2", "TouristPoint_1", 0.0, (float) 0.0, 0.0);
        Wind w3 = new Wind("Park_1", "Park_2", 0.0, (float) 0.0, 0.0);
        Bike bike = new Bike("1", "1", "battery", "maxCapacity", 10, 45.7, 34.5, (float) 45.67658, (float) 89.085994, 0.0);
        String username = "administrador";

        User u = new User("Dave", username, "qwerty", "1170657@isep.ipp.pt", "1234567891234567", 175, 75, "2", 2, 10);

        controller.insertVertexPark(p);
        controller.insertVertexPark(p1);
        controller.insertVertexTouristPoint(tp);
        controller.insertVertexTouristPoint(tp1);
        controller.insertEdge(w);
        controller.insertEdge(w1);
        controller.insertEdge(w2);
        controller.insertEdge(w3);

        //Bike bike, int origin, int destination, User user
        ArrayList<Object> arrOrig = new ArrayList<>();
        arrOrig.add(p);
        arrOrig.add("Park");
        ArrayList<Object> arrDest = new ArrayList<>();
        arrDest.add(tp);
        arrDest.add("TouristPoint");
        controller.calculateEnergy(bike, arrOrig, arrDest, u);
        Edge<String, PathInfo> edge = controller.getGrafo().getEdge("Park_1", "TouristPoint_1");
        assertEquals(bike, edge.getElement().getBike());
        arrOrig.clear();
        arrDest.clear();

        arrOrig.add(tp1);
        arrOrig.add("TouristPoint");
        arrDest.add(p1);
        arrDest.add("Park");
        controller.calculateEnergy(bike, arrOrig, arrDest, u);
        Edge<String, PathInfo> edge1 = controller.getGrafo().getEdge("TouristPoint_2", "Park_2");
        assertEquals(bike, edge1.getElement().getBike());
        arrOrig.clear();
        arrDest.clear();

        arrOrig.add(tp1);
        arrOrig.add("TouristPoint");
        arrDest.add(tp);
        arrDest.add("TouristPoint");
        controller.calculateEnergy(bike, arrOrig, arrDest, u);
        Edge<String, PathInfo> edge2 = controller.getGrafo().getEdge("TouristPoint_2", "TouristPoint_1");
        assertEquals(bike, edge2.getElement().getBike());
        arrOrig.clear();
        arrDest.clear();

        arrOrig.add(p);
        arrOrig.add("Park");
        arrDest.add(p1);
        arrDest.add("Park");
        controller.calculateEnergy(bike, arrOrig, arrDest, u);
        Edge<String, PathInfo> edge3 = controller.getGrafo().getEdge("Park_1", "Park_2");
        assertEquals(bike, edge3.getElement().getBike());
        arrOrig.clear();
        arrDest.clear();
    }

}
