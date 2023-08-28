package sg.edu.ntu.simpleexpenses.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.simpleexpenses.pojo.ExpenseCategory;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.service.ExpensesService;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    private final Logger logger = LoggerFactory.getLogger(ExpensesController.class);
    private final ExpensesService expensesService;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    /*
     * GET ALL
     */
    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        logger.info("success");
        return new ResponseEntity<>(expensesService.getAllExpenses(), HttpStatus.OK);
    }

    /*
     * GET ONE
     */
    @GetMapping("/{id}")
    public ResponseEntity<Expenses> getExpense(@PathVariable String id) {
        logger.info("success");
        return new ResponseEntity<>(expensesService.getExpense(id), HttpStatus.OK);
    }

    /*
     * GET EXPENSES BY CATEGORY
     */
    @GetMapping("/category")
    public ResponseEntity<List<Expenses>> getExpensesByCategory(
            @RequestParam(required = false) ExpenseCategory category,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount) {
        logger.info("success");
        return new ResponseEntity<>(expensesService.getExpensesByCategory(category, minAmount, maxAmount),
                HttpStatus.OK);
    }

    /*
     * CREATE
     */

    @PostMapping
    public ResponseEntity<Expenses> addExpense(@RequestBody Expenses newExpense) {
        logger.info("success");
        return new ResponseEntity<>(expensesService.addExpense(newExpense), HttpStatus.OK);
    }

    /*
     * UPDATE
     */
    @PutMapping("/{id}")
    public ResponseEntity<Expenses> updateExpense(@PathVariable String id, @RequestBody Expenses updatedExpense) {
        logger.info("success");
        return new ResponseEntity<>(expensesService.updateExpense(updatedExpense), HttpStatus.OK);
    }

    /*
     * DELETE
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Expenses>> deleteExpenses(@PathVariable String id) {
        logger.info("success");
        return new ResponseEntity<>(expensesService.deleteExpense(id), HttpStatus.OK);
    }

}
