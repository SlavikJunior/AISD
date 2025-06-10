package graph;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Graph.Vertex> vertices = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Graph.Vertex v = new Graph.Vertex(i);
            vertices.add(v);
        }

        List<Graph.Edge> edges = List.of(
                new Graph.Edge(vertices.get(0), vertices.get(2)),
                new Graph.Edge(vertices.get(0), vertices.get(3)),

                new Graph.Edge(vertices.get(1), vertices.get(3)),
                new Graph.Edge(vertices.get(1), vertices.get(4)),

                new Graph.Edge(vertices.get(2), vertices.get(0)),
                new Graph.Edge(vertices.get(2), vertices.get(4)),

                new Graph.Edge(vertices.get(3), vertices.get(0)),
                new Graph.Edge(vertices.get(3), vertices.get(1)),

                new Graph.Edge(vertices.get(4), vertices.get(1)),
                new Graph.Edge(vertices.get(4), vertices.get(2))
                );
        Graph graph = new Graph(vertices, edges);
        System.out.println(graph);
    }
}
