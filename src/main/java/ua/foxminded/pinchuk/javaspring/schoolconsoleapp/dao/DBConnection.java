package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/school_db";
    private static final String DATABASE_PASSWORD = "postgres";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_DRIVER = "org.postgresql.Driver";

    private DBConnection() throws ClassNotFoundException {
        Class.forName(DATABASE_DRIVER);
    }

    /**
     * @return new connection to database
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
