
package spellcheck;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class SpellingChecker {

    DocumentInterface document;
    DictionaryInterface dictionary;
    ExtractorInterface extractor;

    @Inject
    SpellingChecker(DocumentInterface doc, DictionaryInterface dict, ExtractorInterface extractor){
        this.document = doc;
        this.dictionary = dict;
        this.extractor = extractor;
    }

	public SortedMap<String, Integer> check(String filePath) throws IOException {


		// download the document content
		//

		String content = document.fetch(filePath);

		// extract words from the content
		//
		List<String> words = extractor.extract(content);

		// find spelling mistakes
		//
		SortedMap<String, Integer> mistakes = new TreeMap<>();

        for (String word : words) {
            if (!dictionary.isValidWord(word)) {
                if (mistakes.containsKey(word)) {
                    int oldCount = mistakes.get(word);
                    mistakes.put(word, oldCount + 1);
                } else {
                    mistakes.put(word, 1);
                }
            }
        }

		return mistakes;
	}
}

