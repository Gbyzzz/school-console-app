package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.menu.Menu;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.exception.ServiceException;

public class Main {
    private static Menu menu = new Menu();
    public static void main(String[] args) throws DAOException, ServiceException {
        menu.start();
    }
}