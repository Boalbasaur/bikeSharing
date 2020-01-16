package lapr.project.adjacencyMap;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 * 
 * @author DEI-ESINF
 * @param <V>
 * @param <E>
 */

public class Edge<V,E> implements Comparable<V>{
    
    private E element;           // Edge information
    private double weight;       // Edge weight
    private Vertex<V,E> vOrig;  // vertex origin
    private Vertex<V,E> vDest;  // vertex destination
    
    public Edge() {
        element = null; 
        weight= 0.0; 
        vOrig=null; 
        vDest=null; } 
    
    public Edge(E eInf, double ew, Vertex<V,E> vo, Vertex<V,E> vd) {
        element = eInf; 
        weight= ew; 
        vOrig=vo; 
        vDest=vd;} 
  
    public E getElement() { return element; }	 
    public void setElement(E eInf) { element = eInf; }
    
    public double getWeight() { return weight; }	 
    public void setWeight(double ew) { weight= ew; }
    
    public V getVOrig() { return vOrig.getElement(); }	 
    public void setVOrig(Vertex<V,E> vo) { vOrig= vo; }
    
    public V getVDest() { return vDest.getElement(); }	 
    public void setVDest(Vertex<V,E> vd) { vDest= vd; }
    
    @SuppressWarnings("unchecked")
    public V[] getEndpoints() { 
         
        V oElem = vOrig.getElement(); 
        V dElem = vDest.getElement(); // To get type

        V[] endverts = (V [])Array.newInstance(oElem.getClass(), 2);  

        endverts[0]= oElem; 
        endverts[1]= dElem;
        
        return endverts; 
    }
           
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object otherObj) {
        
        if (this == otherObj){
            return true;
        }
        
        if (otherObj == null || this.getClass() != otherObj.getClass()){
            return false;
        }
        
        Edge<V,E> otherEdge = (Edge<V,E>) otherObj;
        
        // if endpoints vertices are not equal
        if (!this.vOrig.equals(otherEdge.vOrig) || !this.vDest.equals(otherEdge.vDest))
           return false;
      
        if (this.weight != otherEdge.weight)
            return false;
        
        if (this.element != null && otherEdge.element != null) 
           return this.element.equals(otherEdge.element);
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.element);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.vOrig);
        hash = 97 * hash + Objects.hashCode(this.vDest);
        return hash;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Object otherObject) {
        
        Edge<V,E> other = (Edge<V,E>) otherObject ;
        if (this.weight < other.weight){
            return -1;
        }
        if (this.weight == other.weight){
            return 0;
        }
        return 1;
    }
}