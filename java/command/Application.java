package command;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public List<Editor> editors;
    public Editor activeEditor;
    public String clipboard;
    public CommandHistory commandHistory;

    public Application() {
        this.activeEditor = new Editor();
        this.editors = new ArrayList<>();
        this.editors.add(this.activeEditor);
        this.clipboard = null;
        this.commandHistory = new CommandHistory();
    }

    public void addEditor() {
        this.editors.add(new Editor());
    }

    public void setActiveEditor(int index) {
        this.activeEditor = this.editors.get(index);
    }

    public void executeCommand(Command c) {
        c.execute();
        this.commandHistory.push(c);
    }

    public void undo() {
        if(!this.commandHistory.isEmpty()) {
            Command c = this.commandHistory.pop();
            c.undo();
        }
    }

    public void showTextInEditors() {
        for(Editor editor: this.editors) {
            System.out.println("\t" + (editor.text.isEmpty() ? "(empty)" : editor.text));
        }
    }
}
