package vocabulator_app.domain.dictionary.model;

import vocabulator_app.domain.word.GameWord;
import vocabulator_app.domain.word.Word;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GameDictionary implements Dictionary{
    private Set<Word> words;

    /*
    1. Konstruktor jednoparametrowy
    2. Implementacja metod
    3. toString();
     */

    public GameDictionary(Collection<Word> words){
        this.words = new HashSet<>(words);
    }

    @Override
    public Word getWordFor(String origin) {
        for(Word word: words){
            if(word.origin().equalsIgnoreCase(origin)){
                return word;
            }
        }
        return null;
    }

    @Override
    public Collection<Word> getWords() {
        Set<Word> words = new HashSet<>(this.words);
        return words;
    }

    @Override
    public String toString() {
        return "GameDictionary{" +
                "words=" + words +
                '}';
    }


}
