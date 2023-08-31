package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import sg.edu.ntu.simpleexpenses.pojo.Customer;

public interface CustomerService {

    /**
     * CREATE
     * POST ONE CUSTOMER
     * 
     * @param customer
     * @return new customer
     */
    Customer addCustomer(Customer customer);

    /**
     * READ
     * GET ALL CUSTOMERS
     * 
     * @return List of customers
     */
    List<Customer> getAllCustomers();

    /**
     * READ ONE
     * GET ONE CUSTOMER
     * 
     * @param id
     * @return
     */
    Customer getCustomer(Long id);

    /**
     * UPDATE
     * PUT ONE CUSTOMER
     * 
     * @param id
     * @param customer
     * @return updated customer
     */
    Customer updateCustomer(Long id, Customer customer);

    /**
     * DELETE
     * DELETE ONE CUSTOMER
     * 
     * @param id
     */
    void deleteCustomer(Long id);

}
