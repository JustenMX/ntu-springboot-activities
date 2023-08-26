package sg.edu.ntu.simpleexpenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.ntu.simpleexpenses.POJO.Expenses;
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
        return expensesRepository.getAllExpenses();
    }

    /*
     * GET ONE
     */
    public Expenses getExpenses(String id) {
        return expensesRepository.getExpense(id);
    }

    /*
     * CREATE
     */
    public Expenses addExpenses(Expenses newExpenses) {
        return expensesRepository.addExpenses(newExpenses);
    }

    /*
     * UPDATE
     */
    public Expenses updateExpenses(Expenses updateExpenses) {
        return expensesRepository.updateExpenses(updateExpenses);
    }

    /*
     * DELETE
     */
    public List<Expenses> deleteExpenses(String id) {
        return expensesRepository.deleteExpenses(id);
    }

}
