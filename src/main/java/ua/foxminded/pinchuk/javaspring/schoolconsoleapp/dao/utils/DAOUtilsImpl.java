package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.utils;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.ColumnName.*;

public class DAOUtilsImpl implements DAOUtils {
    @Override
    public Course createCourse(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COURSE_ID.toString());
        String name = resultSet.getString(COURSE_NAME.toString());
        String description = resultSet.getString(COURSE_DESCRIPTION.toString());
        return new Course.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .build();
    }

    @Override
    public Student createStudent(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(STUDENT_ID.toString());
        String firstName = resultSet.getString(FIRST_NAME.toString());
        String lastName = resultSet.getString(LAST_NAME.toString());
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
        int id = resultSet.getInt(GROUP_ID.toString());
        String name = resultSet.getString(GROUP_NAME.toString());
        return new Group.Builder()
                .setId(id)
                .setName(name)
                .build();
    }
}
