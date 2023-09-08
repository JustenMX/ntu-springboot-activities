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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import sg.edu.ntu.simpleexpenses.exception.CustomerNotFoundException;
import sg.edu.ntu.simpleexpenses.pojo.Customer;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.service.CustomerServiceImplementation;

@Controller
@Tag(name = "Customers Controller", description = "Create, Update, Delete and Retrieve Customers")
@RequestMapping("/customer")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerServiceImplementation customerService;

    @Autowired
    public CustomerController(CustomerServiceImplementation customerService) {
        this.customerService = customerService;
    }

    /**
     * CREATE CUSTOMER
     * 
     * @param customer
     * @return
     */
    @Operation(summary = "Add Customer", description = "to add a new customer")
    @ApiResponse(responseCode = "200", description = "Successfully created customer", content = @Content(schema = @Schema(implementation = Customer.class)))
    @ApiResponse(responseCode = "400", description = "Customer not created", content = @Content(schema = @Schema(implementation = CustomerNotFoundException.class)))
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);

        logger.info("Added new customer [ID: {}, Name: {} {}]", newCustomer.getId(), newCustomer.getFirstName(),
                newCustomer.getLastName());

        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    /**
     * ADD EXPENSES TO CUSTOMER
     * 
     * @param id
     * @param expenses
     * @return
     */
    @Operation(summary = "Add Expenses to Customer", description = "to add expenses to customer")
    @ApiResponse(responseCode = "200", description = "Successfully added expenses to customer", content = @Content(schema = @Schema(implementation = Expenses.class)))
    @ApiResponse(responseCode = "400", description = "Expenses not created to customer", content = @Content(schema = @Schema(implementation = CustomerNotFoundException.class)))
    @PostMapping("{id}/expenses")
    public ResponseEntity<Expenses> addExpensesToCustomer(@PathVariable Long id, @RequestBody Expenses expenses) {
        Expenses newExpense = customerService.addExpensesToCustomer(id, expenses);

        logger.info("Added expense [ID: {}, Amt: ${}] to customer [ID: {}, Name: {} {}]", newExpense.getId(),
                newExpense.getAmount(), newExpense.getCustomer().getId(),
                newExpense.getCustomer().getFirstName(), newExpense.getCustomer().getLastName());

        return new ResponseEntity<>(newExpense, HttpStatus.OK);
    }

    /**
     * GET ALL CUSTOMERS
     * 
     * @return
     */
    @Operation(summary = "Get All Customers", description = "to get all customers")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all customers", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Customer.class))))
    @ApiResponse(responseCode = "404", description = "Customer does not exist", content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerNotFoundException.class))))
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();

        logger.info("Retrieved {} customers successfully", allCustomers.size());

        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    /**
     * GET CUSTOMER
     * 
     * @param id
     * @return
     */
    @Operation(summary = "Get Customer", description = "to get a single customer")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved customer", content = @Content(schema = @Schema(implementation = Customer.class)))
    @ApiResponse(responseCode = "404", description = "Customer does not exist", content = @Content(schema = @Schema(implementation = CustomerNotFoundException.class)))
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);

        logger.info("Retrieved customer [ID: {}, Name: {} {}] successfully", customer.getId(), customer.getFirstName(),
                customer.getLastName());

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * UPDATE CUSTOMER
     * 
     * @param id
     * @param customer
     * @return
     */
    @Operation(summary = "Update Customer", description = "to update a single customer")
    @ApiResponse(responseCode = "200", description = "Successfully updated customer", content = @Content(schema = @Schema(implementation = Customer.class)))
    @ApiResponse(responseCode = "400", description = "Failed to update customer", content = @Content(schema = @Schema(implementation = CustomerNotFoundException.class)))
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updateCustomer = customerService.updateCustomer(id, customer);
        logger.info("Updated customer [ID: {}, Name: {} {}]", customer.getId(), customer.getFirstName(),
                customer.getLastName());
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    /**
     * DELETE CUSTOMER
     * 
     * @param id
     * @return
     */
    @Operation(summary = "Delete Customer", description = "to delete a single customer")
    @ApiResponse(responseCode = "200", description = "Successfully deleted customer", content = @Content(schema = @Schema(implementation = Customer.class)))
    @ApiResponse(responseCode = "400", description = "Failed to delete customer", content = @Content(schema = @Schema(implementation = CustomerNotFoundException.class)))
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        logger.info("Deleted customer with ID: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
