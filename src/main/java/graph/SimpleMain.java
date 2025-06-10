package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleMain {

    public static void main(String[] args) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, Set.of(3, 5));
        map.put(2, Set.of(4, 5));
        map.put(3, Set.of(1, 5));
        map.put(4, Set.of(1, 2));
        map.put(5, Set.of(2, 3));

        SimpleGraph graph = new SimpleGraph(map);

        System.out.println(graph);

        graph.addVertex(6);
        graph.addVertex(7);

        graph.addEdge(6, 7);

        System.out.println(graph);

        System.out.println(graph.removeEdge(6, 7));

        System.out.println(graph);
    }
}
