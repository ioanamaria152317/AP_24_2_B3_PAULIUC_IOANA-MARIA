package org.example;

import lombok.Data;
import org.example.model.Book;
import org.example.repository.BookRepository;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.BrownBacktrackColoring;
import org.jgrapht.graph.DefaultEdge;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ReadingList {
    private String name;
    private Date creationTimestamp;
    private Set<Book> myListOfBooks=new HashSet<>();

    //pun intr un reading list doar carti care nu sunt related
    //o fct pt related -> carti care au acelasi gen sau autor


}
        /*System.setProperty("org.graphstream.ui", "javafx");

        Graph graph = new SingleGraph("BookGraph");
        graph.setStrict(false);
        graph.setAutoCreate( true );

        Node book1 = graph.addNode("Book1");
        Node book2 = graph.addNode("Book2");
        Node book3 = graph.addNode("Book3");

        graph.addEdge("Related1", book1, book2);
        graph.addEdge("Related2", book2, book3);

        graph.display();*/


//}

