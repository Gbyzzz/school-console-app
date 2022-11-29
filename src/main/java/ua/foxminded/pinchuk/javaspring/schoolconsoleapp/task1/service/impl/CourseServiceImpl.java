package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.DAOFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = DAOFactory.getInstance().getCourseDao();
    private StudentDAO studentDAO = DAOFactory.getInstance().getStudentDao();

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
