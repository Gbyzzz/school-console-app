package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student student);

    List<Student> getAllStudents() throws DAOException;

    void addStudentToCourse(int studentId, int courseId);

    void deleteStudentById(int studentId);

    List<Student> getStudentsByCourseId(int courseId);

    void removeStudentFromCourse(int studentId, int courseId);
}
