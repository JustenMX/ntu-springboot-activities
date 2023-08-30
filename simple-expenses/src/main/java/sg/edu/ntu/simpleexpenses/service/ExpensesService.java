package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import sg.edu.ntu.simpleexpenses.pojo.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;

public interface ExpensesService {

    /**
     * Retrieves all expenses
     * 
     * @return List of expenses.
     */

    List<Expenses> getAllExpenses();

    /**
     * Retrieves a single expense based on its ID
     * 
     * @param id id The ID of the expense to retrieve.
     * @return The expense with the given ID.
     */

    Expenses getExpense(String id);

    /**
     * Retrieves expenses based on category and amount range.
     *
     * @param category  The expense category to filter by.
     * @param minAmount The minimum expense amount (inclusive).
     * @param maxAmount The maximum expense amount (inclusive).
     * @return A list of expenses matching the criteria.
     */

    List<Expenses> getExpensesByCategory(ExpenseCategory category, Double minAmount, Double maxAmount);

    /**
     * Adds a new expense.
     *
     * @param newExpense The expense to add.
     * @return The added expense.
     */

    Expenses addExpense(Expenses newExpense);

    /**
     * Updates an existing expense.
     *
     * @param updatedExpense The updated expense.
     * @return The updated expense.
     */

    Expenses updateExpense(Expenses updateExpense);

    /**
     * Deletes an expense by its ID.
     *
     * @param id The ID of the expense to delete.
     * @return The deleted expense.
     */

    Expenses deleteExpense(String id);

}