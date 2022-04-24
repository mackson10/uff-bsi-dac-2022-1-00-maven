/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mac
 */
public class Dictionary {
    
    private final Map<String, LanguageTerms> languages;

    public Dictionary() {
        this.languages = new HashMap();
    }
    
    LanguageTerms addLanguage(String languageIdentifier) {
        LanguageTerms languageTerms = new LanguageTerms();
        this.languages.put(languageIdentifier, languageTerms);
        return languageTerms;
    }

    LanguageTerms getLanguage(String languageIdentifier) throws Error {
        LanguageTerms terms = this.languages.get(languageIdentifier);
        if(terms == null) {
            throw new Error("Language not defined " + languageIdentifier );
        } else {
            return terms;
        }
    }
}
