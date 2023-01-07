package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;


import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DBConnection;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOUtils;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.utils.DAOUtilsImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private DAOUtils utils = DAOUtilsImpl.getInstance();

    private static final String SQL_GET_ALL_STUDENTS = "" +
            "SELECT s.student_id, " +
            "       s.first_name, " +
            "       s.last_name, " +
            "       g.group_id, " +
            "       g.group_name " +
            "FROM students s " +
            "JOIN groups g ON s.group_id=g.group_id";
    private static final String SQL_REMOVE_STUDENT_BY_ID = "" +
            "DELETE FROM students " +
            "WHERE student_id=?";
    private static final String SQL_ADD_STUDENT = "" +
            "INSERT INTO students (first_name, last_name, group_id) " +
            "values (?, ?, ?)";
    private static final String SQL_GET_STUDENTS_BY_COURSE_ID = "" +
            "SELECT s.student_id, " +
            "       s.first_name, " +
            "       s.last_name, " +
            "       g.group_id," +
            "       g.group_name " +
            "FROM courses_students " +
            "JOIN students s ON courses_students.student_id=s.student_id " +
            "JOIN groups g ON s.group_id=g.group_id " +
            "WHERE course_id=?";
    private static final String SQL_ADD_STUDENT_TO_COURSE = "" +
            "INSERT INTO courses_students (student_id, course_id) " +
            "values (?, ?) " +
            "ON CONFLICT DO NOTHING";
    private static final String SQL_REMOVE_STUDENT_FROM_COURSE = "" +
            "DELETE FROM courses_students " +
            "WHERE student_id=? " +
            "AND course_id=?";

    @Override
    public boolean addStudent(Student student) {
        boolean added;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_STUDENT + " RETURNING student_id")) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setLong(3, student.getGroup().getId());
            added = statement.execute();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DAOException(e);
        }
        return added;
    }

    @Override
    public List<Student> getAllStudents() throws DAOException {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_STUDENTS)) {
            while (resultSet.next()) {
                students.add(utils.createStudent(resultSet));
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DAOException(e);
        }

        return students;
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_STUDENT_TO_COURSE)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.execute();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void deleteStudentById(int studentId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_REMOVE_STUDENT_BY_ID)) {
            statement.setLong(1, studentId);
            statement.execute();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Student> getStudentsByCourseId(int courseId) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_STUDENTS_BY_COURSE_ID)) {
            statement.setInt(1, courseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(utils.createStudent(resultSet));
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DAOException(e);
        }
        return students;
    }

    @Override
    public void removeStudentFromCourse(int studentId, int courseId) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_REMOVE_STUDENT_FROM_COURSE)) {
            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.execute();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new DAOException(e);
        }
    }
}
