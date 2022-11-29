package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.exception.ServiceException;

public interface Command {
    void execute() throws DAOException, ServiceException;
}
