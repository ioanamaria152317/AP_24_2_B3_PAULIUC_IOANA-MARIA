package org.example;

import org.apache.poi.ss.usermodel.*;
import org.jgrapht.alg.clique.BronKerboschCliqueFinder;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //vreau perechea asta om-abilitate
        Map<Person, List<String>> abilitati = new HashMap<>();
        Repository repo = new Repository("C:/Users/ioana/OneDrive/Desktop/java/Homework5/test_repo");
        repo.loadDocuments();
        Map<Person, List<Document>> documents = repo.getDocuments();

        //deci persoanei careia i-am dat export
        //ii atasez abilitatile citite din excel
        //intr-o lista de string uri, nu mai fac clasa
        //abilitate

        //file input stream citeste fisiere drept niste
        //octeti

        //Desktop desktop = Desktop.getDesktop();
        // desktop.open(new File("C:/Users/ioana/OneDrive/Desktop/java/Homework5/abilitati.xlsx"));
        try (FileInputStream excelDeschide_te = new FileInputStream(new
                File("C:/Users/ioana/OneDrive/Desktop/java/Homework5/abilitati.xlsx"));
             Workbook workbook = WorkbookFactory.create(excelDeschide_te)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Person p : documents.keySet()) {
                for (Row row : sheet) {
                    // System.out.println("id:"+ p.id()+ "cell:"+ row.getRowNum());
                    if (p.id() == row.getRowNum()) {
                        List<String> abilitaati = new ArrayList<>();
                        for (Cell cell : row) {
                            if (cell.getColumnIndex() != 0 && cell.getColumnIndex() != 1) {
                                String abilitate = cell.getStringCellValue();
                                String[] abilSplit = abilitate.split(",");
                                for (String abilitatee : abilSplit) {
                                    abilitaati.add(abilitate.trim());
                                }
                            }
                        }
                        abilitati.put(p, abilitaati);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Map.Entry<Person, List<String>> entry : abilitati.entrySet()) {
            Person person = entry.getKey();
            List<String> abil = entry.getValue();
            System.out.println("Person: " + person.name() + " (ID: " + person.id() + ")");
            System.out.println("\tAbilitati: " + abil);
        }

        //nuj de ce le pune de doua ori, in fine

        //vreau sa iau cele mai mari grupuri care au abil in comun
        //clique: 4 noduri toate cu muchii intre ele
        //oricum as lua 4 oameni dintr-un grup, ei au o abilitate in comun
        //Bron–Kerbosch

        //muchie->abilitate

        SimpleGraph<Person, DefaultEdge> graph = createGraph(abilitati);

        BronKerboschCliqueFinder<Person, DefaultEdge> cliqueFinder = new BronKerboschCliqueFinder<>(graph);
        List<Set<Person>> maxCliques = new ArrayList<>();
        for (Set<Person> clique : cliqueFinder) {
            maxCliques.add(clique);
        }

        outputMaxGroups(maxCliques);
    }

    //map->>>graf
    public static SimpleGraph<Person, DefaultEdge> createGraph(Map<Person, List<String>> abilitati) {
        SimpleGraph<Person, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        for (Person person : abilitati.keySet()) {
            graph.addVertex(person);
        }
        for (Person person1 : abilitati.keySet()) {
            for (Person person2 : abilitati.keySet()) {
                if (!person1.equals(person2) && haveCommonAbility(abilitati.get(person1), abilitati.get(person2))) {
                    graph.addEdge(person1, person2);
                }
            }
        }
        return graph;
    }

    public static boolean haveCommonAbility(List<String> abilitati1, List<String> abilitati2) {
        for (String abilitate : abilitati1) {
            if (abilitati2.contains(abilitate)) {
                return true;
            }
        }
        return false;
    }

    public static void outputMaxGroups(List<Set<Person>> maxCliques) {
        for (Set<Person> clique : maxCliques) {
            System.out.println("Largest clique:");
            for (Person person : clique) {
                System.out.println(person);
            }
            System.out.println();
        }
    }
}

