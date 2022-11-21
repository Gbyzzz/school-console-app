package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();

    List<Course> findCourseByStudentId(int studentId);
}
