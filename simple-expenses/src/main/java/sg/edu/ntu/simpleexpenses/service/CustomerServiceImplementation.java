package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.simpleexpenses.exception.OperationFailedException;
import sg.edu.ntu.simpleexpenses.exception.ResourceNotFoundException;
import sg.edu.ntu.simpleexpenses.pojo.Customer;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.repository.CustomerRepository;
import sg.edu.ntu.simpleexpenses.repository.ExpensesRepository;

@Primary
@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ExpensesRepository expensesRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository, ExpensesRepository expensesRepository) {
        this.customerRepository = customerRepository;
        this.expensesRepository = expensesRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @Override
    public Expenses addExpensesToCustomer(Long id, Expenses expenses) {
        Customer selectedCustomer = customerRepository.findById(id).orElse(null);
        if (selectedCustomer == null) {
            throw new ResourceNotFoundException("Customer not found");
        }
        expenses.setCustomer(selectedCustomer);
        return expensesRepository.save(expenses);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        if (allCustomers.isEmpty()) {
            throw new ResourceNotFoundException("customers not found");
        }
        return allCustomers;
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            throw new ResourceNotFoundException("customer not found");
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer updateCustomer = customerRepository.findById(id).orElse(null);
        if (updateCustomer == null) {
            throw new OperationFailedException("failed to update customer");
        }
        updateCustomer.setFirstName(customer.getFirstName());
        updateCustomer.setLastName(customer.getLastName());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setContactNo(customer.getContactNo());
        updateCustomer.setJobTitle(customer.getJobTitle());
        updateCustomer.setYearOfBirth(customer.getYearOfBirth());
        return updateCustomer;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
