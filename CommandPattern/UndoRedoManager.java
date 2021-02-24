import java.util.ArrayList;
import java.util.List;

public class UndoRedoManager {
    List<CommandInterface> list;
    int index;

    public UndoRedoManager() {
        list = new ArrayList<>();
        index =0;
    }

    public void execute(CommandInterface command){
        list = list.subList(0,index);
        list.add(command);
        index ++;
        command.execute();
    }

    public void undo(){
        if(canUndo()) {
            index--;
            list.get(index).undo();

        }
    }

    public void redo(){
        if(canRedo()){
            list.get(index).redo();
            index++;
        }
    }

    public boolean canUndo(){
        if(index >0){
            return true;
        }
        return false;
    }

    public boolean canRedo(){
        if(index <= list.size()-1){
            return true;
        }
        return false;
    }

}
