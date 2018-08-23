package vocabulator_app.domain.dictionary.loader;

import vocabulator_app.domain.dictionary.model.Dictionary;

public interface DictionaryLoader {
    Dictionary load() throws Exception;
    void save() throws Exception;
}
