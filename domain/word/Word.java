package vocabulator_app.domain.word;

import java.util.Collection;
import java.util.List;

public interface Word extends Scorable{
    String origin(); // zwraca oryginał słowa, np. dog
    Collection<String> translations(); // zwraca tłumaczenia słowa
    boolean checkTranslation(String translation);
    void addTranslation(String translation);
}
