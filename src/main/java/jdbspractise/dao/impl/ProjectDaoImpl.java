package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.ProjectDao;
import jdbspractise.model.Company;
import jdbspractise.model.Customer;
import jdbspractise.model.Developer;
import jdbspractise.model.Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

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
        final String GET_PROJECT_BI_ID =
                "SELECT * FROM projects WHERE projects_id=?";
        Project project = null;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PROJECT_BI_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                project = getProject(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }
    private Project getProject(ResultSet rs) throws SQLException {
        return Project.builder()
                .projects_id(rs.getLong("project_id"))
                .name(rs.getString("name"))
                .date(rs.getDate("date").toLocalDate())
                .company(Company
                        .builder()
                        .company_id(rs.getLong("company_id"))
                        .build())
                .customer(Customer
                        .builder()
                        .customer_id(rs.getLong("customer_id"))
                        .build())
                .cost(rs.getDouble("cost"))
                .developers(new HashSet<>())
                .build();
    }

    @Override
    public void updateProject(Project project) {
        final String UPDATE_PROJECTS =
                "UPDATE projects " +
                        "SET name=?, date=?, company_id=?, customer_id=?, cost=? " +
                        "WHERE project_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECTS);
            statement.setString(1, project.getName());
            statement.setDate(2, Date.valueOf(project.getDate()));
            statement.setLong(3, project.getCompany().getCompany_id());
            statement.setLong(4, project.getCustomer().getCustomer_id());
            statement.setDouble(5, project.getCost());
            statement.setLong(6, project.getProjects_id());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProject(Long id) {
        final String DELETE_PROJECT_BY_ID =
                "DELETE FROM projects " +
                        "WHERE project_id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT_BY_ID);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
