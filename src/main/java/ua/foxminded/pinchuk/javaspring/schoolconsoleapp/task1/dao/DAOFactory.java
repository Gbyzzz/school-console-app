package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl.CourseDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl.GroupDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.impl.StudentDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.dao.utils.DAOUtilsImpl;

public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    private static final CourseDAO COURSE_DAO = new CourseDAOImpl();
    private static final GroupDAO GROUP_DAO = new GroupDAOImpl();
    private static final StudentDAO STUDENT_DAO = new StudentDAOImpl();

    public static CourseDAO getCourseDao() {
        return COURSE_DAO;
    }

    public static GroupDAO getGroupDao() {
        return GROUP_DAO;
    }

    public static StudentDAO getStudentDao() {
        return STUDENT_DAO;
    }

}
