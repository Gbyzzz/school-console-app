package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.impl;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.beans.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.ColumnName;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DAOUtils;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.DBConnection;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.utils.DAOUtilsImpl;


import java.sql.*;
import java.util.*;

public class GroupDAOImpl implements GroupDAO {
    private DAOUtils utils = new DAOUtilsImpl();

    private static final String SQL_GET_ALL_GROUPS = "SELECT * FROM groups";
    private static final String SQL_GET_GROUP_BY_ID = "SELECT group_id, group_name FROM groups WHERE group_id=?";
    private static final String SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS = "SELECT g.group_id, g.group_name, COUNT(s.group_id) AS total_students FROM groups g " +
            "LEFT OUTER JOIN students s ON s.group_id=g.group_id GROUP BY g.group_id HAVING COUNT(s.group_id)<=? ORDER BY total_students ASC";
    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_GROUPS)){
            while (resultSet.next()){
                groups.add(utils.createGroup(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }
    @Override
    public Optional<Group> getGroupById(int id) {
        Optional<Group> group = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_GROUP_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                group = Optional.of(utils.createGroup(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return group;
    }

    @Override
    public Map<Group, Integer> getGroupsByNumberOfStudents(int students) {
        Map<Group, Integer>  groups = new HashMap<>();
        try (Connection connection =DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS)){
            statement.setInt(1, students);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                groups.put(utils.createGroup(resultSet), resultSet.getInt(ColumnName.TOTAL_STUDENTS.toString()));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }


}
