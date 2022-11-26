package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.ServiceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GroupDAOImplTest {

    private GroupDAO groupDAO = new GroupDAOImpl();

    @BeforeAll
    public static void init() {
        try {
            ServiceFactory.initDB();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllGroups() {
        assertEquals(new ArrayList<Group>() {{
            add(new Group(1, "First"));
        }}, groupDAO.getAllGroups());
    }

    @Test
    void getGroupById() {
        assertEquals(Optional.of(new Group(1, "First")), groupDAO.getGroupById(1));
    }

    @Test
    void getGroupsByNumberOfStudents() {
        assertEquals(new HashMap<Group, Integer>() {{
            put(new Group(1, "First"), 2);
        }}, groupDAO.getGroupsByNumberOfStudents(2));
    }
}