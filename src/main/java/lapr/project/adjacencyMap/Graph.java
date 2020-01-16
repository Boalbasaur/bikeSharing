/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.adjacencyMap;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Filipa Pereira 1170657@isep.ipp.pt
 * @param <V>
 * @param <E>
 */
public class Graph<V, E> implements GraphInterface<V, E> {

    private int numVert;
    private int numEdge;
    private final boolean isDirected;
    private Map<V, Vertex<V, E>> vertices;  //all Vertices of the graph 

    // Constructs an empty graph (either undirected or directed)
    public Graph(boolean indirected) {
        numVert = 0;
        numEdge = 0;
        isDirected = indirected;
        vertices = new LinkedHashMap<>();
    }

    /**
     *
     * @return
     */
    @Override
    public int numVertices() {
        return numVert;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterable<V> vertices() {
        return vertices.keySet();
    }

    public boolean validVertex(V vert) {

        if (vertices.get(vert) == null) {
            return false;
        }

        return true;
    }

    public int getKey(V vert) {
        return vertices.get(vert).getKey();
    }

    @SuppressWarnings("unchecked")
    public V[] allkeyVerts() {

        V vertElem = null;
        for (Vertex<V, E> vert : vertices.values()) {
            vertElem = vert.getElement();            // To get type
        }
        V[] keyverts = (V[]) Array.newInstance(vertElem.getClass(), numVert);

        for (Vertex<V, E> vert : vertices.values()) {
            keyverts[vert.getKey()] = vert.getElement();
        }

        return keyverts;
    }

    public Iterable<V> adjVertices(V vert) {

        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.getAllAdjVerts();
    }

    @Override
    public int numEdges() {
        return numEdge;
    }

    @Override
    public Edge<V, E> getEdge(V vOrig, V vDest) {

        if (!validVertex(vOrig) || !validVertex(vDest)) {
            return null;
        }

        Vertex<V, E> vorig = vertices.get(vOrig);

        return vorig.getEdge(vDest);
    }

    @Override
    public V[] endVertices(Edge<V, E> edge) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param vert
     * @param edge
     * @return
     */
    @Override
    public V opposite(V vert, Edge<V, E> edge) {

        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.getAdjVert(edge);
    }

    @Override
    public int outDegree(V vert) {

        if (!validVertex(vert)) {
            return -1;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.numAdjVerts();
    }

    @Override
    public int inDegree(V vert) {

        if (!validVertex(vert)) {
            return -1;
        }

        int degree = 0;
        for (V otherVert : vertices.keySet()) {
            if (getEdge(otherVert, vert) != null) {
                degree++;
            }
        }

        return degree;
    }

    /**
     *
     * @param vert
     * @return
     */
    @Override
    public Iterable<Edge<V, E>> outgoingEdges(V vert) {

        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.getAllOutEdges();
    }

    @Override
    public Iterable<Edge<V, E>> incomingEdges(V vert) {
        if (!validVertex(vert)) {
            return null;
        }

        Vertex<V, E> vertex = vertices.get(vert);

        return vertex.getAllOutEdges();
    }

    @Override
    public boolean insertVertex(V vert) {

        if (validVertex(vert)) {
            return false;
        }

        Vertex<V, E> vertex = new Vertex<>(numVert, vert);
        vertices.put(vert, vertex);
        numVert++;

        return true;
    }

    @Override
    public boolean insertEdge(V vOrig, V vDest, E eInf, double eWeight) {

        if (getEdge(vOrig, vDest) != null) {
            return false;
        }

        if (!validVertex(vOrig)) {
            insertVertex(vOrig);
        }

        if (!validVertex(vDest)) {
            insertVertex(vDest);
        }

        Vertex<V, E> vorig = vertices.get(vOrig);
        Vertex<V, E> vdest = vertices.get(vDest);

        Edge<V, E> newEdge = new Edge<>(eInf, eWeight, vorig, vdest);
        vorig.addAdjVert(vDest, newEdge);
        numEdge++;

        //CONFIRMAR 
        //if graph is not direct insert other edge in the opposite direction 
        if (isDirected && getEdge(vDest, vOrig) == null) {
            Edge<V, E> otherEdge = new Edge<>(eInf, eWeight, vdest, vorig);
            vdest.addAdjVert(vOrig, otherEdge);
            numEdge++;
        }
        return true;
    }

    @Override
    public boolean removeVertex(V vert) {

        if (!validVertex(vert)) {
            return false;
        }

        //remove all edges that point to vert
        for (Edge<V, E> edge : incomingEdges(vert)) {
            V vadj = edge.getVOrig();
            removeEdge(vadj, vert);
        }

        Vertex<V, E> vertex = vertices.get(vert);

        //update the keys of subsequent vertices in the map
        for (Vertex<V, E> v : vertices.values()) {
            int keyVert = v.getKey();
            if (keyVert > vertex.getKey()) {
                keyVert = keyVert - 1;
                v.setKey(keyVert);
            }
        }
        //The edges that live from vert are removed with the vertex    
        vertices.remove(vert);

        numVert--;

        return true;
    }

    @Override
    public boolean removeEdge(V vOrig, V vDest) {

        if (!validVertex(vOrig) || !validVertex(vDest)) {
            return false;
        }

        Edge<V, E> edge = getEdge(vOrig, vDest);

        if (edge == null) {
            return false;
        }

        Vertex<V, E> vorig = vertices.get(vOrig);

        vorig.remAdjVert(vDest);
        numEdge--;

        //if graph is not direct 
        if (isDirected) {
            edge = getEdge(vDest, vOrig);
            if (edge != null) {
                Vertex<V, E> vdest = vertices.get(vDest);
                vdest.remAdjVert(vOrig);
                numEdge--;
            }
        }
        return true;
    }

    /* equals implementation
     * @param the other graph to test for equality
     * @return true if both objects represent the same graph
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object otherObj) {

        if (this == otherObj) {
            return true;
        }

        if (otherObj == null || this.getClass() != otherObj.getClass()) {
            return false;
        }

        Graph<V, E> otherGraph = (Graph<V, E>) otherObj;

        if (numVert != otherGraph.numVertices() || numEdge != otherGraph.numEdges()) {
            return false;
        }

        //graph must have same vertices
        boolean eqvertex;
        for (V v1 : this.vertices()) {
            eqvertex = false;
            for (V v2 : otherGraph.vertices()) {
                if (v1.equals(v2)) {
                    eqvertex = true;
                }
            }

            if (!eqvertex) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.numVert;
        hash = 29 * hash + this.numEdge;
        hash = 29 * hash + Objects.hashCode(this.vertices);
        return hash;
    }

    public boolean validEdge(V vOrig, V vDest) {
        if (!validVertex(vOrig) || !validVertex(vDest)) {
            return false;
        }

        return getEdge(vOrig, vDest) != null;
    }

    @Override
    public Iterable<Edge<V, E>> edges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
