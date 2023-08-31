package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import sg.edu.ntu.simpleexpenses.pojo.Customer;

public interface CustomerService {

    /**
     * CREATE
     * 
     * @param customer
     * @return new customer
     */
    Customer addCustomer(Customer customer);

    /**
     * READ
     * 
     * @return List of customers
     */
    List<Customer> getAllCustomers();

    /**
     * UPDATE
     * 
     * @param id
     * @param customer
     * @return updated customer
     */
    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

}
