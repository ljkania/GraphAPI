import java.util.Iterator;

/**
 * Created by LJK on 06/09/15.
 */
public interface TraverseStrategy<VertexType, EdgeType> {
    Iterator<Vertex<VertexType>> getOrder(GraphDecorator<VertexType, EdgeType> graph) throws Exception;
}
