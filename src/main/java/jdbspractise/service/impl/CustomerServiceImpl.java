package jdbspractise.service.impl;

import jdbspractise.dao.CustomerDao;
import jdbspractise.model.Customer;
import jdbspractise.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
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
