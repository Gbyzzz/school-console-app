package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    List<Student> findAllStudents() throws DAOException;

    void addStudentToCourse(int studentId, int courseId);

    void deleteStudent(int studentId);

    List<Student> findStudentsByCourse(int courseId);

    void removeStudentToCourse(int studentId, int courseId);
}
