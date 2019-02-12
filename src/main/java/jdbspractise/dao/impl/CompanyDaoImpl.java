package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.CompanyDao;
import jdbspractise.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return null;
    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void removeCompany(Long id) {

    }
}
