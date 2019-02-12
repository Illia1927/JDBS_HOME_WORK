package jdbspractise.dao;

import jdbspractise.model.Customer;

public interface CustomerDao {
    //create
    void addCustomer(Customer customer);
    //read
    Customer getCustomerById(Long id);
    //upate
    void updateCustomer(Customer customer);
    //delete
    void removeCustomer(Long id);
}
