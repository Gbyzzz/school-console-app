package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.StudentDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public int addStudent(Student student) {
       if(studentDAO.addStudent(student))
           return 0;
       else return 1;
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
        studentDAO.removeStudentToCourse(studentId, courseId);
    }
}
