/**
 * Created by LJK on 08/09/15.
 */
public class AddVertexCommand<VertexType, EdgeType> implements Command {
    private Graph<VertexType, EdgeType> graph;
    private VertexType value;

    public AddVertexCommand(Graph<VertexType, EdgeType> graph, VertexType value) {
        if (graph == null) {
            throw new NullPointerException();
        }
        this.graph = graph;
        this.value = value;
    }

    @Override
    public void execute() throws Exception {
        this.graph.addVertex(this.value);
    }
}
