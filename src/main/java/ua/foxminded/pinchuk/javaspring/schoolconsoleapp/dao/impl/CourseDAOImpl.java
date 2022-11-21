package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOUtils;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DBConnection;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.utils.DAOUtilsImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    private DAOUtils utils = new DAOUtilsImpl();

    private static final String SQL_GET_ALL_COURSES = "SELECT * FROM courses";
    private static final String SQL_REMOVE_STUDENT_FROM_COURSE = "DELETE FROM courses_students WHERE course_id = ? AND student_id = ?";
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
