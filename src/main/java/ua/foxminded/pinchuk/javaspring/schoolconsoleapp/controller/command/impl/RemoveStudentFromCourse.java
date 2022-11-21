package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.CourseService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.CourseServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.GroupServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.StudentServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.IODataFactory;

import java.util.List;

public class RemoveStudentFromCourse implements Command {
    private StudentService service = new StudentServiceImpl();
    private IOData io = IODataFactory.getIoData();
    private GroupService groupService = new GroupServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    public void execute() throws DAOException {
        List<Course> courses = courseService.findAllCourses();
        List<Student> students = studentService.findAllStudents();
        if (courses.size() > 0 && students.size() > 0) {
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
