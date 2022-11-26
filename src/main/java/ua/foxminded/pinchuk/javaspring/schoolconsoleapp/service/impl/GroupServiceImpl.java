package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupServiceImpl implements GroupService {

    private GroupDAO groupDAO = DAOFactory.getInstance().getGroupDAO();

    @Override
    public List<Group> findAllGroups() {
        return groupDAO.getAllGroups();
    }

    @Override
    public Group findGroupById(int id){
        Optional<Group> optionalGroup = groupDAO.getGroupById(id);
        Group group = null;
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        return group;
    }

    @Override
    public Map<Group, Integer> findGroupsByNumberOfStudents(int students) {
        return groupDAO.getGroupsByNumberOfStudents(students);
    }


}
