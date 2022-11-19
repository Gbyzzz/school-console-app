package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.menu.Menu;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;

public class Main {
    private static Menu menu = new Menu();
    public static void main(String[] args) throws DAOException, ServiceException {
        menu.start();
    }
}
