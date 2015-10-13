import java.util.List;

/**
 * Created by LJK on 07/09/15.
 */
public class UndirectedCliqueBuilder<VertexType, EdgeType> extends CliqueBuilder<VertexType, EdgeType> {

    @Override
    public void createNewCliqueProduct() { this.graph = new MultiGraph<VertexType, EdgeType>(new UndirectedGraph()); }

    @Override
    public void buildVertices(List<VertexType> verticesValues) {
        for (VertexType value : verticesValues) {
            this.graph.addVertex(value);
        }
    }

    @Override
    public void buildEdges() throws Exception {
        List<Vertex<VertexType>> vertices = this.graph.getVertices();

        for (int i=0; i<vertices.size(); i++) {
            for (int j=i+1; j<vertices.size(); j++) {
                this.graph.addEdge(vertices.get(i), vertices.get(j), null);
            }
        }
    }
}
