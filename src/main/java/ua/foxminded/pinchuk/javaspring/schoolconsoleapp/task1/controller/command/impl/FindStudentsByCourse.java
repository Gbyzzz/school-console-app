package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.CourseService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IODataFactory;

import java.util.List;

public class FindStudentsByCourse implements Command {
    private IOData io = IODataFactory.getInstance().getIoData();
    private StudentService studentService = ServiceFactory.getService().getStudentService();
    private CourseService courseService = ServiceFactory.getService().getCourseService();

    public void execute() {
        List<Course> courses = courseService.findAllCourses();
        if (!courses.isEmpty()) {
            io.outputLine("Please select course from the list below:");
            io.outputList(courses);
            io.outputLine("Input the index of the course");
            int courseId = io.getInt();
            io.outputList(studentService.findStudentsByCourse(courseId));
            io.outputLine("");
        } else {
            io.outputLine("No courses were found");
        }

    }
}
