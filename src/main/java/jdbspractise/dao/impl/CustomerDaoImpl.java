package jdbspractise.dao.impl;

import jdbspractise.dao.AbstractDao;
import jdbspractise.dao.CustomerDao;
import jdbspractise.model.Customer;
import jdbspractise.model.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        final String GET_CUSTOMER_BY_ID =
                "SELECT costomer_id, name FROM customers WHERE costomer_id=? ";
        Customer customer = new Customer();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_CUSTOMER_BY_ID);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            customer.setCustomer_id(resultSet.getLong("costumer_id"));
            customer.setName(resultSet.getString("name"));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        final String UPDATE_CUSTOMER =
                "UPDATE customers SET name=? WHERE costomer_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER);

            statement.setString(1, customer.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCustomer(Long id) {
        final String DELETE_COSTOMER =
                "DELETE FROM customers WHERE costomer_id=? ";
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_COSTOMER);

            statement.setLong(1, id);
            statement.execute();

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
