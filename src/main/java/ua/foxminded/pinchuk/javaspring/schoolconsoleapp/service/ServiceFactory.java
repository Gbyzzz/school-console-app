package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOInit;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.DAOInitImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.CourseServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.GroupServiceImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.service.impl.StudentServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory SERVICE = new ServiceFactory();
    private static final DAOInit INIT = new DAOInitImpl();
    public static void initDB() throws DAOException {
        INIT.initDatabase();
    }
    public static ServiceFactory getService(){
        return SERVICE;
    }
    private CourseService courseService = new CourseServiceImpl();
    private GroupService groupService = new GroupServiceImpl();
    private StudentService studentService = new StudentServiceImpl();

    public CourseService getCourseService(){
        return courseService;
    }
    public GroupService getGroupService(){
        return groupService;
    }
    public StudentService getStudentService(){
        return studentService;
    }
}
