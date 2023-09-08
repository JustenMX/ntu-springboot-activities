package sg.edu.ntu.simpleexpenses.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.simpleexpenses.pojo.Customer;
import sg.edu.ntu.simpleexpenses.pojo.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.repository.CustomerRepository;
import sg.edu.ntu.simpleexpenses.repository.ExpensesRepository;

@Component
public class DataLoader {

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private ExpensesRepository expensesRepository;

        @PostConstruct
        public void loadData() {
                generateMockData();
        }

        private void generateMockData() {
                // Create and save customers
                Customer john = Customer.builder().userName("johndoe").firstName("John").lastName("Doe")
                                .email("john@example.com").contactNo("12345678").jobTitle("Manager").yearOfBirth(1980)
                                .build();
                customerRepository.save(john);

                Customer jane = Customer.builder().userName("janesmith").firstName("Jane").lastName("Smith")
                                .email("jane@example.com").contactNo("98745632").jobTitle("Engineer").yearOfBirth(1990)
                                .build();
                customerRepository.save(jane);

                // Create and save expenses associated with john
                Expenses expenses1 = Expenses.builder().description("Drinks out with friends").amount(25.00)
                                .category(ExpenseCategory.FOOD).customer(john).expenseDate(LocalDate.now()).build();
                expensesRepository.save(expenses1);

                Expenses expenses2 = Expenses.builder()
                                .description("Lunch with colleagues")
                                .amount(15.00)
                                .category(ExpenseCategory.FOOD)
                                .customer(john)
                                .expenseDate(LocalDate.now()).build();
                expensesRepository.save(expenses2);

                Expenses expenses3 = Expenses.builder()
                                .description("Gym membership")
                                .amount(30.00)
                                .category(ExpenseCategory.FITNESS)
                                .customer(john)
                                .expenseDate(LocalDate.now()).build();
                expensesRepository.save(expenses3);

                // Create and save expenses associated with jane
                Expenses expenses4 = Expenses.builder()
                                .description("Movie night")
                                .amount(12.50)
                                .category(ExpenseCategory.ENTERTAINMENT)
                                .customer(jane)
                                .expenseDate(LocalDate.now()).build();
                expensesRepository.save(expenses4);

                Expenses expenses5 = Expenses.builder()
                                .description("Groceries")
                                .amount(50.00)
                                .category(ExpenseCategory.GROCERY)
                                .customer(jane)
                                .expenseDate(LocalDate.now()).build();
                expensesRepository.save(expenses5);
        }
}