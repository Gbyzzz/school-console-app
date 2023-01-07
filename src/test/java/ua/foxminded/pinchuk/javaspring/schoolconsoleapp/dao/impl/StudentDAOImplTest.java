package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.ServiceFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentDAOImplTest {

    private StudentDAO studentDAO = DAOFactory.getStudentDao();

    @BeforeAll
    public static void init() {
        try {
            ServiceFactory.initDB();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source#provideStudents")
    void getAllStudents(List<Student> expected) throws DAOException {
        assertEquals(expected, studentDAO.getAllStudents());
    }

    @ParameterizedTest
    @Order(2)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source#provideStudents")
    void addStudent(List<Student> expected) throws DAOException {
        Student student = new Student(3, Source.group, "Sam", "Green");
        expected.add(student);
        studentDAO.addStudent(student);
        assertEquals(expected, studentDAO.getAllStudents());
    }

    @ParameterizedTest
    @Order(5)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source#provideStudents")
    void deleteStudentById(List<Student> expected) throws DAOException {
        studentDAO.deleteStudentById(3);
        expected.remove(2);
        assertEquals(expected, studentDAO.getAllStudents());
    }

    @ParameterizedTest
    @Order(3)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source#provideStudentsFromCourse")
    void addStudentToCourse(List<Student> expected) {
        studentDAO.addStudentToCourse(3, 1);
        assertEquals(expected, studentDAO.getStudentsByCourseId(1));
    }

    @ParameterizedTest
    @Order(4)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.Source#provideStudentsFromCourse")
    void removeStudentFromCourse(List<Student> expected) {
        expected.remove(1);
        studentDAO.removeStudentFromCourse(3, 1);
        assertEquals(expected, studentDAO.getStudentsByCourseId(1));
    }
}