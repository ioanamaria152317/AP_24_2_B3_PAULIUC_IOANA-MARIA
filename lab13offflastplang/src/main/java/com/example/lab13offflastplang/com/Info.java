package com.example.lab13offflastplang.com;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    private ResourceBundle messages;

    public Info(ResourceBundle messages) {
        this.messages = messages;
    }

    public void execute(Locale locale) {
        Currency currency = null;
        try{
            currency=Currency.getInstance(locale);
        }catch (IllegalArgumentException e) {
            currency=Currency.getInstance("EUR");
        }

        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        DateFormat dateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, locale);
        Date today = new Date();

        System.out.println(messages.getString("info").replace("{0}", locale.toString()));
        System.out.println("Country: " + locale.getDisplayCountry(locale) + " (" + locale.getDisplayCountry() + ")");
        System.out.println("Language: " + locale.getDisplayLanguage(locale) + " (" + locale.getDisplayLanguage() + ")");
        if (currency != null) {
            System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        } else {
            System.out.println("Currency: nu am");
        }
       // System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        System.out.println("Week Days: " + String.join(", ", symbols.getWeekdays()));
        System.out.println("Months: " + String.join(", ", symbols.getMonths()));
        System.out.println("Today: " + dateFormat.format(today));
    }

}
