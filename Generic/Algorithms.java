public class Algorithms {

    public static <T extends Comparable<T>> Stats<T> calcStats(T[] array){
        Stats<T> stats = new Stats<>();
        T min = array[0];
        T max = min;
        for(int i = 0; i < array.length;i++){
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
            if(min.compareTo(array[i]) > 0){
                min = array[i];
            }
        }
        stats.min = min;
        stats.max = max;
        return stats;
    }
}
