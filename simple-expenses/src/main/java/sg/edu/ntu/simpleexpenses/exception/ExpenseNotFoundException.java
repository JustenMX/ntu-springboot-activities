package sg.edu.ntu.simpleexpenses.exception;

public class ExpenseNotFoundException extends RuntimeException {

    public ExpenseNotFoundException(Long id) {
        super("Expense not found for ID: " + id);
    }
}
