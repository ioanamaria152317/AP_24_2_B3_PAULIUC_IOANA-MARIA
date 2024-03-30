package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MasterDirectory {

    private List<RepoDocuments> masterDirectoryRepos=new ArrayList<>();
}
