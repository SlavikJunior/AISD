package graph;

import java.util.Map;
import java.util.Set;

public class SimpleGraph implements GraphMethods {

    private Map<Integer, Set<Integer>> map;

    public SimpleGraph(Map<Integer, Set<Integer>> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "SimpleGraph{" +
                "map=" + map +
                '}';
    }

    @Override
    public void addVertex(Integer vertex) {
        map.put(vertex, null);
    }

    @Override
    public void addEdge(Integer vertexOne, Integer vertexTwo) {
        map.put(vertexOne, Set.of(vertexOne, vertexTwo));
        map.put(vertexTwo, Set.of(vertexTwo, vertexOne));
    }

    @Override
    public boolean removeVertex(Integer vertex) {
        Set<Integer> removed = map.remove(vertex);
        // если было ребро
        if (removed != null)
            return true;
        // если ребра не было
        return false;
    }

    @Override
    public boolean removeEdge(Integer vertexOne, Integer vertexTwo) {
        boolean r1 = map.remove(vertexOne, Set.of(vertexOne, vertexTwo));
        boolean r2 = map.remove(vertexTwo, Set.of(vertexOne, vertexTwo));

        return r1 && r2;
    }

    @Override
    public void dfs() {

    }

    @Override
    public void bfs() {

    }

    @Override
    public void dijkstra(Integer from) {

    }
}
