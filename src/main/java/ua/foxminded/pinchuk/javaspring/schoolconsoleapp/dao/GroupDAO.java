package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GroupDAO {
    List<Group> getAllGroups();

    Optional<Group> getGroupById(int id);

    Map<Group, Integer> getGroupsByNumberOfStudents(int students);


}
