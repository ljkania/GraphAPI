import java.util.List;

/**
 * Created by LJK on 06/09/15.
 */
public interface Graph<VertexType, EdgeType> {
    public void setNeighbourhoodType(GraphNeighbourhoodType<VertexType, EdgeType> neighbourhoodType);
    public GraphNeighbourhoodType<VertexType, EdgeType> getNeighbourhoodType();
    public void setContext(Context context);
    public Context getContext();
    public List<Edge<EdgeType>> getEdges();
    public List<Vertex<VertexType>> getVertices();
    public int countEdges();
    public int countVertices();
    public List<Vertex<VertexType>> getNeighbours(Vertex<VertexType> vertex);
    public Vertex<VertexType> addVertex(VertexType value);
    public Edge addEdge(Vertex<VertexType> v1, Vertex<VertexType> v2, EdgeType value) throws Exception;
    public boolean removeVertex(Vertex<VertexType> vertex);
    public boolean removeEdge(Edge<EdgeType> edge);
    public void clear();
}
