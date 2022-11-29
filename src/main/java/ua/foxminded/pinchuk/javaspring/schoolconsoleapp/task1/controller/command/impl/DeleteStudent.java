package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.ServiceFactory;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IOData;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.IODataFactory;

import java.util.List;

public class DeleteStudent implements Command {
    private IOData io = IODataFactory.getInstance().getIoData();
    private StudentService studentService = ServiceFactory.getService().getStudentService();

    public void execute() throws DAOException {
        List<Student> students = studentService.findAllStudents();
        if (!students.isEmpty()) {
            io.outputLine("Please select student from the list below:");
            io.outputList(students);
            io.outputLine("Input the index of the student");
            int studentId = io.getInt();
            studentService.deleteStudent(studentId);
        } else {
            io.outputLine("No students were found");
        }

    }
}