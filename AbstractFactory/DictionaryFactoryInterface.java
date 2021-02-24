package spellcheck;

import java.io.IOException;

public interface DictionaryFactoryInterface {
    DictionaryInterface makeDictionary() throws IOException;
}
