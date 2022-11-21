package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.CourseService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.CourseServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.StudentServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IODataFactory;

import java.util.List;

public class AddStudentToCourse implements Command {
    private IOData io = IODataFactory.getIoData();
    private StudentService studentService = new StudentServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    public void execute() throws DAOException {
        List<Course> courses = courseService.findAllCourses();
        List<Student> students = studentService.findAllStudents();
        if (courses.size() > 0 && students.size() > 0) {
            io.outputLine("Adding student to new course:");
            io.outputLine("Please select student from the list below:");
            io.outputList(students);
            io.outputLine("Input the index of the student");
            int studentId = io.getInt();
            io.outputLine("This student already visiting next courses:");
            io.outputList(courseService.findCourseByStudentId(studentId));
            io.outputLine("List of available courses:");
            io.outputList(courses);
            io.outputLine("");
            io.outputLine("Input the index of the course");
            int courseId = io.getInt();
            studentService.addStudentToCourse(studentId, courseId);
        } else {
            io.outputLine("No students or courses were found");
        }

    }
}
