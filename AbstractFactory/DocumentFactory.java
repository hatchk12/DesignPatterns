package spellcheck;

import java.io.IOException;

public class DocumentFactory implements DocumentFactoryInterface{
    public DocumentInterface makeDocument(){
        return new URLFetcher();
    }
}
