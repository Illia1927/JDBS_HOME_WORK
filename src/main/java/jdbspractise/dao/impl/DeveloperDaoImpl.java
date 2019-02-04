package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.DeveloperDao;
import jdbspractise.model.Developer;
import jdbspractise.model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class DeveloperDaoImpl extends AbstractDao implements DeveloperDao {
    public DeveloperDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addDeveloper(Developer developer) {
        final String INSERT_DEVELOPER =
                "INSERT INTO developers (name, age, salary) VALUE(?, ?, ?) ";
        try {
            //insert developer
            PreparedStatement statement = connection.prepareStatement(INSERT_DEVELOPER);

            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer getDeveloperById(Long id) {
        final String GET_DEVELOPER_BY_ID =
                "SELECT developer_id, name, age, salary FROM developers WHERE developer_id=? ";
        Developer developer = new Developer();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_DEVELOPER_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            developer.setDeveloper_id(resultSet.getLong("developer_id"));
            developer.setName(resultSet.getString("name"));
            developer.setAge(resultSet.getInt("age"));
            developer.setSalary(resultSet.getDouble("salary"));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void updateDeveloper(Developer developer) {
        final String UPDATE_DEVELOPER =
                "UPDATE developers SET name=?, age=?, salary=? WHERE id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_DEVELOPER);

            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.setLong(4, developer.getDeveloper_id());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeDeveloper(Long id) {
        final String DELETE_DEVELOPER =
                "DELETE FROM developers WHERE id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_DEVELOPER);

            statement.setLong(1, id);
            statement.execute();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllByTypeOfSkill(Skill skill){
        final String GET_ALL_DEVELOPER_BY_TYPE_OF_SKILL =
                "SELECT name FROM developers " +
                "WHERE developer_id IN " +
                "(SELECT skills_developers.developer_id " +
                " FROM skills_developers " +
                "WHERE skills_developers.skill_id IN " +
                "(SELECT skill_id " +
                "FROM skill " +
                "WHERE skill.type = ?) " +
                ");";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_DEVELOPER_BY_TYPE_OF_SKILL);
            statement.setString(1, skill.getTypeOfSkill().name());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("name, "));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
