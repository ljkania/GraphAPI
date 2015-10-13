import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LJK on 08/09/15.
 */

public class Invoker {
    private Queue<Command> commands = new LinkedList<Command>();

    public void takeCommand(Command command) {
        this.commands.add(command);
    }

    public void executeCommands() throws Exception {
        while (!commands.isEmpty()) {
            Command command = commands.remove();
            command.execute();
        }
    }
}
