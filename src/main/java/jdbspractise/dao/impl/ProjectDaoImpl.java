package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.ProjectDao;
import jdbspractise.model.Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDaoImpl extends AbstractDao implements ProjectDao {

    public ProjectDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addProject(Project project) {
        final String INSERT_PROJECT =
                "INSERT INTO projects(name, date, company_id, customer_id, cost) VALUE (?, ?, ?, ?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_PROJECT);
            statement.setString(1, project.getName());
            statement.setDate(2, Date.valueOf(project.getDate()));
            statement.setLong(3, project.getCompany().getCompany_id());
            statement.setLong(4, project.getCustomer().getCustomer_id());
            statement.setDouble(5, project.getCost());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getProjectById(Long id) {
        return null;
    }

    @Override
    public void updateProject(Project project) {

    }

    @Override
    public void removeProject(Long id) {

    }
}
