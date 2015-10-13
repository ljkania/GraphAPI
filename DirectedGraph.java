import java.util.ArrayList;
import java.util.List;

/**
 * Created by LJK on 05/09/15.
 */
public class DirectedGraph<VertexType, EdgeType> implements GraphNeighbourhoodType<VertexType, EdgeType> {
    @Override
    public List<Vertex<VertexType>> getNeighbours(Vertex<VertexType> vertex, List<Edge<EdgeType>> edges) {
        if (vertex == null || edges == null) {
            throw new NullPointerException();
        }
        List<Vertex<VertexType>> neighbours = new ArrayList<Vertex<VertexType>>();
        for (Edge<EdgeType> edge : edges) {
            if (edge.getFirstVertex() == vertex && neighbours.contains(edge.getSecondVertex()))
                neighbours.add(edge.getSecondVertex());
        }
        return neighbours;
    }
}
