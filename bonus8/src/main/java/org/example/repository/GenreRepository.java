package org.example.repository;

import org.example.DatabaseUtils;
import org.example.model.Book;
import org.example.model.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreRepository {

    //creez un gen in tabela genre
    public void create(Genre genre) throws SQLException {
        try (Connection connection = DatabaseUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "insert into genre (name) values (?)")) {
            statement.setString(1, genre.getName());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Insert successfully!");
            } else {
                System.out.println("Insert failed!");
            }
//             statement.close();
//             connection.close();
        }
    }
    public static List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book.genre");

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                Genre genre = new Genre(id, name);
                genres.add(genre);
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genres;
    }

    public static Genre findById(Integer id) {
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book.genre WHERE id = " + id);

            if(resultSet.next()) {
                Integer _id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                return new Genre(_id, name);
            }

//            resultSet.close();
//            statement.close();
//            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void naiveUpdate(Genre genre) {
        try {
            Connection connection = DatabaseUtils.getInstance().getConnection();
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate("UPDATE book.genre SET "
                    + "name = '" + genre.getName()
                    + "WHERE id = " + genre.getId()
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
