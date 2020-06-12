package command;

abstract public class Command {
    protected Application app;
    protected Editor editor;
    protected String backup;

    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
        this.backup = editor.text;
    }

    public void undo() {
        editor.text = backup;
    }

    abstract public void execute();
}
