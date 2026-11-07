package com.umg.labsiete.profesor.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProfesorExceptionHandler {
    @ExceptionHandler(ProfesorNotFoundException.class)
    public ResponseEntity<String> handleNoEncontrado(ProfesorNotFoundException excepcion){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excepcion.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException excepcion){
        String message = excepcion.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(ProfesorAlreadyInactiveException.class)
    public ResponseEntity<String> handleAlreadyInactive(ProfesorAlreadyInactiveException excepcion){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excepcion.getMessage());
    }

    @ExceptionHandler(ProfesorAlreadyActiveException.class)
    public ResponseEntity<String> handleAlreadyActive(ProfesorAlreadyActiveException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
