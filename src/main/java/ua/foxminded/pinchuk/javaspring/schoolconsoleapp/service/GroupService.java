package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface GroupService {
    List<Group> findAllGroups();

    Group findGroupById(int id) throws ServiceException;

    Map<Group, Integer> findGroupsByNumberOfStudents(int students);
}
