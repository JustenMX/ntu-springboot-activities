package sg.edu.ntu.simpleexpenses.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.simpleexpenses.pojo.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.repository.ExpensesRepository;

@Component
public class ExpensesDataLoader {

    public ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesDataLoader(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @PostConstruct
    public void loadData() {
        expensesRepository.deleteAll();
        expensesRepository.save(new Expenses("Drinks out with friends", 25.00, ExpenseCategory.FOOD));
        expensesRepository.save(new Expenses("Lunch with colleagues", 15.00, ExpenseCategory.FOOD));
        expensesRepository.save(new Expenses("Movie night", 12.50, ExpenseCategory.ENTERTAINMENT));
        expensesRepository.save(new Expenses("Groceries", 50.00, ExpenseCategory.GROCERY));
        expensesRepository.save(new Expenses("Gym membership", 30.00, ExpenseCategory.FITNESS));
        expensesRepository.save(new Expenses("Transportation", 20.00, ExpenseCategory.TRAVEL));
        expensesRepository.save(new Expenses("Coffee break", 5.00, ExpenseCategory.FOOD));
        expensesRepository.save(new Expenses("Online subscription", 9.99, ExpenseCategory.ENTERTAINMENT));
        expensesRepository.save(new Expenses("Dinner at a restaurant", 40.00, ExpenseCategory.FOOD));
        expensesRepository.save(new Expenses("Clothing shopping", 75.00, ExpenseCategory.SHOPPING));
    }
}
