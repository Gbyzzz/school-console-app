package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.CourseDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.GroupDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.StudentDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.utils.DAOUtilsImpl;

public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    private static CourseDAO courseDAO = new CourseDAOImpl();
    private static GroupDAO groupDAO = new GroupDAOImpl();
    private static StudentDAO studentDAO = new StudentDAOImpl();
    private static DAOUtils daoUtils = new DAOUtilsImpl();

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public DAOUtils getDaoUtils() {
        return daoUtils;
    }
}
