package org.example;

import freemarker.template.TemplateException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        Main app = new Main();
        app.testRepo();
    }

    private void testRepo() throws IOException, TemplateException {
        var service = new RepositoryService();

        String commandLine;
        BufferedReader console = new BufferedReader
                (new InputStreamReader(System.in));

        while (true) {
            System.out.print("shell>");
            commandLine = console.readLine();

            if (commandLine.isEmpty())
                continue;

            String[] split = commandLine.split(" ");
            String command = split[0];
            String[] arguments = new String[split.length - 1];
            System.arraycopy(split, 1, arguments, 0, arguments.length);

            if (command.equals("view")) {
                if(arguments.length == 1)
                    service.view(arguments[0]);
            }

            if (command.equals("report")) {
                if(arguments.length == 2)
                    service.report(new Repository(arguments[0]), arguments[1]);
            }

            if (command.equals("export")) {
                if(arguments.length == 2)
                    service.export(new Repository(arguments[0]), arguments[1]);
            }

            if (commandLine.equals("exit")) {
                System.out.println("Terminating virtual shell");
                System.exit(0);
            }
        }

//        service.print(repo);
//        service.export(repo, "target/test_repo.json");
//        service.view("target/test_repo.json");
//        var doc = repo.findDocument("...");
//        service.view(doc);
    }
}
