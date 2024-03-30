package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company=new Company();
        MasterDirectory masterDirectory=new MasterDirectory();

        company.setMasterDirectory(masterDirectory);

        RepoDocuments repoDocuments=new RepoDocuments();
        RepoDocuments repoDocuments1=new RepoDocuments();

        Document doc1=new Document("employee/desktop/java");
        Document doc2= new Document("employee/desktop/haskell");
        Document doc3=new Document("employee/desktop/c++");

        List<Document> doc=new ArrayList<>();
        doc.add(doc1);
        doc.add(doc2);
        doc.add(doc3);

        List<RepoDocuments> repos=new ArrayList<>();
        repos.add(repoDocuments);
        repos.add(repoDocuments1);
        repoDocuments.setDocInRepo(doc);
        masterDirectory.setMasterDirectoryRepos(repos);
         //display the content of the repo

        System.out.println(repoDocuments);
    }
}