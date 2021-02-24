package spellcheck;

public class ExtractorFactory implements ExtractorFactoryInterface{
    public ExtractorInterface makeExtractor(){
        return new WordExtractor();
    }
}
