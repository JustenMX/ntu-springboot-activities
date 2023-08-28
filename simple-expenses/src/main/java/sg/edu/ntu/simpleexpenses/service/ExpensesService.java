package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.ntu.simpleexpenses.exception.OperationFailedException;
import sg.edu.ntu.simpleexpenses.exception.ResourceNotFoundException;
import sg.edu.ntu.simpleexpenses.pojo.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.repository.ExpensesRepository;

@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    /*
     * GET ALL
     */
    public List<Expenses> getAllExpenses() {
        if (expensesRepository.getAllExpenses().isEmpty()) {
            throw new ResourceNotFoundException("expenses not found");
        }
        return expensesRepository.getAllExpenses();
    }

    /*
     * GET ONE
     */
    public Expenses getExpense(String id) {
        if (expensesRepository.getExpense(id) == null) {
            throw new ResourceNotFoundException("expense not found for ID: " + id);
        }
        return expensesRepository.getExpense(id);
    }

    /*
     * GET EXPENSES BY CATEGORY, MIN AMT, MAX AMT
     */
    public List<Expenses> getExpensesByCategory(ExpenseCategory category, Double minAmount, Double maxAmount) {
        if (expensesRepository.getExpensesByCategory(category, minAmount, maxAmount).isEmpty()) {
            throw new ResourceNotFoundException("expense not found");
        }
        return expensesRepository.getExpensesByCategory(category, minAmount, maxAmount);
    }

    /*
     * CREATE
     */
    public Expenses addExpense(Expenses newExpense) {
        if (expensesRepository.addExpense(newExpense) == null) {
            throw new OperationFailedException("failed to add expense");
        }
        return expensesRepository.addExpense(newExpense);
    }

    /*
     * UPDATE
     */
    public Expenses updateExpense(Expenses updateExpense) {
        if (expensesRepository.updateExpense(updateExpense) == null) {
            throw new OperationFailedException("failed to update expense");
        }
        return expensesRepository.updateExpense(updateExpense);
    }

    /*
     * DELETE
     */
    public Expenses deleteExpense(String id) {
        if (expensesRepository.deleteExpense(id) == null) {
            throw new ResourceNotFoundException("Expense with ID " + id + " not found.");
        }
        return expensesRepository.deleteExpense(id);
    }

}
