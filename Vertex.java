/**
 * Created by LJK on 29/08/15.
 */
public class Vertex<ValueType> {
    private ValueType value;

    public Vertex(ValueType value) {
        this.value = value;
    }
    public void setValue(ValueType value) {
        this.value = value;
    }
    public ValueType getValue() {
        return this.value;
    }
}
