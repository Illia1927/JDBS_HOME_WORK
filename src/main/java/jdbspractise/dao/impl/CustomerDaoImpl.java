package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.CustomerDao;
import jdbspractise.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImpl extends AbstractDao implements CustomerDao {

    public CustomerDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void addCustomer(Customer customer) {
        final String INSERT_CUSTOMER =
                "INSERT INTO customers (costomer_id ,name) VALUE (?, ?) ";

        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER);
            statement.setLong(1, customer.getCustomer_id());
            statement.setString(2, customer.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void removeCustomer(Long id) {

    }
}
