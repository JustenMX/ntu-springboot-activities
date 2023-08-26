package sg.edu.ntu.simpleexpenses.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.ntu.simpleexpenses.POJO.Expenses;

@Repository
public class ExpensesRepository {

    private List<Expenses> expenseList = new ArrayList<>();

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
    public Expenses addExpenses(Expenses newExpense) {
        expenseList.add(newExpense);
        return newExpense;
    }

    /*
     * UPDATE
     */
    public Expenses updateExpenses(Expenses updatedExpenses) {
        for (Expenses expense : expenseList) {
            if (expense.getId().equals(updatedExpenses.getId())) {
                expense.setDescription(updatedExpenses.getDescription());
                expense.setAmount(updatedExpenses.getAmount());
                expense.setCategory(updatedExpenses.getCategory());
                return expense;
            }
        }
        return null;
    }

    /*
     * DELETE
     */
    public List<Expenses> deleteExpenses(String id) {
        expenseList.removeIf(expense -> expense.getId().equals(id));
        return expenseList;
    }

}
