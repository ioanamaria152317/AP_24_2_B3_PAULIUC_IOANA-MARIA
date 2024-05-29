package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;   //open csv api
import com.opencsv.CSVReaderBuilder;
import lombok.Data;
import org.example.model.Author;
import org.example.model.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
@Data
public class BookService {
    //vreau sa citesc din fisier si sa parsez
    private static BookRepository repo=new BookRepository();
    private static AuthorRepository repoAuthor=new AuthorRepository();
        public static void main(String[] args)
        {
            BookService bookService=new BookService();
            try
                    (Reader reader = new FileReader("C:\\Users\\ioana\\Downloads\\archive\\books.csv")) {
                CSVParser parser = new CSVParserBuilder()
                        .withSeparator(',')
                        .withIgnoreQuotations(true)
                        .build();
                CSVReader csvReader = new CSVReaderBuilder(reader)
                        .withSkipLines(0)
                        .withCSVParser(parser)
                        .build();

                String[] line;  //sir de celule(string uri) ->linia
                int lines=0;

                while ((line=csvReader.readNext())!=null){
                    if(lines>0) {
                        Book book = new Book();
                        int columnIndex=0;
                        for (String cell : line) {
                            columnIndex++;
                            if (columnIndex == 2) {
                                book.setTitle(cell);
                            }
                            if (columnIndex == 8) {
                                if (cell.matches("\\d+")) {
                                    int numberOfPages = Integer.parseInt(cell);
                                    book.setNumberOfPages(numberOfPages);
                                }
                            }
                            if (columnIndex == 11) {
                                try {
                                    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                                    java.util.Date utilDate = sdf.parse(cell);
                                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                                    book.setPublicationDate(sqlDate);
                                } catch (ParseException e) {
                                    System.out.println("Nu pot sa te convertesccc: " + e.getMessage());
                                }
                            }
                            if (columnIndex==3){
                                //autorii sunt delimitati de "/"
                                String[] autori=cell.split("/");
                                List<Author> authors=new ArrayList<>();
                              for (String numeAutor:autori) {
                                  Author author = new Author();
                                  author.setName(numeAutor);
                                  repoAuthor.create(author);
                                  authors.add(author);
                              }
                              book.setAuthors(authors);
                            }

                            System.out.println(cell + "\t");
                        }
                        repo.create(book);
                        System.out.println();
                    }
                    lines++;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            CreateReadingLists createReadingLists=new CreateReadingLists();
            createReadingLists.createGraph(repo);

            System.out.println(createReadingLists.getMyReadingLists());
        }
    }
