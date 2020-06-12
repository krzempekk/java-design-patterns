package command;

public class Editor {
    public String text = "";

    public String getSelection() {
        return text;
    }

    public void deleteSelection() { this.text = ""; }

    public void replaceSelection(String text) { this.text = text; }
}
