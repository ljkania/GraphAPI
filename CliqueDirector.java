import java.util.List;

/**
 * Created by LJK on 07/09/15.
 */
public class CliqueDirector<VertexType, EdgeType> {
    private CliqueBuilder<VertexType, EdgeType> cliqueBuilder;

    public void setCliqueBuilder(CliqueBuilder<VertexType, EdgeType> cliqueBuilder) {
        if (cliqueBuilder == null) {
            throw new NullPointerException();
        }
        this.cliqueBuilder = cliqueBuilder;
    }

    public Graph<VertexType, EdgeType> getClique() {
        return cliqueBuilder.getClique();
    }

    public void constructClique(List<VertexType> verticesValues) throws Exception {
        if (verticesValues == null) {
            throw new NullPointerException();
        }
        cliqueBuilder.createNewCliqueProduct();
        cliqueBuilder.buildVertices(verticesValues);
        cliqueBuilder.buildEdges();
    }
}
