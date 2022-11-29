package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;

public interface DAOInit {
    void initDatabase() throws DAOException;
}
