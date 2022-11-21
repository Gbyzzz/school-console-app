package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.GroupDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {
    @Override
    public List<Group> findAllGroups() {
        return groupDAO.getAllGroups();
    }

    private GroupDAO groupDAO = new GroupDAOImpl();

    @Override
    public Group findGroupById(int id) throws ServiceException {
        Optional<Group> optionalGroup = groupDAO.getGroupById(id);
        Group group;
        try {
            group = optionalGroup.get();
        } catch (RuntimeException e) {
            throw new ServiceException(e + "No such element in the DB");
        }
        return group;
    }

    @Override
    public Map<Group, Integer> findGroupsByNumberOfStudents(int students) {
        return groupDAO.getGroupsByNumberOfStudents(students);
    }


}
