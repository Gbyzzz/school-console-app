package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOInit;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DBConnection;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOInitImpl implements DAOInit {

    @Override
    public void initDatabase() throws DAOException {
        String query = parseInitFile();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(query);
            DBConnection.setDatabase("school_db");

        } catch (SQLException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private String parseInitFile() {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/school_db.sql")));
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
