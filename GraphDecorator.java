/**
 * Created by LJK on 15/08/15.
 */

import java.util.*;

public abstract class GraphDecorator<VertexType, EdgeType> extends Observable
        implements Graph<VertexType, EdgeType> {
    protected Graph<VertexType, EdgeType> graph;
    protected ArrayList<Vertex<VertexType>> visited;

    public GraphDecorator(Graph<VertexType, EdgeType> graph) {
        if (graph == null) {
            throw new NullPointerException();
        }

        this.graph = graph;
        this.visited = new ArrayList<Vertex<VertexType>>();
    }

    @Override
    public List<Edge<EdgeType>> getEdges() {
        return this.graph.getEdges();
    }

    @Override
    public List<Vertex<VertexType>> getVertices() {
        return this.graph.getVertices();
    }

    @Override
    public int countEdges() {
        return this.graph.countEdges();
    }

    @Override
    public int countVertices() {
        return this.graph.countVertices();
    }

    @Override
    public Vertex<VertexType> addVertex(VertexType value) {
        return this.graph.addVertex(value);
    }

    @Override
    public Edge<EdgeType> addEdge(Vertex<VertexType> v1, Vertex<VertexType> v2, EdgeType value) throws Exception {
        return this.graph.addEdge(v1, v2, value);
    }

    @Override
    public boolean removeVertex(Vertex<VertexType> vertex) {
        return this.graph.removeVertex(vertex);
    }

    @Override
    public boolean removeEdge(Edge<EdgeType> edge) {
        return this.graph.removeEdge(edge);
    }

    @Override
    public List<Vertex<VertexType>> getNeighbours(Vertex<VertexType> vertex) {
        return this.graph.getNeighbours(vertex);
    }

    @Override
    public void clear() {
        this.graph.clear();
        this.visited.clear();
    }

    public void clearVisited() {
        this.visited.clear();
    }

    public boolean setVisited(Vertex<VertexType> vertex, boolean visited) {
        if (vertex == null) {
            throw new NullPointerException();
        }
        return visited ? this.visited.add(vertex) : this.visited.remove(vertex);
    }

    public boolean isVisited(Vertex vertex) {
        if(vertex == null) {
            throw new NullPointerException();
        }
        return this.visited.contains(vertex);
    }
}
