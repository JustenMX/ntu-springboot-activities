package sg.edu.ntu.simpleexpenses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.simpleexpenses.POJO.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.POJO.Expenses;
import sg.edu.ntu.simpleexpenses.service.ExpensesService;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    /*
     * GET ALL
     */
    @GetMapping
    public List<Expenses> getAllExpenses() {
        return expensesService.getAllExpenses();
    }

    /*
     * GET ONE
     */
    @GetMapping("/{id}")
    public Expenses getExpense(@PathVariable String id) {
        return expensesService.getExpense(id);
    }

    /*
     * GET EXPENSES BY CATEGORY
     */
    @GetMapping("/category")
    public List<Expenses> getExpensesByCategory(
            @RequestParam(required = false) ExpenseCategory category,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount) {
        return expensesService.getExpensesByCategory(category, minAmount, maxAmount);
    }

    /*
     * CREATE
     */

    @PostMapping
    public Expenses addExpense(@RequestBody Expenses newExpense) {
        return expensesService.addExpense(newExpense);
    }

    /*
     * UPDATE
     */
    @PutMapping("/{id}")
    public Expenses updateExpense(@PathVariable String id, @RequestBody Expenses updatedExpense) {
        return expensesService.updateExpense(updatedExpense);
    }

    /*
     * DELETE
     */
    @DeleteMapping("/{id}")
    public List<Expenses> deleteExpenses(@PathVariable String id) {
        return expensesService.deleteExpense(id);
    }

}
