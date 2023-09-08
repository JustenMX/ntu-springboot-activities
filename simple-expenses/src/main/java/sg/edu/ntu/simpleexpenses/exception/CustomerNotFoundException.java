package sg.edu.ntu.simpleexpenses.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Customer not found for ID: " + id);
    }
}