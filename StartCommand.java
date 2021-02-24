public class StartCommand implements CommandInterface{
    private IDocument document;
    private String previousSequence;

    public StartCommand(IDocument document) {
        this.document = document;
    }

    @Override
    public void execute() {
        previousSequence = document.sequence().toString();
        document.clear();
    }

    @Override
    public void undo() {
        document.insert(0,previousSequence);
    }

    @Override
    public void redo() {
        document.clear();
    }
}
