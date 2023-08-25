package sg.edu.ntu.springmaven.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Could not find Product with id: " + id);
    }

}
