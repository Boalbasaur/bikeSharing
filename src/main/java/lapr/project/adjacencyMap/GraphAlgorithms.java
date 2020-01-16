/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.adjacencyMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import lapr.project.model.Path;
import lapr.project.model.PathInfo;

/**
 *
 * @author Tomas
 */
public class GraphAlgorithms {

    protected static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {
        path.addFirst(vDest);
        int key = pathKeys[g.getKey(vDest)];
        if (key != -1 && vOrig != vDest && vOrig != vDest) {
            getPath(g, vOrig, verts[key], verts, pathKeys, path);

        }
    }

    @SuppressWarnings("unchecked")
    public static <V, E> void shortestPathsList(Graph<V, E> g, V vOrig, V vDest, Set<V> touristPoints, PriorityQueue<Path> caminhoFinal, boolean isDistance) {

        ArrayList<Double> dists = new ArrayList<>();
        ArrayList<LinkedList<V>> allSubPaths = new ArrayList<>();

        shortestPathsDistance(g, vOrig, allSubPaths, dists, isDistance);
        int aux = 0;
        @SuppressWarnings("unchecked")
        ArrayList<LinkedList<V>> clone = (ArrayList<LinkedList<V>>) allSubPaths.clone();
        for (LinkedList<V> SubPath : clone) {
            if (!touristPoints.contains(SubPath.getLast())) {
                dists.remove(aux);
                allSubPaths.remove(SubPath);
            } else {
                aux++;
            }
        }

        ArrayList<LinkedList<V>> allSubPathsAUX = new ArrayList<>();
        ArrayList<Double> distsAUX = new ArrayList<>();
        int aux2 = 0;
        for (V v : touristPoints) {
            aux2 = 0;
            shortestPathsDistance(g, v, allSubPathsAUX, distsAUX, isDistance);
            for (LinkedList<V> SubPath : allSubPathsAUX) {
                if ((touristPoints.contains(SubPath.getFirst()) && touristPoints.contains(SubPath.getLast())) || (touristPoints.contains(SubPath.getFirst()) && SubPath.getLast().equals(vDest))) {
                    allSubPaths.add(SubPath);
                    dists.add(distsAUX.get(aux2));

                }
                aux2++;
            }
        }

        HashSet<V> knowVertices = new HashSet<>();
        Double custo = Double.valueOf(0);
        for (V v : touristPoints) {
            knowVertices.add(v);
        }

        caminhoFinal.clear();
        caminhoFinal.add(new Path(new LinkedList<>(), Double.MAX_VALUE, isDistance));
        LinkedList<LinkedList<V>> pathBuilder = new LinkedList<>();
        
        nextPath(vOrig, vDest, allSubPaths, dists, pathBuilder, custo, knowVertices, caminhoFinal, isDistance);
    }

    public static <V, E> boolean shortestPathsDistance(Graph<V, E> g, V vOrig, List<LinkedList<V>> paths, List<Double> dists, boolean isDistance) {

        if (!g.validVertex(vOrig)) {
            return false;
        }

        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts];
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }

        shortestPathLengthDistance(g, vOrig, vertices, visited, pathKeys, dist, isDistance);

        dists.clear();
        paths.clear();
        for (int i = 0; i < nverts; i++) {
            paths.add(null);
            dists.add(null);
        }
        for (int i = 0; i < nverts; i++) {
            LinkedList<V> shortPath = new LinkedList<>();
            if (Math.abs(dist[i]-Double.MAX_VALUE)>1) {
                getPath(g, vOrig, vertices[i], vertices, pathKeys, shortPath);
            }
            paths.set(i, shortPath);
            dists.set(i, dist[i]);
        }
        return true;
    }

    private static <V, E> void shortestPathLengthDistance(Graph<V, E> g, V vOrig, V[] vertices, boolean[] visited, int[] pathKeys, double[] dist, boolean isDistance) {
        for (V v : vertices) {
            dist[g.getKey(v)] = Double.POSITIVE_INFINITY;
            pathKeys[g.getKey(v)] = -1;
            visited[g.getKey(v)] = false;
        }

        dist[g.getKey(vOrig)] = 0;

        while (vOrig != null) {
            int vOrigValue = g.getKey(vOrig);
            visited[vOrigValue] = true;

            if (isDistance) {
                for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                    V vAdj = g.opposite(vOrig, edge);
                    if (!visited[g.getKey(vAdj)] && dist[g.getKey(vAdj)] > dist[vOrigValue] + ((PathInfo) edge.getElement()).getDistance()) {
                        dist[g.getKey(vAdj)] = dist[vOrigValue] + ((PathInfo) edge.getElement()).getDistance();
                        pathKeys[g.getKey(vAdj)] = vOrigValue;
                    }
                }
            } else {
                for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                    V vAdj = g.opposite(vOrig, edge);
                    if (!visited[g.getKey(vAdj)] && dist[g.getKey(vAdj)] > dist[vOrigValue] + ((PathInfo) edge.getElement()).getEnergyNeeded()) {
                        dist[g.getKey(vAdj)] = dist[vOrigValue] + ((PathInfo) edge.getElement()).getEnergyNeeded();
                        pathKeys[g.getKey(vAdj)] = vOrigValue;
                    }
                }
            }

            vOrig = null;
            double minimunDistance = Double.POSITIVE_INFINITY;

            for (V ver : vertices) {
                int vId = g.getKey(ver);
                if (!visited[vId] && dist[vId] < minimunDistance) {
                    vOrig = ver;
                    minimunDistance = dist[vId];
                }
            }
        }
    }

    /**
     *
     * @param <V>
     * @param last vertice de inicio de no path
     * @param vDest vertice do final do path
     * @param allSubPaths todos os caminho entre os veticites de "origem e
     * vertices a passar", "entre os vertices a passar" e os "vertices a passar
     * e o destino"
     * @param dists o custo de cada caminho vindo de allsubpaths
     * @param pathBuilder path que vai sendo contruido e desmantelado
     * @param custo custo do path builder
     * @param knowVertices vertices por que o pathBuilder ja passou
     * @param caminhos Resultado final Path com custo
     * @return custo do path builder
     */
    @SuppressWarnings("unchecked")
    private static <V> double nextPath(V last, V vDest, ArrayList<LinkedList<V>> allSubPaths, ArrayList<Double> dists, LinkedList<LinkedList<V>> pathBuilder, Double custo, HashSet<V> knowVertices, PriorityQueue<Path> caminhos, boolean isDistance) {
        int aux = 0;
        for (LinkedList<V> SubPath : allSubPaths) {
            if (SubPath.getFirst().equals(last)) {
                if (!knowVertices.isEmpty() && !SubPath.getLast().equals(vDest) && knowVertices.contains(SubPath.getLast())) {
                    pathBuilder.addLast(SubPath);
                    custo = custo + dists.get(aux);
                    if (custo < caminhos.peek().getDistance() && isDistance) {
                        knowVertices.remove(SubPath.getLast());
                        custo = nextPath(SubPath.getLast(), vDest, allSubPaths, dists, pathBuilder, custo, knowVertices, caminhos, isDistance);
                        knowVertices.add(SubPath.getLast());
                    } else if (custo < caminhos.peek().getEnergyNeeded() && !isDistance) {
                        knowVertices.remove(SubPath.getLast());
                        custo = nextPath(SubPath.getLast(), vDest, allSubPaths, dists, pathBuilder, custo, knowVertices, caminhos, isDistance);
                        knowVertices.add(SubPath.getLast());
                    }
                    pathBuilder.removeLast();
                    custo = custo - dists.get(aux);

                } else if (SubPath.getLast().equals(vDest) && knowVertices.isEmpty()) {
                    pathBuilder.addLast(SubPath);
                    custo = custo + dists.get(aux);
                    if (isDistance) {
                        caminhos.add(new Path((LinkedList<LinkedList<String>>) pathBuilder.clone(), custo, isDistance));
                    } else if (!isDistance) {
                        caminhos.add(new Path((LinkedList<LinkedList<String>>) pathBuilder.clone(), custo, isDistance));

                    }
                    pathBuilder.removeLast();
                    custo = custo - dists.get(aux);
                    return custo;
                }
            }
            aux++;
        }
        return custo;
    }

    public static <V, E> double shortestPathDistance(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {

        boolean isDistance = true;
        if (!g.validVertex(vOrig) || !g.validVertex(vDest)) {
            return -1d;
        }

        int numVert = g.numVertices();

        V[] vertices = g.allkeyVerts().clone();
        boolean[] visited = new boolean[numVert];
        int[] pathKeys = new int[numVert];
        double[] dist = new double[numVert];

        shortestPathLengthDistance(g, vOrig, vertices, visited, pathKeys, dist, isDistance);
        shortPath.clear();
        if (!visited[g.getKey(vDest)]) {
            return -1d;
        }
        getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);

        int vDestId = g.getKey(vDest);
        if (!visited[vDestId]) {
            return -1d;
        }

        return dist[vDestId];
    }
}
