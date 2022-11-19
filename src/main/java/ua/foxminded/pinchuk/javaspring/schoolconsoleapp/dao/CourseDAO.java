package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;

import java.util.List;

public interface CourseDAO {
    List<Course> getAllCourses();

    List<Course> getCoursesByStudentId(int studentId);
}
