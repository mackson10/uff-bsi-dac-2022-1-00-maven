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
public class LanguageTerms {

    private final Map<String, String> terms;

    LanguageTerms() {
        this.terms = new HashMap();
    }

    LanguageTerms addTerm(String identifier, String translation) {
        this.terms.put(identifier, translation);
        return this;
    }

    String getTerm(String identifier) throws Error {
        String translation = this.terms.get(identifier);
        if(translation == null) throw new Error("Term not defined");
        else return translation;     
    }
}
