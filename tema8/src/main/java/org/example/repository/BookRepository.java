package org.example.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.DatabaseUtils;
import org.example.model.Author;
import org.example.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BookRepository {
    //inserez carte ---create

    public void create(Book book) throws SQLException {
        try (Connection connection = DatabaseUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "insert into book (title,numberOfPages,publicationDate,authors) values (?,?,?,?)")) {
           // statement.setInt(1,book.getId());
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getNumberOfPages());
            statement.setDate(3, book.getPublicationDate());
            List<String> authorNames=new ArrayList<>();
            for (Author author : book.getAuthors()){
                authorNames.add(author.getName());
            }
            String nameString=String.join("/",authorNames);
            statement.setString(4,nameString);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Insert successfully!");
            } else {
                System.out.println("Insert failed!");
            }
//            statement.close();
//            connection.close();
        }
    }

    public static List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book.book");

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Integer numberOfPages = resultSet.getInt("numberofpages");
                Date publicationDate = resultSet.getDate("publicationdate");
                Integer idAuthor=resultSet.getInt("id_author");
                Integer idGenre=resultSet.getInt("id_genre");
                String authors=resultSet.getString("authors");
                String[] autori=authors.split("/");
                List<Author> authorList=new ArrayList<>();
                for (String numeAutor:autori){
                    Author author=new Author();
                    author.setName(numeAutor);
                    authorList.add(author);
                }

                Book book = new Book(id, title,authorList, numberOfPages, publicationDate);
                books.add(book);
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public static Book findById(Integer id) {
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book.book WHERE id = " + id);

            if(resultSet.next()) {
                Integer _id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Integer numberOfPages = resultSet.getInt("numberofpages");
                Date publicationDate = resultSet.getDate("publicationdate");
                Integer idAuthor=resultSet.getInt("id_author");
                Integer idGenre=resultSet.getInt("id_genre");
                String authors=resultSet.getString("authors");
                String[] autori=authors.split("/");
                List<Author> authorList=new ArrayList<>();
                for (String numeAutor:autori){
                    Author author=new Author();
                    author.setName(numeAutor);
                    authorList.add(author);
                }
                return new Book(_id, title,authorList, numberOfPages, publicationDate);
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void naiveUpdate(Book book) {
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate("UPDATE book.book SET "
                    + "title = '" +book.getTitle() + "', "
                    + "numberofpages = '" + book.getNumberOfPages() + "', "
                    + "publicationdate = " + book.getPublicationDate() + " "
                    + "WHERE id = " + book.getId()
            );

            if (affectedRows > 0) {
                System.out.println("Update successfully!");
            } else {
                System.out.println("Update failed!");
            }

//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
