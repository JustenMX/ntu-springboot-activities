package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import sg.edu.ntu.simpleexpenses.exception.OperationFailedException;
import sg.edu.ntu.simpleexpenses.exception.ResourceNotFoundException;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.repository.ExpensesRepository;

@Service
@Primary
public class ExpensesServiceImplementation implements ExpensesService {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesServiceImplementation(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @Override
    public List<Expenses> getAllExpenses() {
        List<Expenses> allExpenses = expensesRepository.findAll();
        if (allExpenses.isEmpty()) {
            throw new ResourceNotFoundException("expenses not found");
        }
        return allExpenses;
    }

    /*
     * GET ONE
     */
    @Override
    public Expenses getExpense(Long id) {
        Expenses foundExpenses = expensesRepository.findById(id).orElse(null);
        if (foundExpenses == null) {
            throw new ResourceNotFoundException("expense not found for ID: " + id);
        }
        return foundExpenses;
    }

    /*
     * GET EXPENSES BY CATEGORY, MIN AMT, MAX AMT
     */
    // @Override
    // public List<Expenses> getExpensesByCategory(ExpenseCategory category, Double
    // minAmount, Double maxAmount) {
    // List<Expenses> filteredExpenses =
    // expensesRepository.getExpensesByCategory(category, minAmount, maxAmount);
    // if (filteredExpenses.isEmpty()) {
    // throw new ResourceNotFoundException("expense not found");
    // }
    // return filteredExpenses;
    // }

    /*
     * CREATE
     */
    @Override
    public Expenses addExpense(Expenses expense) {
        Expenses newExpense = expensesRepository.save(expense);
        return newExpense;
    }

    /*
     * UPDATE
     */
    @Override
    public Expenses updateExpense(Long id, Expenses expense) {
        Expenses updatedExpense = expensesRepository.findById(id).orElse(null);
        if (updatedExpense == null) {
            throw new OperationFailedException("failed to update expense");
        }
        updatedExpense.setDescription(expense.getDescription());
        updatedExpense.setAmount(expense.getAmount());
        updatedExpense.setCategory(expense.getCategory());
        return updatedExpense;
    }

    /*
     * DELETE
     */
    @Override
    public void deleteExpense(Long id) {
        Expenses deleteExpense = expensesRepository.findById(id).orElse(null);
        if (deleteExpense == null) {
            throw new ResourceNotFoundException("Expense with ID " + id + " not found.");
        }
        expensesRepository.deleteById(id);
    }

}
