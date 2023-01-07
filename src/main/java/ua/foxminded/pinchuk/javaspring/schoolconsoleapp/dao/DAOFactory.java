package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.CourseDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.GroupDAOImpl;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl.StudentDAOImpl;

public class DAOFactory {

    private static final CourseDAO COURSE_DAO = new CourseDAOImpl();
    private static final GroupDAO GROUP_DAO = new GroupDAOImpl();
    private static final StudentDAO STUDENT_DAO = new StudentDAOImpl();

    private DAOFactory() {
    }

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
