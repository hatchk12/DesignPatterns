public class InsertCommand implements CommandInterface{
    private IDocument document;
    private int index;
    private String sequence;

    public InsertCommand(IDocument document, int index, String sequence) {
        this.document = document;
        this.index = index;
        this.sequence = sequence;
    }

    @Override
    public void execute() {
        document.insert(index, sequence);
    }

    @Override
    public void undo() {
        document.delete(index,sequence.length());
    }

    @Override
    public void redo() {
        document.insert(index, sequence);
    }
}
