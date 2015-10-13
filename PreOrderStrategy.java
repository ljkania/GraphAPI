/**
 * Created by LJK on 07/09/15.
 */
public class PreOrderStrategy<VertexType, EdgeType> extends DFSStrategy<VertexType, EdgeType> {
    @Override
    protected void DFSStep(Vertex<VertexType> vertex) {
        this.graph.setVisited(vertex, true);
        this.order.add(vertex);

        for(Vertex<VertexType> neighbour : this.graph.getNeighbours(vertex)) {
            if (!this.graph.isVisited(neighbour)) {
                DFSStep(neighbour);
            }
        }
    }
}
