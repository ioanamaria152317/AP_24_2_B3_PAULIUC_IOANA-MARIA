package com.example.lab13offflastplang.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    private Locale currentLocale;
    private ResourceBundle messages;

    public SetLocale(ResourceBundle messages) {
        this.messages = messages;
    }

    public void execute(String languageTag) {
        currentLocale = Locale.forLanguageTag(languageTag);
        messages = ResourceBundle.getBundle("res/Messages", currentLocale);
        System.out.println(messages.getString("locale.set").replace("{0}", currentLocale.toString()));
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public ResourceBundle getMessages() {
        return messages;
    }
}
