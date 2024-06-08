package com.example.lab13offflastplang.app;

import com.example.lab13offflastplang.com.DisplayLocales;
import com.example.lab13offflastplang.com.Info;
import com.example.lab13offflastplang.com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("res.messages", Locale.getDefault());
        SetLocale setLocale = new SetLocale(messages);
        DisplayLocales displayLocales = new DisplayLocales(messages);
        Info info = new Info(messages);

        while (true) {
            System.out.print(messages.getString("prompt"));
            String command = scanner.nextLine();

            switch (command) {
                case "locales":
                    displayLocales.execute();
                    break;
                case "set":
                    System.out.print("Enter locale (e.g., en_US, ro_RO): ");
                    String localeStr = scanner.nextLine();
                    setLocale.execute(localeStr);
                    messages = setLocale.getMessages();
                    displayLocales = new DisplayLocales(messages);
                    info = new Info(messages);
                    break;
                case "info":
                    Locale currentLocale = setLocale.getCurrentLocale() != null ? setLocale.getCurrentLocale() : Locale.getDefault();
                    info.execute(currentLocale);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println(messages.getString("invalid"));
            }
        }
    }
}
