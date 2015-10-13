/**
 * Created by LJK on 07/09/15.
 */
public class PostOrderStrategy<VertexType, EdgeType> extends DFSStrategy<VertexType, EdgeType> {
    @Override
    protected void DFSStep(Vertex<VertexType> vertex) {
        this.graph.setVisited(vertex, true);

        for(Vertex<VertexType> neighbour : this.graph.getNeighbours(vertex)) {
            if (!this.graph.isVisited(neighbour)) {
                DFSStep(neighbour);
            }
        }
        this.order.add(vertex);
    }
}
