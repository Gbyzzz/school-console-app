package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final Properties properties = new Properties();
    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String PROPERTY_URL = "db.url";
    private static final String PROPERTY_PASSWORD = "db.password";
    private static final String PROPERTY_USER = "db.user";
    private static final String PROPERTY_DRIVER = "db.driver";
    private static final String DATABASE_URL;
    private static final String DATABASE_PASSWORD;
    private static final String DATABASE_USER;
    private static final String DATABASE_DRIVER;

    static {
        try (InputStream inputStream = DBConnection.class.getClassLoader()
                .getResourceAsStream(DATABASE_PROPERTIES)) {
            properties.load(inputStream);
            DATABASE_URL = properties.getProperty(PROPERTY_URL);
            DATABASE_PASSWORD = properties.getProperty(PROPERTY_PASSWORD);
            DATABASE_USER = properties.getProperty(PROPERTY_USER);
            DATABASE_DRIVER = properties.getProperty(PROPERTY_DRIVER);
            Class.forName(DATABASE_DRIVER);
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException ex) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    private DBConnection() {
    }

    /**
     * @return new connection to database
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
