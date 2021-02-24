package spellcheck;

import java.io.IOException;

public interface DocumentInterface {
    String fetch(String source) throws IOException;
}
