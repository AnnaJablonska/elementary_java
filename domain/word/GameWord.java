package vocabulator_app.domain.word;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class GameWord implements Word {
    private String origin;
    private Set<String> translations;
    private int score;

    /*
    stwórz 2 konstruktory (origin,translations) i (origin,translations,score)
    zaimplementuj metody wygenerowane poniżej (te z adnotacją @Override)
    przesłoń metody toString(), equals() i hashCode()
     */

    public GameWord(String origin, Set<String> translations) {
        this.origin = origin;
        this.translations = translations;
    }

    public GameWord(String origin, Set<String> translations, int score) {
        this.origin = origin;
        this.translations = translations;
        this.score = score;
    }


    @Override
    public int score() {
        return score;
    }

    @Override
    public void incrementScore(int delta) {
        score += delta;
    }

    @Override
    public String origin() {
        return origin;
    }

    @Override
    public Collection<String> translations() {
        return translations;
    }

    @Override
    public boolean checkTranslation(String translation) {
        //todo ulepsz implementacje, tak żeby przyjmowała również
        // słowa pisane z małej i wielkiej litery
        return translations.contains(translation);
    }

    @Override
    public void addTranslation(String translation) {
        translations.add(translation);
    }

    @Override
    public String toString() {
        return "GameWord{" +
                "origin='" + origin + '\'' +
                ", translations=" + translations +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameWord gameWord = (GameWord) o;
        return Objects.equals(origin, gameWord.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin);
    }
}
