package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static DatabaseUtils instance;
    private static final String DATABASE_HOST = "jdbc:postgresql://localhost:5432/Book?characterEncoding=UTF-8";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "ioana";
    private final HikariDataSource dataSource;
    private DatabaseUtils(){
        HikariConfig config=new HikariConfig();
        config.setJdbcUrl(DATABASE_HOST);
        config.setUsername(DATABASE_USERNAME);
        config.setPassword(DATABASE_PASSWORD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        config.setMaximumPoolSize(10);
        dataSource=new HikariDataSource(config); //obiect pe care il folosesc cand am nev pt
        // a obtine conexiuni la baza de date;
        //el deschide N conexiuni
        //Produce statementuri pe care le comite
        //cand nu mai sunt query-uri de executat, o sa le inchida singur
    }
    public static DatabaseUtils getInstance(){
        if(instance==null){
            instance=new DatabaseUtils();
        }
        return instance;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
