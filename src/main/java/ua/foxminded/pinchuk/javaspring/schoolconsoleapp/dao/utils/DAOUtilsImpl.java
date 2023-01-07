package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.utils;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.ColumnName;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUtilsImpl implements DAOUtils {
    private static final DAOUtils INSTANCE = new DAOUtilsImpl();

    public static DAOUtils getInstance(){
        return INSTANCE;
    }

    private DAOUtilsImpl() {
    }

    @Override
    public Course createCourse(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnName.COURSE_ID.toString());
        String name = resultSet.getString(ColumnName.COURSE_NAME.toString());
        String description = resultSet.getString(ColumnName.COURSE_DESCRIPTION.toString());
        return new Course.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .build();
    }

    @Override
    public Student createStudent(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnName.STUDENT_ID.toString());
        String firstName = resultSet.getString(ColumnName.FIRST_NAME.toString());
        String lastName = resultSet.getString(ColumnName.LAST_NAME.toString());
        Group group = createGroup(resultSet);
        return new Student.Builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGroup(group)
                .build();
    }

    @Override
    public Group createGroup(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ColumnName.GROUP_ID.toString());
        String name = resultSet.getString(ColumnName.GROUP_NAME.toString());
        return new Group.Builder()
                .setId(id)
                .setName(name)
                .build();
    }
}
