package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();

    List<Course> findCourseByStudentId(int studentId);
}
