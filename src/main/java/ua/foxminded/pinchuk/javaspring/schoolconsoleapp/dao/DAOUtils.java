package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAOUtils {
    Course createCourse(ResultSet resultSet) throws SQLException;

    Student createStudent(ResultSet resultSet) throws SQLException;

    Group createGroup(ResultSet resultSet) throws SQLException;
}
