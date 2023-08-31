package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

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

    Expenses getExpense(Long id);

    /**
     * Retrieves expenses based on category and amount range.
     *
     * @param category  The expense category to filter by.
     * @param minAmount The minimum expense amount (inclusive).
     * @param maxAmount The maximum expense amount (inclusive).
     * @return A list of expenses matching the criteria.
     */

    // List<Expenses> getExpensesByCategory(ExpenseCategory category, Double
    // minAmount, Double maxAmount);

    /**
     * Adds a new expense.
     *
     * @param expense The expense to add.
     * @return The added expense.
     */

    Expenses addExpense(Expenses expense);

    /**
     * Updates an existing expense.
     *
     * @param id      The id of the expense to update
     * @param expense The expense to update
     * @return The updated expense.
     */

    Expenses updateExpense(Long id, Expenses expense);

    /**
     * Deletes an expense by its ID.
     *
     * @param id The ID of the expense to delete.
     * @return The deleted expense.
     */

    void deleteExpense(Long id);

}