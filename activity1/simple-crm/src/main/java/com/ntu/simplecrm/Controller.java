package com.ntu.simplecrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Customer customer;

    @GetMapping("/customer")
    public Customer getCustomer() {
        customer.setId("1");
        customer.setFirstName("Justen");
        customer.setLastName("Manni");
        customer.setEmail("justen@email.dev");
        customer.setContactNo("+6512345678");
        customer.setJobTitle("Software Engineer");
        customer.setYearOfBirth(1990);
        return customer;
    }

}
