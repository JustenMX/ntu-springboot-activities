package sg.edu.ntu.springmaven.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception) {
        String ErrorMessage = exception.getMessage();
        return new ResponseEntity<>(ErrorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotCreatedException.class)
    public ResponseEntity<String> handleProductNotCreatedException(ProductNotCreatedException exception) {
        String ErrorMessage = exception.getMessage();
        return new ResponseEntity<String>(ErrorMessage, HttpStatus.NOT_IMPLEMENTED);
    }

}
