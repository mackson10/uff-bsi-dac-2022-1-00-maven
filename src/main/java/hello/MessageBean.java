package hello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author viter
 */
public class MessageBean implements Serializable {
     
    private String lang;    
    private String name;
    private String pronoum;
    private String formtype;
    
    private Dictionary dictionary;
    
    public MessageBean() {
        dictionary = new Dictionary();

        dictionary.addLanguage("pt")
            .addTerm("greeting", "Alô")
            .addTerm("good_morning", "Bom dia")
            .addTerm("good_afternoon", "Boa tarde")            
            .addTerm("good_evening", "Boa tarde")
            .addTerm("good_night", "Boa noite")
            .addTerm("mr.", "Senhor")
            .addTerm("mrs.", "Senhora")
            .addTerm("good_bye", "Adeus")
        ;

        dictionary.addLanguage("en")
            .addTerm("greeting", "Hello")
            .addTerm("good_morning", "Good morning")
            .addTerm("good_afternoon", "Good afternoon")            
            .addTerm("good_evening", "Good evening")
            .addTerm("good_night", "Good night")
            .addTerm("mr.", "Mr.")
            .addTerm("mrs.", "Mrs.")
            .addTerm("good_bye", "Good bye")
        ;

        dictionary.addLanguage("de")
            .addTerm("greeting", "Hallo")
            .addTerm("good_morning", "Guten morgen")
            .addTerm("good_afternoon", "Guten nachmittag")            
            .addTerm("good_evening", "Guten abend")
            .addTerm("good_night", "Gute nacht")
            .addTerm("mr.", "Herr.")
            .addTerm("mrs.", "Herrin.")
            .addTerm("good_bye", "Auf Wiedersehen")
        ;

        dictionary.addLanguage("fr")
            .addTerm("greeting", "Bonjour")
            .addTerm("good_morning", "Bonjour")
            .addTerm("good_afternoon", "Bon après-midi")            
            .addTerm("good_evening", "Bonsoir")
            .addTerm("good_night", "Bonne nuit")
            .addTerm("mr.", "M.")
            .addTerm("mrs.", "Mme.")
            .addTerm("good_bye", "Au revoir")
        ;
        
        dictionary.addLanguage("ru")
            .addTerm("greeting", "Привет")
            .addTerm("good_morning", "Доброе утро")
            .addTerm("good_afternoon", "Добрый день")            
            .addTerm("good_evening", "Добрый вечер")
            .addTerm("good_night", "Спокойной ночи")
            .addTerm("mr.", "Мистер.")
            .addTerm("mrs.", "Г-жа.")
            .addTerm("good_bye", "До свидания")
        ;

        dictionary.addLanguage("ua")
            .addTerm("greeting", "Привіт")
            .addTerm("good_morning", "Добрий ранок")
            .addTerm("good_afternoon", "Добрий день")            
            .addTerm("good_evening", "Добрий вечір")
            .addTerm("good_night", "Надобраніч")
            .addTerm("mr.", "Містер.")
            .addTerm("mrs.", "Пані.")
            .addTerm("good_bye", "До побачення")
        ;
    }
    
    public void setLang(String lang) { this.lang = lang; }
    public void setName(String name) { this.name = name; }
    public void setPronoum(String pronoum) { this.pronoum = pronoum; }
    public void setFormtype(String formtype) { this.formtype = formtype; }
    
    
    public String getMsg() {
        LanguageTerms terms = dictionary.getLanguage(this.lang); 
        if(this.formtype.equals("hello")) {
            return this.getTimeGreeting(this.lang) + ", " + (this.pronoum.equals("none") ? "" : terms.getTerm(this.pronoum) + " ") + this.name;
        } else {
            return terms.getTerm("good_bye") + ", " + (this.pronoum.equals("none") ? "" : terms.getTerm(this.pronoum) + " ") + this.name;
        }
    }    
    
    public String getTimeGreeting(String lang) {
        int hourOfNow = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hourOfNow >= 0 && hourOfNow < 12) {
            return dictionary.getLanguage(lang).getTerm("good_morning");
        } else if (hourOfNow >= 12 && hourOfNow < 18) {
            return dictionary.getLanguage(lang).getTerm("good_afternoon");
        } else {
            return dictionary.getLanguage(lang).getTerm("good_night");
        }
    }
}
