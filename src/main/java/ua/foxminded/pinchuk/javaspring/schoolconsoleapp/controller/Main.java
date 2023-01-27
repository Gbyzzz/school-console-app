package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.menu.Menu;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.impl.IODataImpl;

public class Main {
    private static Menu menu = new Menu();
    private static IOData ioData = new IODataImpl();
    public static void main(String[] args) {
        try {
            menu.start();
        } catch (ServiceException e) {
            ioData.outputLine("Something went wrong");
        }
    }
}