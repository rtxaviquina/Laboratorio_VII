package com.umg.labsiete.empleado.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class EmpleadoExceptionHandler {
    @ExceptionHandler(EmpleadoNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EmpleadoNotFoundException excepcion){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excepcion.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidException(MethodArgumentNotValidException excepcion){
        String message = excepcion.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler (EmpleadoAlreadyActiveException.class)
    public ResponseEntity<String> handleAlreadyActive(EmpleadoAlreadyActiveException excepcion){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excepcion.getMessage());
    }

    @ExceptionHandler (EmpleadoAlreadyInactiveException.class)
    public ResponseEntity<String> handleAlreadyInactive(EmpleadoAlreadyInactiveException excepcion){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excepcion.getMessage());
    }
}
