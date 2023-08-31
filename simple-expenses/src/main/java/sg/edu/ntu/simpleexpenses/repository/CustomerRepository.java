package sg.edu.ntu.simpleexpenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.simpleexpenses.pojo.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //
}
