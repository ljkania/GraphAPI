import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by LJK on 15/08/15.
 */
public class MultiGraph<VertexType, EdgeType> extends Observable implements Graph<VertexType, EdgeType> {
    protected List<Vertex<VertexType>> vertices;
    protected List<Edge<EdgeType>> edges;
    protected GraphNeighbourhoodType<VertexType, EdgeType> neighbourhoodType;
    protected Context context;

    public MultiGraph() {
        this.vertices = new ArrayList<Vertex<VertexType>>();
        this.edges = new ArrayList<Edge<EdgeType>>();
        this.neighbourhoodType = new UndirectedGraph();
        this.context = new Context(new EmptyGraphState());
    }

    public MultiGraph(GraphNeighbourhoodType<VertexType, EdgeType> neighbourhoodType) {
        if (neighbourhoodType == null) {
            throw new NullPointerException();
        }

        this.vertices = new ArrayList<Vertex<VertexType>>();
        this.edges = new ArrayList<Edge<EdgeType>>();
        this.neighbourhoodType = neighbourhoodType;
        this.context = new Context(new EmptyGraphState());
    }

    public MultiGraph(Graph<VertexType, EdgeType> graph) {
        if (graph == null) {
            throw new NullPointerException();
        }

        this.vertices = new ArrayList<Vertex<VertexType>>(graph.getVertices());
        this.edges = new ArrayList<Edge<EdgeType>>(graph.getEdges());
        this.neighbourhoodType = graph.getNeighbourhoodType();
        this.context = graph.getContext();
    }

    @Override
    public void setNeighbourhoodType(GraphNeighbourhoodType<VertexType, EdgeType> neighbourhoodType) {
        if (neighbourhoodType == null) {
            throw new NullPointerException();
        }

        this.neighbourhoodType = neighbourhoodType;
    }

    @Override
    public GraphNeighbourhoodType<VertexType, EdgeType> getNeighbourhoodType() {
        return this.neighbourhoodType;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public List<Edge<EdgeType>> getEdges() {
        return this.edges;
    }

    @Override
    public List<Vertex<VertexType>> getVertices() {
        return this.vertices;
    }

    @Override
    public int countEdges() {
        return this.edges.size();
    }

    @Override
    public int countVertices() {
        return this.vertices.size();
    }

    @Override
    public List<Vertex<VertexType>> getNeighbours(Vertex vertex) {
        if (vertex == null) {
            throw new NullPointerException();
        }

        return this.neighbourhoodType.getNeighbours(vertex, getEdges());
    }

    @Override
    public Vertex<VertexType> addVertex(VertexType value) {
        Vertex<VertexType> newVertex = new Vertex<VertexType>(value);
        this.vertices.add(newVertex);
        setChanged();
        notifyObservers();
        this.context.setState(new NonEmptyGraphState());
        return newVertex;
    }

    @Override
    public Edge addEdge(Vertex<VertexType> v1, Vertex<VertexType> v2, EdgeType value) throws Exception {
        if (v1 == null || v2 == null) {
            throw new NullPointerException();
        } else if (!this.vertices.contains(v1) || !this.vertices.contains(v2)) {
            throw new Exception("Vertex is not present in this graph.");
        }

        Edge<EdgeType> newEdge = new Edge<EdgeType>(v1, v2, value);
        if (this.edges.add(newEdge)) {
            setChanged();
            notifyObservers();
        }
        return newEdge;
    }

    @Override
    public boolean removeVertex(Vertex<VertexType> vertex) {
        if (vertex == null) {
            throw new NullPointerException();
        }

        for (Edge<EdgeType> edge : this.edges) {
            if (edge.getFirstVertex() == vertex || edge.getSecondVertex() == vertex)
                removeEdge(edge);
        }
        boolean result = this.vertices.remove(vertex);
        if (result) {
            setChanged();
            notifyObservers();
        }
        if (countVertices() == 0) {
            this.context.setState(new EmptyGraphState());
        }
        return result;
    }

    @Override
    public boolean removeEdge(Edge<EdgeType> edge) {
        if (edge == null) {
            throw new NullPointerException();
        }

        boolean result = this.edges.remove(edge);
        if (result) {
            setChanged();
            notifyObservers();
        }
        return result;
    }

    @Override
    public void clear() {
        this.vertices.clear();
        this.edges.clear();
        this.context.setState(new EmptyGraphState());
        setChanged();
        notifyObservers();
    }
}
