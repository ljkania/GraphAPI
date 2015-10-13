/**
 * Created by LJK on 08/09/15.
 */
public class EmptyGraphState implements State {
    @Override
    public void perform(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        context.setState(this);
    }

    public String toString(){
        return "Graph is empty.";
    }
}
