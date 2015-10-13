/**
 * Created by LJK on 08/09/15.
 */
public class Context {
    private State state;

    public Context(State state) {
        setState(state);
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }
}
