package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.DAOInit;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl.DAOInitImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.impl.CourseServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.impl.GroupServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.service.impl.StudentServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory SERVICE = new ServiceFactory();
    private static final DAOInit INIT = new DAOInitImpl();

    private ServiceFactory() {
    }

    public static void initDB() throws DAOException {
        INIT.initDatabase();
    }

    public static ServiceFactory getService() {
        return SERVICE;
    }

    private static CourseService courseService = new CourseServiceImpl();
    private static GroupService groupService = new GroupServiceImpl();
    private static StudentService studentService = new StudentServiceImpl();

    public static CourseService getCourseService() {
        return courseService;
    }

    public static GroupService getGroupService() {
        return groupService;
    }

    public static StudentService getStudentService() {
        return studentService;
    }
}