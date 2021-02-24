
package spellcheck;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
//			DocumentInterface documentInterface = new URLFetcher();
//			DictionaryInterface dictionary = new Dictionary("dict.txt");
//			ExtractorInterface extractor = new WordExtractor();

			Injector injector = Guice.createInjector(
					new InjectionModule()
			);
			SpellingChecker checker = injector.getInstance(SpellingChecker.class);
			//SpellingChecker checker = new SpellingChecker(documentInterface, dictionary,extractor);
			SortedMap<String, Integer> mistakes = checker.check(args[0]);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

