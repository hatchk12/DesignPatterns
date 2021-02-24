import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NounStringSource implements StringSource{

    List<String> nouns = new ArrayList<>();

    public NounStringSource() {
        nouns.add("Computer Science");
        nouns.add("Katy");
        nouns.add("Ice cream");
    }

    @Override
    public String next() {
        Random rand = new Random();

        return nouns.get(rand.nextInt(3));
    }
}
