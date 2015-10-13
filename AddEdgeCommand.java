/**
 * Created by LJK on 08/09/15.
 */
public class AddEdgeCommand<VertexType, EdgeType> implements Command {
    private Graph<VertexType, EdgeType> graph;
    private Vertex<VertexType> v1;
    private Vertex<VertexType> v2;
    private EdgeType value;

    public AddEdgeCommand(
            Graph<VertexType, EdgeType> graph, Vertex<VertexType> v1, Vertex<VertexType> v2, EdgeType value) {
        if (graph == null || v1 == null || v2 == null) {
            throw new NullPointerException();
        }
        this.graph = graph;
        this.v1 = v1;
        this.v2 = v2;
        this.value = value;
    }

    @Override
    public void execute() throws Exception { this.graph.addEdge(this.v1, this.v2, this.value); }
}
