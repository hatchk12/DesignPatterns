package spellcheck;

import java.io.IOException;

public class DictionaryFactory implements DictionaryFactoryInterface{
    String fileName;
    DictionaryFactory(String fileName){
        this.fileName = fileName;
    }
    public DictionaryInterface makeDictionary() throws IOException {
        return new Dictionary(fileName);
    }


}
