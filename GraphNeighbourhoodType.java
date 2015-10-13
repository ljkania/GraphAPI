import java.util.List;

/**
 * Created by LJK on 08/09/15.
 */
public interface GraphNeighbourhoodType<VertexType, EdgeType> {
    public List<Vertex<VertexType>> getNeighbours(Vertex<VertexType> vertex, List<Edge<EdgeType>> edges);
}
