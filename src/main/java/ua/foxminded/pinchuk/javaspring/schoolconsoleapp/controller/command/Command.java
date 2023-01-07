package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

public interface Command {
    void execute() throws DAOException, ServiceException;
}
