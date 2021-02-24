import java.util.ArrayList;
import java.util.List;

public class Maximizer<T extends Comparable<T>>{
    private T max;


    void updateValue(T value){
        if(max != null){
            if (max.compareTo(value) < 0){
                max = value;
            }
        }
        else{
            max = value;
        }
    }

    T getValue(){
        return max;
    }


}
