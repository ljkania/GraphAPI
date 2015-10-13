import java.util.List;

/**
 * Created by LJK on 05/09/15.
 */
public class Tree<VertexType, EdgeType> {
    private Graph<VertexType, EdgeType> graph;

    public Tree() {
        this.graph = new MultiGraph<VertexType, EdgeType>(new UndirectedGraph());
    }

    public Tree(Tree<VertexType, EdgeType> tree) {
        if (tree == null) {
            throw new NullPointerException();
        }
        this.graph = new MultiGraph<VertexType, EdgeType>(tree.getGraph());
    }

    public Graph<VertexType, EdgeType> getGraph() {
        return this.graph;
    }

    public List<Edge<EdgeType>> getEdges() {
        return this.graph.getEdges();
    }

    public List<Vertex<VertexType>> getVertices() {
        return this.graph.getVertices();
    }

    public int countEdges() {
        return this.graph.countEdges();
    }

    public int countVertices() {
        return this.graph.countVertices();
    }

    public Tree<VertexType, EdgeType> addVertex(VertexType value) throws Exception {
        if (this.countVertices() > 0) {
            throw new Exception("Tree must be consistent. Use addEdgeWithLeaf instead.");
        }

        Tree<VertexType, EdgeType> tree = new Tree<VertexType, EdgeType>(this);
        tree.graph.addVertex(value);
        return tree;
    }

    public Tree<VertexType, EdgeType> addEdgeWithLeaf(Vertex<VertexType> parent, VertexType leafValue, EdgeType value)
            throws Exception {
        if (parent == null) {
            throw new NullPointerException();
        } else if (!this.graph.getVertices().contains(parent)) {
            throw new Exception("Parent vertex is not present in this graph.");
        }

        Tree<VertexType, EdgeType> tree = new Tree<VertexType, EdgeType>(this);
        Vertex vertex = tree.graph.addVertex(leafValue);
        tree.graph.addEdge(parent, vertex, value);
        return tree;
    }

    public Tree<VertexType, EdgeType> removeLeaf(Vertex<VertexType> leaf) throws Exception {
        if (!this.graph.getVertices().contains(leaf) || this.graph.getNeighbours(leaf).size() > 1) {
            throw new Exception("Provided vertex is not a leaf.");
        }
        Tree<VertexType, EdgeType> tree = new Tree<VertexType, EdgeType>(this);
        tree.graph.removeVertex(leaf);
        return tree;
    }

    public Tree<VertexType, EdgeType> clear() {
        Tree<VertexType, EdgeType> tree = new Tree<VertexType, EdgeType>(this);
        tree.graph.clear();
        return tree;
    }
}
