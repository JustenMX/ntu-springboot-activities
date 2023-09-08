package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.simpleexpenses.exception.ExpenseNotFoundException;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.repository.ExpensesRepository;

@Primary
@Service
public class ExpensesServiceImplementation implements ExpensesService {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesServiceImplementation(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public List<Expenses> getAllExpenses() {
        List<Expenses> allExpenses = expensesRepository.findAll();
        return allExpenses;
    }

    @Override
    public Expenses getExpense(Long id) {
        Expenses foundExpenses = expensesRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
        return foundExpenses;
    }

    @Override
    public Expenses addExpense(Expenses expense) {
        Expenses newExpense = expensesRepository.save(expense);
        return newExpense;
    }

    @Override
    public Expenses updateExpense(Long id, Expenses expense) {
        Expenses updatedExpense = expensesRepository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
        updatedExpense.setDescription(expense.getDescription());
        updatedExpense.setAmount(expense.getAmount());
        updatedExpense.setCategory(expense.getCategory());
        updatedExpense.setExpenseDate(expense.getExpenseDate());
        return updatedExpense;
    }

    @Override
    public void deleteExpense(Long id) {
        expensesRepository.deleteById(id);
    }

}
