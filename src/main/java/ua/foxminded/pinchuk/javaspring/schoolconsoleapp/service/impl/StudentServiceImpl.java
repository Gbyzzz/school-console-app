package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = DAOFactory.getStudentDao();

    @Override
    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public List<Student> findAllStudents() throws DAOException {
        return studentDAO.getAllStudents();
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        studentDAO.addStudentToCourse(studentId, courseId);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudentById(studentId);
    }

    @Override
    public List<Student> findStudentsByCourse(int courseId) {
        return studentDAO.getStudentsByCourseId(courseId);
    }

    @Override
    public void removeStudentToCourse(int studentId, int courseId) {
        studentDAO.removeStudentFromCourse(studentId, courseId);
    }
}
