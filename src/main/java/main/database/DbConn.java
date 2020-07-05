package main.database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class DbConn {

    private static final String USER = "wayne";
    private static final String PASSWORD = "wayne";

    public static Connection connect() throws ClassNotFoundException, SQLException {

        // Load up the postgresql driver
        Class.forName("org.postgresql.Driver");

        // create a properties object for the username and password
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);

        // set the database url
        String url = "jdbc:postgresql:dpolltest";

        // Connection configuration
        return DriverManager.getConnection(url, props);
    }

}
