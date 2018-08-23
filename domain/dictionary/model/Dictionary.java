package vocabulator_app.domain.dictionary.model;

import vocabulator_app.domain.word.Word;

import java.util.Collection;


public interface Dictionary {
    Word getWordFor(String origin);
    Collection<Word> getWords();

}
