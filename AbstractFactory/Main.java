
package spellcheck;

import java.io.IOException;
import java.util.SortedMap;


public class Main {

	public static void main(String[] args) {
	
		try {
			DocumentFactoryInterface document = new DocumentFactory();
			DictionaryFactoryInterface dictionary = new DictionaryFactory("dict.txt");
			ExtractorFactoryInterface extractor = new ExtractorFactory();

			SpellingChecker checker = new SpellingChecker(document, dictionary,extractor);
			SortedMap<String, Integer> mistakes = checker.check(args[0]);
			System.out.println(mistakes);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

