package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.CompanyDao;
import jdbspractise.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDaoImpl extends AbstractDao implements CompanyDao {

    public CompanyDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCompany(Company company) {
        final String INSERT_COMPANY =
                "INSERT INTO companies(company_id ,name) VALUE (?, ?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_COMPANY);
            statement.setLong(1, company.getCompany_id());
            statement.setString(2, company.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        final String GET_COMPANY_BY_ID =
                "SELECT company_id, name FROM companies WHERE company_id=? ";
        Company company = new Company();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_COMPANY_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            company.setCompany_id(resultSet.getLong("company_id"));
            company.setName(resultSet.getString("name"));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void updateCompany(Company company) {
        final String UPDATE_COMPANY =
                "UPDATE companies SET name=? WHERE company_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_COMPANY);

            statement.setString(1, company.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCompany(Long id) {
        final String DELETE_DEVELOPER =
                "DELETE FROM companies WHERE company_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_DEVELOPER);

            statement.setLong(1, id);
            statement.execute();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
