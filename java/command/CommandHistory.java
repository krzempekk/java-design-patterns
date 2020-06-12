package command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<Command> history;

    public CommandHistory() {
        this.history = new ArrayList<>();
    }

    public void push(Command c) {
        this.history.add(c);
    }

    public Command pop() {
        return this.history.get(this.history.size() - 1);
    }

    public boolean isEmpty() { return this.history.isEmpty(); }
}
