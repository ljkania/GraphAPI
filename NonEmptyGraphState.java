/**
 * Created by LJK on 08/09/15.
 */
public class NonEmptyGraphState implements State {
    @Override
    public void perform(Context context) {
        context.setState(this);
    }

    public String toString(){
        return "Graph is not empty.";
    }
}
