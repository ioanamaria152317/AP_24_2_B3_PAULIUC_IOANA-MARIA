package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/books";
    //postgressql -:numele driver ului
    //numele bazei de date

    //statement -simplu sau prepared
    //query-:gen un select
    //resultset-:lista de coloane ----iterator

    //controller, service

    //repo pt fiecare ------toate metodele pt fiecare, metode CRUD --doar interact cu baza de date
    //evaluare dinamica ->selectez cod, chiae si care nu exista
    //clasa utils
    //crud pt fiecare entitate-> se poate si abstract
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() throws SQLException {
        if(connection==null){
            createConnection();
        }
        return connection;
    }
    private static void createConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexiunea a fost stabilita cu success!!!!");
        } catch (SQLException e) {
            System.err.println("Srryyy nu ma pot conecta:(((((" + e);
        }finally {
            if(connection!=null) connection.close();
        }
    }
    public static void closeConnection() {
        try{
            if(connection!=null){
                connection.close();
                System.out.println("Conexiunea la baza de date s-a inchis ooooof!");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void rollback() {
    }
}
