package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.GroupServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOInit;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.DAOInitImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.CourseServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.StudentServiceImpl;

public class ServiceFactory {
    private static final DAOInit INIT = new DAOInitImpl();
    private static final CourseService COURSE_SERVICE = new CourseServiceImpl();
    private static final GroupService GROUP_SERVICE = new GroupServiceImpl();
    private static final StudentService STUDENT_SERVICE = new StudentServiceImpl();

    private ServiceFactory() {
    }

    public static void initDB() throws DAOException {
        INIT.initDatabase();
    }
    public static void initDBContent() throws DAOException {
        INIT.initDBContent();
    }

    public static CourseService getCourseService() {
        return COURSE_SERVICE;
    }

    public static GroupService getGroupService() {
        return GROUP_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }
}
