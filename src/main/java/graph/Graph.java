package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static class Vertex {
        private int number;
        private List<Vertex> neighbours = new ArrayList<>();

        public Vertex(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return Integer.toString(number);
        }
    }

    public static class Edge {
        private Vertex vertexOne;
        private Vertex vertexTwo;

        public Edge(int numberOne, int numberTwo) {
            vertexOne = new Vertex(numberOne);
            vertexTwo = new Vertex(numberTwo);
        }

        public Edge(Vertex vertexOne, Vertex vertexTwo) {
            this.vertexOne = vertexOne;
            this.vertexTwo = vertexTwo;
        }

        @Override
        public String toString() {
            return "(" + vertexOne.toString() + "-" + vertexTwo.toString() + ")";
        }
    }

    private List<Vertex> verteces;
    private List<Edge> edges;

    public Graph(List<Vertex> verteces, List<Edge> edges) {
        this.verteces = verteces;
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "verteces=" + verteces +
                ", edges=" + edges +
                '}';
    }
}


