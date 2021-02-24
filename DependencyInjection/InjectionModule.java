package spellcheck;

import com.google.inject.*;

import javax.inject.Qualifier;
import java.io.IOException;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class InjectionModule extends AbstractModule {

//    @Qualifier
//    @Retention(RUNTIME)
//    @interface Dictionary {}
//
//    @Qualifier
//    @Retention(RUNTIME)
//    @interface Document {}
//
//    @Qualifier
//    @Retention(RUNTIME)
//    @interface Extractor {}

    @Provides
    //@Dictionary
    public DictionaryInterface providesDict() throws IOException {
         return new spellcheck.Dictionary("dict.txt");
    }

    @Provides
    //@Extractor
    public ExtractorInterface providesExtractor(){
        return new spellcheck.WordExtractor( );
    }

    @Provides
    //@Document
    public DocumentInterface providesDocument(){
        return new spellcheck.URLFetcher( );
    }

}
