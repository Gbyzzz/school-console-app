package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface GroupService {
    List<Group> findAllGroups();

    Group findGroupById(int id) throws ServiceException;

    Map<Group, Integer> findGroupsByNumberOfStudents(int students);
}
