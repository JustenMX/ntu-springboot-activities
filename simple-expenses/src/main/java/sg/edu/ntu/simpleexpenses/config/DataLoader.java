package sg.edu.ntu.simpleexpenses.config;

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
                Customer customer1 = new Customer("John", "Doe", "john@example.com", "123456789", "Manager", 1980);
                customerRepository.save(customer1);

                Customer customer2 = new Customer("Jane", "Smith", "jane@example.com", "987654321", "Engineer", 1990);
                customerRepository.save(customer2);

                // Create and save expenses associated with customer1
                Expenses expense1 = new Expenses("Drinks out with friends", 25.00, ExpenseCategory.FOOD);
                expense1.setCustomer(customer1);
                expensesRepository.save(expense1);

                Expenses expense2 = new Expenses("Lunch with colleagues", 15.00, ExpenseCategory.FOOD);
                expense2.setCustomer(customer1);
                expensesRepository.save(expense2);

                Expenses expense3 = new Expenses("Gym membership", 30.00, ExpenseCategory.FITNESS);
                expense3.setCustomer(customer1);
                expensesRepository.save(expense3);

                // Create and save expenses associated with customer2
                Expenses expense4 = new Expenses("Movie night", 12.50, ExpenseCategory.ENTERTAINMENT);
                expense4.setCustomer(customer2);
                expensesRepository.save(expense4);

                Expenses expense5 = new Expenses("Groceries", 50.00, ExpenseCategory.GROCERY);
                expense5.setCustomer(customer2);
                expensesRepository.save(expense5);
        }
}