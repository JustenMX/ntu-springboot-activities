package sg.edu.ntu.springmaven.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ProductNotFoundException.class)

    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception) {
        String errorMessage = exception.getMessage();
        logger.error("ProductNotFoundException triggered: 🟥 ", errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotCreatedException.class)
    public ResponseEntity<String> handleProductNotCreatedException(ProductNotCreatedException exception) {
        String errorMessage = exception.getMessage();
        logger.error("ProductNotCreatedException triggered: 🟥 ", errorMessage);
        return new ResponseEntity<String>(errorMessage, HttpStatus.NOT_IMPLEMENTED);
    }

}
