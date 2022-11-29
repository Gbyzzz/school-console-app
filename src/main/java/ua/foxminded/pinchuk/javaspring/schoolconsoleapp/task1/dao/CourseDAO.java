package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;

import java.util.List;

public interface CourseDAO {
    List<Course> getAllCourses();

    List<Course> getCoursesByStudentId(int studentId);
}
