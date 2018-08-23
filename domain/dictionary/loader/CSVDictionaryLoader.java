package vocabulator_app.domain.dictionary.loader;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.Files;
import vocabulator_app.domain.dictionary.model.GameDictionary;
import vocabulator_app.domain.dictionary.model.Dictionary;
import vocabulator_app.domain.word.GameWord;
import vocabulator_app.domain.word.Word;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CSVDictionaryLoader implements DictionaryLoader {
    public static void main(String[] args) throws Exception {
        File srcFile = new File("C:\\Users\\Start\\Desktop\\slowka.csv");
        DictionaryLoader service = new CSVDictionaryLoader(srcFile);
        Dictionary dictionary = service.load();
        System.out.println(dictionary);
        service.save();
    }

    private Dictionary dictionary;
    private File file;

    public CSVDictionaryLoader(File file) throws IOException {
        this.file = file;
    }

    @Override
    public Dictionary load() throws IOException {
        Set<Word> words = new HashSet<>();
        List<String> lines = Files.readLines(file, Charsets.UTF_8);
        for (String line : lines) {
            Scanner scanner = new Scanner(line); // skaner do skanowania linii "name,nazwa,nazwisko"
            scanner.useDelimiter(","); // ustawiam, żeby następne elementy zwracał po przecinku
//            System.out.println(line);
            String origin = scanner.next(); // pobieram pierwszy element "name"
            String translation = scanner.next(); // pobieram drugi element "nazwa"
            Set<String> translations = new HashSet<>(); // tworze zmienną pod zbiór tłumaczeń
            translations.add(translation); // wstawiam tam pierwsze tłumaczenie translation -> [nazwa]
            Word word = new GameWord(origin, translations); // wykorzystuję konstruktor (String origin, Set<String> translations)
            // żeby stworzyć obiekt GameWorld
            // todo dopisz obsługę wczytywania kilku translacji
            // todo dopisz obsługę pliku ze scoreami, czyli w formacie "name,nazwa,nazwisko,4"

            words.add(word);// dodaję słówko wyekstrahowane z lini tekstu do zbioru słówek
        }
        dictionary = new GameDictionary(words);
        return dictionary;
    }

    @Override
    public void save() throws IOException {
        CharSink charSink = Files.asCharSink(file, Charsets.UTF_8);
        //"name,nazwa,nazwisko,0"
        //"dog,pies,5"
        List<String> destinationLines = new ArrayList<>();
        for (Word word : dictionary.getWords()) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.origin())
                    .append(",");
            for (String translation : word.translations()) {
                sb.append(translation)
                        .append(",");
            }

            sb.append(word.score());
            destinationLines.add(sb.toString());
        }
        charSink.writeLines(destinationLines);
    }

}
