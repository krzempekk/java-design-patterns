package command;

public class Main {
    public static void copyAndPaste() {
        Application app = new Application();

        app.activeEditor.text = "Sample text";
        app.addEditor();

        System.out.println("Text in editors before commands execution:");
        app.showTextInEditors();

        CopyCommand copyCommand = new CopyCommand(app, app.activeEditor);
        app.executeCommand(copyCommand);

        System.out.println("Text in editors after copy command execution:");
        app.showTextInEditors();

        app.setActiveEditor(1);
        PasteCommand pasteCommand = new PasteCommand(app, app.activeEditor);
        app.executeCommand(pasteCommand);

        System.out.println("Text in editors after paste command execution:");
        app.showTextInEditors();
    }

    public static void cutAndUndo() {
        Application app = new Application();

        app.activeEditor.text = "Sample text";

        System.out.println("Text in editor before commands execution:");
        app.showTextInEditors();

        CutCommand cutCommand = new CutCommand(app, app.activeEditor);
        app.executeCommand(cutCommand);

        System.out.println("Text in editor after cut command execution:");
        app.showTextInEditors();

        UndoCommand undoCommand = new UndoCommand(app, app.activeEditor);
        app.executeCommand(undoCommand);

        System.out.println("Text in editor after undo command execution:");
        app.showTextInEditors();
    }

    public static void main(String[] args) {
        System.out.println("\nCopy and paste scenario");
        copyAndPaste();
        System.out.println("\nCut and undo scenario");
        cutAndUndo();
    }
}
