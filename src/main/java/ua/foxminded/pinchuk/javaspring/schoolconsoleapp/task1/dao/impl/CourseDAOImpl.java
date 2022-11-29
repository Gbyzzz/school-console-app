package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.DAOUtils;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.DBConnection;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.utils.DAOUtilsImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private DAOUtils utils = DAOUtilsImpl.getInstance();

    private static final String SQL_GET_ALL_COURSES = "SELECT * FROM courses";
    private static final String SQL_GET_COURSE_BY_STUDENT = "SELECT c.course_id, c.course_name, c.course_description FROM courses_students cs " +
            "JOIN courses c ON cs.course_id=c.course_id WHERE cs.student_id=?";

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_COURSES)) {
            while (resultSet.next()) {
                courses.add(utils.createCourse(resultSet));
            }
        } catch (SQLException|ClassNotFoundException|IOException e) {
            throw new DAOException(e);
        }
        return courses;
    }


    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_COURSE_BY_STUDENT)) {
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                courses.add(utils.createCourse(resultSet));
            }

        } catch (SQLException|ClassNotFoundException|IOException e) {
            throw new DAOException(e);
        }
        return courses;
    }
}
