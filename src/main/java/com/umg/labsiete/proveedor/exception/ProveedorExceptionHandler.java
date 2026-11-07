package com.umg.labsiete.proveedor.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ProveedorExceptionHandler {
    @ExceptionHandler (ProveedorNotFoundException.class)
    public ResponseEntity<String> handleNoEncontrado(ProveedorNotFoundException excepcion){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excepcion.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleArgumentNotValid(MethodArgumentNotValidException excepcion){
        String message = excepcion.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler (ProveedorAlreadyActiveException.class)
    public ResponseEntity<String> handleAlreadyActive(ProveedorAlreadyActiveException excepcion){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excepcion.getMessage());
    }

    @ExceptionHandler (ProveedorAlreadyInactiveException.class)
    public ResponseEntity<String> handleAlreadyInactive(ProveedorAlreadyInactiveException excepcion){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excepcion.getMessage());
    }
}
