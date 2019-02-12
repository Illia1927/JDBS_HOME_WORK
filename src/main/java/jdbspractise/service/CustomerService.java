package jdbspractise.service;

import jdbspractise.model.Customer;

public interface CustomerService {
    //create
    void addCustomer(Customer customer);
    //read
    Customer getCustomerById(Long id);
    //upate
    void updateCustomer(Customer customer);
    //delete
    void removeCustomer(Long id);

}
