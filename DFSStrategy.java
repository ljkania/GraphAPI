import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LJK on 06/09/15.
 */

public abstract class DFSStrategy<VertexType, EdgeType> implements TraverseStrategy<VertexType, EdgeType> {
    protected List<Vertex<VertexType>> order;
    protected GraphDecorator<VertexType, EdgeType> graph;

    @Override
    public Iterator<Vertex<VertexType>> getOrder(GraphDecorator<VertexType, EdgeType> graph) throws Exception {
        if (graph == null) {
            throw new NullPointerException();
        }
        this.graph = graph;
        this.graph.clearVisited();
        this.order = new ArrayList<Vertex<VertexType>>();

        while (this.order.size() < this.graph.countVertices()) {
            List<Vertex<VertexType>> vertices = this.graph.getVertices();
            Vertex<VertexType> source = null;
            for(Vertex<VertexType> vertex : vertices) {
                if(!this.graph.isVisited(vertex)) {
                    source = vertex;
                    break;
                }
            }
            if(source == null) {
                throw new Exception("Unknown error appeared.");
            }
            DFSStep(source);
        }

        return this.order.iterator();
    }

    protected abstract void DFSStep(Vertex<VertexType> vertex);
}
