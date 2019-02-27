package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.DeveloperDao;
import jdbspractise.model.Developer;
import jdbspractise.model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
                "SELECT * FROM developers WHERE developer_id=\"" + id + "\"";
        Developer developer = new Developer();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_DEVELOPER_BY_ID);
            if (!rs.next()) {
                return developer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void updateDeveloper(Developer developer) {
        final String UPDATE_DEVELOPER =
                "UPDATE developers SET name=?, age=?, salary=? WHERE developer_id=? ";
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
                "DELETE FROM developers WHERE developer_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_DEVELOPER);

            statement.setLong(1, id);
            statement.execute();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void getAllByTypeOfSkill(Skill skill) {
//        final String GET_ALL_DEVELOPER_BY_TYPE_OF_SKILL =
//                "SELECT name FROM developers " +
//                        "WHERE developer_id IN " +
//                        "(SELECT skills_developers.developer_id " +
//                        " FROM skills_developers " +
//                        "WHERE skills_developers.skill_id IN " +
//                        "(SELECT skill_id " +
//                        "FROM skills " +
//                        "WHERE skills.type = ? " +
//                        ");";
//        try {
//            PreparedStatement statement = connection.prepareStatement(GET_ALL_DEVELOPER_BY_TYPE_OF_SKILL);
//            statement.setString(1, skill.getTypeOfSkill().name());
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name, "));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    @Override
    public Set<Developer> findAllByLevelOfSkill(Skill.SkillLevel skillLevel) {
        final String SELECT_DEV_BY_LEVEL_OF_SKILL =
                "SELECT developers.developer_id FROM developers " +
                        "INNER JOIN skills ON skills.developer_id = developers.developer_id " +
                        "WHERE skills.level=\"" + skillLevel + "\"";
        return getDevelopers(SELECT_DEV_BY_LEVEL_OF_SKILL);
    }

    private Set<Developer> getDevelopers(String query) {
        Set<Developer> developers = new HashSet<>();
        Set<Long> developersId = new HashSet<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                developersId.add(rs.getLong("developer_id"));
            }
            developersId.forEach(id -> developers.add(getDeveloperById(id)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }
}

