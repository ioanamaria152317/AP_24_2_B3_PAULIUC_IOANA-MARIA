package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RepoDocuments {

    private List<Document> docInRepo=new ArrayList<>();
}
