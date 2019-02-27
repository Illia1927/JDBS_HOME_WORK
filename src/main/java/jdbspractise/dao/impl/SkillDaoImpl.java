package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.SkillDao;
import jdbspractise.model.Developer;
import jdbspractise.model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class SkillDaoImpl extends AbstractDao implements SkillDao {

    public SkillDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addSkill(Skill skill) {
        final String INSERT_DEVELOPER_SKILL =
                "INSERT INTO skills(type, level, developer_id) VALUE(?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_DEVELOPER_SKILL);
            statement.setString(1, skill.getTypeOfSkill().name());
            statement.setString(2, skill.getSkillLevel().name());
            statement.setLong(3, skill.getDeveloperSkills().getDeveloper_id());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill getSkillById(Long id) {
        final String SELECT_SKILL_BY_ID =
                "SELECT * FROM skills WHERE skill_id=?";
        Skill skill = new Skill();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_SKILL_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            skill.setSkill_id(resultSet.getLong("skill_id"));
            skill.setTypeOfSkill(skill.getTypeOfSkill());
            skill.setSkillLevel(skill.getSkillLevel());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void updateSkill(Skill skill) {
        final String UPDATE_SKILL =
                "UPDATE skills SET type, level WHERE skill_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_SKILL);
            statement.setString(1, skill.getTypeOfSkill().name());
            statement.setString(2, skill.getSkillLevel().name());
            statement.setLong(3, skill.getSkill_id());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeSkill(Long id) {
        final String DELETE_SKILL = "DELETE FROM skills WHERE skill_id=?";
        final String DELETE_FROM_DEVELOPER = "DELETE FROM developers_skills WHERE skill=?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_SKILL);
            statement.setLong(1, id);
            statement.execute();

            statement = connection.prepareStatement(DELETE_FROM_DEVELOPER);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
