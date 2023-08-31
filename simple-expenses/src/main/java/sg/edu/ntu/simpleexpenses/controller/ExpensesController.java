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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import sg.edu.ntu.simpleexpenses.exception.OperationFailedException;
import sg.edu.ntu.simpleexpenses.exception.ResourceNotFoundException;
import sg.edu.ntu.simpleexpenses.pojo.Expenses;
import sg.edu.ntu.simpleexpenses.service.ExpensesServiceImplementation;

@RestController
@Tag(name = "Expenses Controller", description = "Create, Update, Delete and Retrieve Expenses")
@RequestMapping("/")
public class ExpensesController {

    private final Logger logger = LoggerFactory.getLogger(ExpensesController.class);
    private final ExpensesServiceImplementation expensesService;

    @Autowired
    public ExpensesController(ExpensesServiceImplementation expensesService) {
        this.expensesService = expensesService;
    }

    /**
     * GET ALL EXPENSES
     * 
     * @return
     */
    @Operation(summary = "Get All Expenses", description = "to get all expenses")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all expenses", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Expenses.class))))
    @ApiResponse(responseCode = "404", description = "Expense does not exist", content = @Content(schema = @Schema(implementation = ResourceNotFoundException.class)))
    @GetMapping("expenses")
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        List<Expenses> allExpenses = expensesService.getAllExpenses();
        logger.info("getAllExpenses() - success");
        return new ResponseEntity<>(allExpenses, HttpStatus.OK);
    }

    /**
     * GET EXPENSE
     * 
     * @param id
     * @return
     */
    @Operation(summary = "Get Expense", description = "to get a single expense based on ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved expense", content = @Content(schema = @Schema(implementation = Expenses.class)))
    @ApiResponse(responseCode = "404", description = "Expense does not exit", content = @Content(schema = @Schema(implementation = ResourceNotFoundException.class)))
    @GetMapping("expenses/{id}")
    public ResponseEntity<Expenses> getExpense(@PathVariable Long id) {
        Expenses expense = expensesService.getExpense(id);
        logger.info("getExpense() - success");
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    /**
     * GET EXPENSE BY CATEGORY
     * 
     * @param expense
     * @return
     */
    // @Operation(summary = "Get Expenses filtered by category", description = "to
    // get expenses based on category, minAmount, maxAmount defined")
    // @ApiResponse(responseCode = "200", description = "Successfully retrieved
    // expenses based on categories", content = @Content(array = @ArraySchema(schema
    // = @Schema(implementation = Expenses.class))))
    // @ApiResponse(responseCode = "404", description = "Expense does not exist",
    // content = @Content(array = @ArraySchema(schema = @Schema(implementation =
    // ResourceNotFoundException.class))))
    // @GetMapping("expenses/category")
    // public ResponseEntity<List<Expenses>> getExpensesByCategory(
    // @RequestParam ExpenseCategory category,
    // @RequestParam(required = false) Double minAmount,
    // @RequestParam(required = false) Double maxAmount) {
    // List<Expenses> filteredExpenses =
    // expensesService.getExpensesByCategory(category, minAmount, maxAmount);
    // logger.info("getExpensesByCategory() - success");
    // return new ResponseEntity<>(filteredExpenses, HttpStatus.OK);
    // }

    /**
     * ADD EXPENSE
     * 
     * @param expense
     * @return
     */
    @Operation(summary = "Create new Expense", description = "to create a new expense")
    @ApiResponse(responseCode = "200", description = "Successfully created expense", content = @Content(schema = @Schema(implementation = Expenses.class)))
    @ApiResponse(responseCode = "400", description = "Expense not created", content = @Content(schema = @Schema(implementation = OperationFailedException.class)))
    @PostMapping("expenses")
    public ResponseEntity<Expenses> addExpense(@RequestBody Expenses expense) {
        Expenses newExpense = expensesService.addExpense(expense);
        logger.info("addExpense() - success");
        return new ResponseEntity<>(newExpense, HttpStatus.OK);
    }

    /**
     * UPDATE EXPENSE
     * 
     * @param id
     * @param expense
     * @return
     */
    @Operation(summary = "Update Expense", description = "to update a single expense based on the ID")
    @ApiResponse(responseCode = "200", description = "Successfully updated expense", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Expenses.class))))
    @ApiResponse(responseCode = "400", description = "Expense not updated", content = @Content(schema = @Schema(implementation = OperationFailedException.class)))
    @PutMapping("expenses/{id}")
    public ResponseEntity<Expenses> updateExpense(@PathVariable Long id, @RequestBody Expenses expense) {
        Expenses updateExpense = expensesService.updateExpense(id, expense);
        logger.info("updateExpense() - success");
        return new ResponseEntity<>(updateExpense, HttpStatus.OK);
    }

    /**
     * DELETE EXPENSE
     * 
     * @param id
     * @return
     */
    @Operation(summary = "Delete Expense", description = "to delete an expense based on the ID")
    @ApiResponse(responseCode = "200", description = "Successfully deleted expense", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Expenses.class))))
    @ApiResponse(responseCode = "400", description = "Expense not deleted", content = @Content(array = @ArraySchema(schema = @Schema(implementation = OperationFailedException.class))))
    @DeleteMapping("expenses/{id}")
    public ResponseEntity<HttpStatus> deleteExpense(@PathVariable Long id) {
        expensesService.deleteExpense(id);
        logger.info("deleteExpense() - success");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
