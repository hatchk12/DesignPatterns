public class OpenCommand implements CommandInterface{
    private IDocument document;
    private String openFileName;
    private String previousSequence;

    public OpenCommand(IDocument document, String openFileName) {
        this.document = document;
        this.openFileName = openFileName;
    }

    @Override
    public void execute() {
        previousSequence = document.sequence().toString();
        document.open(openFileName);
    }

    @Override
    public void undo() {
        document.clear();
        document.insert(0,previousSequence);
    }

    @Override
    public void redo() {
        document.open(openFileName);
    }
}
