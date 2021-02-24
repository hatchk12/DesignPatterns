public class DeleteCommand implements CommandInterface{
    private IDocument document;
    private int index;
    private int distance;
    private String deletedText;

    public DeleteCommand(IDocument document, int index, int distance) {
        this.document = document;
        this.index = index;
        this.distance = distance;
    }

    @Override
    public void execute() {
        deletedText = document.delete(index, distance);
        if (deletedText == null) {
            System.out.println("Deletion unsuccessful");
        }
    }

    @Override
    public void undo() {
        document.insert(index,deletedText);
    }

    @Override
    public void redo() {
        document.delete(index, distance);
    }
}
