/**
 * Created by LJK on 29/08/15.
 */
public class Edge<ValueType> {
    private Vertex v1;
    private Vertex v2;
    private ValueType value;

    public Edge(ValueType value) {
        this.value = value;
    }

    public Edge(Vertex v1, Vertex v2) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException();
        }
        this.v1 = v1;
        this.v2 = v2;
    }

    public Edge(Vertex v1, Vertex v2, ValueType value) {
        if (v1 == null || v2 == null) {
            throw new NullPointerException();
        }
        this.v1 = v1;
        this.v2 = v2;
        this.value = value;
    }

    void setFirstVertex(Vertex vertex) {
        if (vertex == null) {
            throw new NullPointerException();
        }
        this.v1 = vertex;
    }

    void setSecondVertex(Vertex vertex) {
        if (vertex == null) {
            throw new NullPointerException();
        }
        this.v2 = vertex;
    }

    void setValue(ValueType value) {
        this.value = value;
    }

    Vertex getFirstVertex() {
        return this.v1;
    }

    Vertex getSecondVertex() {
        return this.v2;
    }

    ValueType getValue() {
        return this.value;
    }

    void reverseEdge() {
        Vertex temp = this.v1;
        this.v1 = this.v2;
        this.v2 = temp;
    }
}
