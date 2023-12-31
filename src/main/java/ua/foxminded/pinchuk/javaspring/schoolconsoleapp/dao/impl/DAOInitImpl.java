package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DBConnection;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOInit;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOInitImpl implements DAOInit {

    private static final String CREATE_DB = "/school_db_create.sql";
    private static final String INIT_DB = "/school_db.sql";
    private static final String DB_NAME = "school_db";

    @Override
    public void initDatabase() throws DAOException {
        createDB();
        initDBContent();
    }

    private void createDB() throws DAOException {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(parseFile(CREATE_DB));
            DBConnection.setDatabase(DB_NAME);

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initDBContent() {
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(parseFile(INIT_DB));

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String parseFile(String filename) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
        String buff = "";
        while (true) {
            try {
                if (((buff = in.readLine()) == null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append(buff + System.lineSeparator());
        }
        return sb.toString();
    }
}
