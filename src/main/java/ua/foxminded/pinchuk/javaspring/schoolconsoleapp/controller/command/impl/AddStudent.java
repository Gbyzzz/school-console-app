package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IODataFactory;

public class AddStudent implements Command {
    private IOData io = IODataFactory.getIoData();
    private GroupService groupService = ServiceFactory.getService().getGroupService();
    private StudentService studentService = ServiceFactory.getService().getStudentService();

    public void execute() throws ServiceException {
        io.outputLine("Adding new student");
        io.outputLine("Please input student's first name:");
        String firstName = io.getString();
        io.outputLine("Please input student's last name:");
        String lastName = io.getString();
        io.outputLine("Groups:");
        io.outputList(groupService.findAllGroups());
        io.outputLine("Please input index of group from the list above:");


        if (studentService.addStudent(new Student(firstName, lastName, groupService.findGroupById(io.getInt()))) == 0) {
            io.outputLine("Successfully added");
        } else {
            io.outputLine("Unsuccessful");
        }
    }
}
