import java.util.List;

/**
 * Created by LJK on 07/09/15.
 */
public abstract class CliqueBuilder<VertexType, EdgeType> {
    protected Graph<VertexType, EdgeType> graph;

    public Graph<VertexType, EdgeType> getClique() {
        return graph;
    }

    public abstract void createNewCliqueProduct();
    public abstract void buildVertices(List<VertexType> verticesValues);
    public abstract void buildEdges() throws Exception;
}
