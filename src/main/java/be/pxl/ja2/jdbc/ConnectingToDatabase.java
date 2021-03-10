package be.pxl.ja2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectingToDatabase {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CreateTable.class);

    public static void main(String[] args) {


        try (Connection conn =
                     DriverManager.getConnection("jdbc:mysql://localhost:3306/musicdb", "user", "password");
             Statement statement = conn.createStatement()) {
            statement.execute("CREATE TABLE contacts (id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "name TEXT, " +
                    "phone INTEGER, " +
                    "email TEXT, " +
                    "PRIMARY KEY (id))");
            LOGGER.info("Table 'contacts' created.");
        } catch (SQLException e) {
            LOGGER.fatal("Something went wrong.", e);
        }

    }
}