package sg.edu.ntu.simpleexpenses.exception;

public class OperationFailedException extends RuntimeException {
    public OperationFailedException(String message) {
        super(message);
    }
}
