package org.example;

import java.sql.*;

public class AuthorDAO {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into authors (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection(); //o sg instanta a conexiunii la baza de date dc??
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from authors where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null; //daca rez are cel putin o inregistrare
        }
    }
    public String findById(int id) throws SQLException {
        Connection connection=Database.getConnection();
        try(PreparedStatement pstmt =connection.prepareStatement("select name from authors where id= ")){
            pstmt.setInt(1,id);
            try (ResultSet resultSet=pstmt.executeQuery()){
                return resultSet.next() ? resultSet.getString("name"):null;
            }
        }
    }
}
