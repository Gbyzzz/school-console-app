package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = DAOFactory.getInstance().getCourseDAO();
    private StudentDAO studentDAO = DAOFactory.getInstance().getStudentDAO();

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        for (Course course : courses) {
            course.setStudents(studentDAO.getStudentsByCourseId(course.getId()));
        }

        return courses;
    }

    @Override
    public List<Course> findCourseByStudentId(int studentId) {
        return courseDAO.getCoursesByStudentId(studentId);
    }
}
