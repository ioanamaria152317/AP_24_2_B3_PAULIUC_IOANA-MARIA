package com.example.lab13offflastplang.com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    private ResourceBundle messages;

    public DisplayLocales(ResourceBundle messages) {
        this.messages = messages;
    }

    public void execute() {
        Locale[] locales = Locale.getAvailableLocales();
        System.out.println(messages.getString("locales"));
        for (Locale locale : locales) {
            System.out.println(locale.toString());
        }
    }
}
