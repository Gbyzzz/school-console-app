package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.CourseDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.StudentDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = new CourseDAOImpl();
    private StudentDAO studentDAO = new StudentDAOImpl();

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
