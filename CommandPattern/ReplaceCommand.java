public class ReplaceCommand implements CommandInterface{
    private IDocument document;
    private int index;
    private int distance;
    private String newString;
    private String replacedText;

    public ReplaceCommand(IDocument document, int index, int distance, String newString) {
        this.document = document;
        this.index = index;
        this.distance = distance;
        this.newString = newString;
    }

    @Override
    public void execute() {
        replacedText = document.delete(index, distance);
        if (replacedText == null) {
            System.out.println("Replace unsuccessful");
        }
        else {
            document.insert(index, newString);
        }
    }

    @Override
    public void undo() {
        String result = document.delete(index, newString.length());
        if (result == null) {
            System.out.println("Replace undo unsuccessful");
        }
        else {
            document.insert(index, replacedText);
        }
    }

    @Override
    public void redo() {
        replacedText = document.delete(index, distance);
        if (replacedText == null) {
            System.out.println("Replace redo unsuccessful");
        }
        else {
            document.insert(index, newString);
        }
    }
}
