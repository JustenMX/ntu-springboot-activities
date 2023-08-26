package sg.edu.ntu.simpleexpenses.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.ntu.simpleexpenses.POJO.Expenses;

@Repository
public class ExpensesRepository {

    private List<Expenses> expenseList = new ArrayList<>();

    public ExpensesRepository() {
        expenseList.add(new Expenses("1", "Drinks out with friends", 25.00, "food"));
        expenseList.add(new Expenses("2", "Lunch with colleagues", 15.00, "food"));
        expenseList.add(new Expenses("3", "Movie night", 12.50, "entertainment"));
        expenseList.add(new Expenses("4", "Groceries", 50.00, "grocery"));
        expenseList.add(new Expenses("5", "Gym membership", 30.00, "fitness"));
        expenseList.add(new Expenses("6", "Transportation", 20.00, "travel"));
        expenseList.add(new Expenses("7", "Coffee break", 5.00, "food"));
        expenseList.add(new Expenses("8", "Online subscription", 9.99, "entertainment"));
        expenseList.add(new Expenses("9", "Dinner at a restaurant", 40.00, "food"));
        expenseList.add(new Expenses("10", "Clothing shopping", 75.00, "shopping"));
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
