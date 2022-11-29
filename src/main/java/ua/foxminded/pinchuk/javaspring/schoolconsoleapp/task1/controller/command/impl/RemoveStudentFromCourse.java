package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.CourseService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IODataFactory;

import java.util.List;

public class RemoveStudentFromCourse implements Command {
    private IOData io = IODataFactory.getInstance().getIoData();
    private StudentService studentService = ServiceFactory.getService().getStudentService();
    private CourseService courseService = ServiceFactory.getService().getCourseService();

    public void execute() throws DAOException {
        List<Course> courses = courseService.findAllCourses();
        List<Student> students = studentService.findAllStudents();
        if (!courses.isEmpty() && !students.isEmpty()) {
            io.outputLine("Removing student from course:");
            io.outputLine("Please select student from the list below:");
            io.outputList(students);
            io.outputLine("Input the index of the student");
            int studentId = io.getInt();
            io.outputLine("This student is visiting next courses:");
            io.outputList(courseService.findCourseByStudentId(studentId));
            io.outputLine("Input the index of the course you want to delete");
            int courseId = io.getInt();
            studentService.removeStudentToCourse(studentId, courseId);

        } else {
            io.outputLine("No students or courses were found");
            io.outputLine("");
        }

    }
}
