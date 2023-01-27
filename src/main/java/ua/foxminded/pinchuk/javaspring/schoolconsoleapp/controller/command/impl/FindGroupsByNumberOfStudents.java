package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IODataFactory;

import java.util.Map;

public class FindGroupsByNumberOfStudents implements Command {
    private IOData io = IODataFactory.getIOData();
    private GroupService groupService = ServiceFactory.getGroupService();

    public void execute() {
        io.outputLine("Find all groups with less or equal students’ number");
        io.outputLine("Please input a number of students in group:");
        int students = io.getInt();
        Map<Group, Integer> map = groupService.findGroupsByNumberOfStudents(students);
        if (!map.isEmpty()) {
            io.outputMapOfGroups(map);
        } else {
            io.outputLine("No group with such number of students were found");
        }
        io.outputLine("");
    }
}