package org.example;

import lombok.Data;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.BrownBacktrackColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CreateReadingLists {
    private Set<ReadingList> myReadingLists=new HashSet<>();

    private Graph<Book,DefaultEdge> graph=new SimpleGraph<>(DefaultEdge.class);
    private ReadingList readingList=new ReadingList();

    public void createGraph(BookRepository allBooks) {
        List <Book> books=allBooks.findAll();
        System.out.println(books.size());


        int ii =0;
        for (Book book : books) {
            graph.addVertex(book);
            ii++;
            if (ii<100) System.out.println(book);
        }

        for (int i = 0; i < books.size()-1; i++) {
           // Book book1 =
            // books.get(i);
            for (int j = i + 1; j < books.size(); j++) {
               // Book book2 = books.get(j);
                if (books.get(i).isRelated(books.get(j))) {
                    System.out.println("NUUUU");
                    graph.addEdge(books.get(i), books.get(j));
                } else {
                    readingList.getMyListOfBooks().add(books.get(i));
                    readingList.getMyListOfBooks().add(books.get(j));
                    System.out.println(i+""+j+" "+books.get(i) + "---->" + books.get(j));
                }
            }
        }
        myReadingLists.add(readingList);
        BrownBacktrackColoring coloring = new BrownBacktrackColoring(graph);
        System.out.println(coloring.getColoring());

    }

}

