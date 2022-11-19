package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    List<Student> findAllStudents() throws DAOException;

    void addStudentToCourse(int studentId, int courseId);

    void deleteStudent(int studentId);

    List<Student> findStudentsByCourse(int courseId);

    void removeStudentToCourse(int studentId, int courseId);
}
