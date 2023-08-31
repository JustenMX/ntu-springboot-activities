package sg.edu.ntu.simpleexpenses.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import sg.edu.ntu.simpleexpenses.pojo.Customer;
import sg.edu.ntu.simpleexpenses.service.CustomerServiceImplementation;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerServiceImplementation customerService;

    @Autowired
    public CustomerController(CustomerServiceImplementation customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        logger.info("addCustomer() - success");
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        logger.info("getAllCustomers() - success");
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        logger.info("getCustomer() - success");
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updateCustomer = customerService.updateCustomer(id, customer);
        logger.info("updateCustomer() - success");
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        logger.info("deleteCustomer() - success");
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
