package command;

public class PasteCommand extends Command {
    public PasteCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        if(this.app.clipboard == null) return;

        this.editor.replaceSelection(this.app.clipboard);
    }
}
