package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.menu;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.CommandProvider;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IODataFactory;

public class Menu {
    static {
        try {
            ServiceFactory.initDB();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    private IOData io = IODataFactory.getIoData();
    private CommandProvider commandProvider = new CommandProvider();
    private Command command;

    public void start() throws DAOException, ServiceException {
        int select;
        io.outputLine("Hello! You've just started my program, please select the task which you want to launch:");
        while (true) {
            io.outputLine("1. Find all groups with less or equal students’ number");
            io.outputLine("2. Find all students related to the course with the given name");
            io.outputLine("3. Add a new student");
            io.outputLine("4. Delete a student by the STUDENT_ID");
            io.outputLine("5. Add a student to the course (from a list)");
            io.outputLine("6. Remove the student from one of their courses.");
            io.outputLine("Please input number of task from 1 to 6, or input 7 to exit the application");

            select = io.getIntFromRange(1, 7);
            if (select == 7) {
                break;
            }
            command = commandProvider.getCommand(select);
            command.execute();
        }
        close();
    }

    void close() {
        io.close();
        System.exit(0);
    }
}
