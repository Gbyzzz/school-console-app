package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOImplTest {

    private CourseDAO courseDAO = new CourseDAOImpl();

    @BeforeAll
    public static void init() {
        try {
            ServiceFactory.initDB();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getAllCourses_ShouldReturnListOfCourses_WhenCallingMethod() {
        List<Course> expected = new ArrayList<Course>() {{
            add(new Course.Builder()
                    .setId(1)
                    .setName("Math")
                    .setDescription("Math lessons")
                    .build());
            add(new Course.Builder()
                    .setId(2)
                    .setName("Physics")
                    .setDescription("Physics lessons")
                    .build());
        }};
        assertEquals(courseDAO.getAllCourses(), expected);
    }

    @ParameterizedTest
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source#provideCourses")
    public void getCoursesByStudentId_ShouldReturnListOfCourses_WhenCallingMethod(List<Course> expected, int id) {
        assertEquals(courseDAO.getCoursesByStudentId(id), expected);
    }

}