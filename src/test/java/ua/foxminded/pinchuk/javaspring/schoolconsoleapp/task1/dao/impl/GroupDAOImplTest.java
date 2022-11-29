package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.DAOFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl.GroupDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.ServiceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GroupDAOImplTest {

    private GroupDAO groupDAO = DAOFactory.getGroupDao();

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