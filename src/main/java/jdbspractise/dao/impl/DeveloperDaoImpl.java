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
        final String INSERT_DEVELOPER_SKILL =
                "INSERT INTO skills(type, level, developer_id) VALUE(?, ?, ?) ";
        final String SELECT_LAST_DEVELOPER_ID =
                "SELECT MAX(developer_id) AS id FROM developers";
        try {
            //insert developer
            PreparedStatement statement = connection.prepareStatement(INSERT_DEVELOPER);

            statement.setString(1, developer.getName());
            statement.setInt(2, developer.getAge());
            statement.setDouble(3, developer.getSalary());
            statement.executeUpdate();

            //last id
            ResultSet resultSet = statement.executeQuery(SELECT_LAST_DEVELOPER_ID);
            resultSet.next();
            Long lastDeveloperId = resultSet.getLong("id");

            //insert develoer skill
            statement = connection.prepareStatement(INSERT_DEVELOPER_SKILL);
            for(Skill skill : developer.getSkills()){
                statement.setString(1, skill.getSkillLevel().name());
                statement.setString(2, skill.getTypeOfSkill().name());
                statement.setLong(3, lastDeveloperId);
            }

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
    public Set<Developer> findAllByTypeOfSkill(Skill.TypeOfSkill typeOfSkill) {
        return null;
    }
}
