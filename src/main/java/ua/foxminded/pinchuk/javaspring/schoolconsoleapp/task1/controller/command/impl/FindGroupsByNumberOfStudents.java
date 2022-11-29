package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IODataFactory;

public class FindGroupsByNumberOfStudents implements Command {
    private IOData io = IODataFactory.getInstance().getIoData();
    private GroupService groupService = ServiceFactory.getService().getGroupService();

    public void execute() {
        io.outputLine("Find all groups with less or equal students’ number");
        io.outputLine("Please input a number of students in group:");
        int students = io.getInt();
        io.outputMap(groupService.findGroupsByNumberOfStudents(students));
        io.outputLine("");
    }
}