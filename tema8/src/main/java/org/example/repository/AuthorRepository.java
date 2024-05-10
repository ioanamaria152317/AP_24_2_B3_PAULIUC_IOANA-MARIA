package org.example.repository;

import org.example.DatabaseUtils;
import org.example.model.Author;
import org.example.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    //creez un autor in tabela author

    public void create(Author author) throws SQLException {
        try (Connection connection = DatabaseUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "insert into author (name) values (?)")) {
            statement.setString(1, author.getName());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Insert successfully!");
            } else {
                System.out.println("Insert failed!");
            }
            // statement.close();
           //  connection.close();
        }
    }
    public static List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book.author");

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Author author = new Author(id, name);
                authors.add(author);
            }

           // resultSet.close();
          //  statement.close();
          //  connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authors;
    }

    public static Author findById(Integer id) {
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book.author WHERE id = " + id);

            if(resultSet.next()) {
                Integer _id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new Author(_id, name);
            }

           // resultSet.close();
           // statement.close();
           // connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void naiveUpdate(Author author) {
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate("UPDATE book.author SET "
                    + "name = '" + author.getName()
                    + "WHERE id = " + author.getId()
            );

            if (affectedRows > 0) {
                System.out.println("Update successfully!");
            } else {
                System.out.println("Update failed!");
            }

          //  statement.close();
          //  connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
