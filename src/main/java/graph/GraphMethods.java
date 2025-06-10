package graph;

public interface GraphMethods {

    void addVertex(Integer vertex);

    void addEdge(Integer vertexOne, Integer vertexTwo);

    boolean removeVertex(Integer vertex);

    boolean removeEdge(Integer vertexOne, Integer vertexTwo);

    void dfs();

    void bfs();

    void dijkstra(Integer from);
}
