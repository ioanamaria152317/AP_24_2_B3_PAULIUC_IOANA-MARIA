package org.example;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Template;

import javax.swing.text.View;
import java.io.*;
import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.Map;

public class RepositoryService {
    public void export(Repository repo, String path)
            throws IOException {
        ExportCommand expCmd = new ExportCommand(repo, path);
        expCmd.execute();
        //imi ia din pc doc si face clase mapeaza se joaca
    }

    public void report(Repository repository, String outputPath) throws IOException, TemplateException {
        ReportCommand repCmd = new ReportCommand(repository, outputPath);
        repCmd.execute();
        view(outputPath);
    }
    public void view(String path) throws IOException {
        ViewCommand viewCmd = new ViewCommand(path);
        viewCmd.execute();
    }

}