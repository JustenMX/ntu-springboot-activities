package sg.edu.ntu.simpleexpenses.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.ntu.simpleexpenses.POJO.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.POJO.Expenses;

@Repository
public class ExpensesRepository {

    private List<Expenses> expenseList = new ArrayList<>();

    public ExpensesRepository() {
        expenseList.add(new Expenses("1", "Drinks out with friends", 25.00, ExpenseCategory.FOOD));
        expenseList.add(new Expenses("2", "Lunch with colleagues", 15.00, ExpenseCategory.FOOD));
        expenseList.add(new Expenses("3", "Movie night", 12.50, ExpenseCategory.ENTERTAINMENT));
        expenseList.add(new Expenses("4", "Groceries", 50.00, ExpenseCategory.GROCERY));
        expenseList.add(new Expenses("5", "Gym membership", 30.00, ExpenseCategory.FITNESS));
        expenseList.add(new Expenses("6", "Transportation", 20.00, ExpenseCategory.TRAVEL));
        expenseList.add(new Expenses("7", "Coffee break", 5.00, ExpenseCategory.FOOD));
        expenseList.add(new Expenses("8", "Online subscription", 9.99, ExpenseCategory.ENTERTAINMENT));
        expenseList.add(new Expenses("9", "Dinner at a restaurant", 40.00, ExpenseCategory.FOOD));
        expenseList.add(new Expenses("10", "Clothing shopping", 75.00, ExpenseCategory.SHOPPING));
    }

    /*
     * GET ALL
     */
    public List<Expenses> getAllExpenses() {
        return expenseList;
    }

    /*
     * GET ONE
     */
    public Expenses getExpense(String id) {
        for (Expenses expense : expenseList) {
            if (expense.getId().equals(id)) {
                return expense;
            }
        }
        return null;
    }

    /*
     * GET EXPENSES BY CATEGORY
     */
    public List<Expenses> getExpensesByCategory(
            ExpenseCategory category,
            Double minAmount,
            Double maxAmount) {
        List<Expenses> filteredExpenses = new ArrayList<>();

        for (Expenses expense : expenseList) {
            boolean categoryMatch = category == null || expense.getCategory().equals(category);
            boolean minAmountMatch = minAmount == null || expense.getAmount() >= minAmount;
            boolean maxAmountMatch = maxAmount == null || expense.getAmount() <= maxAmount;

            if (categoryMatch && minAmountMatch && maxAmountMatch) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }

    /*
     * CREATE
     */
    public Expenses addExpense(Expenses newExpense) {
        expenseList.add(newExpense);
        return newExpense;
    }

    /*
     * UPDATE
     */
    public Expenses updateExpense(Expenses updatedExpense) {
        for (Expenses expense : expenseList) {
            if (expense.getId().equals(updatedExpense.getId())) {
                expense.setDescription(updatedExpense.getDescription());
                expense.setAmount(updatedExpense.getAmount());
                expense.setCategory(updatedExpense.getCategory());
                return expense;
            }
        }
        return null;
    }

    /*
     * DELETE
     */
    public List<Expenses> deleteExpense(String id) {
        expenseList.removeIf(expense -> expense.getId().equals(id));
        return expenseList;
    }

}
