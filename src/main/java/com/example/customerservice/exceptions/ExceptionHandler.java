package com.example.customerservice.exceptions;
import com.example.customerservice.exceptions.errors.IvalidFieldsException;
import com.example.customerservice.exceptions.errors.LengthException;
import com.example.customerservice.exceptions.errors.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Error> objectNotFoundException(ObjectNotFoundException ex,
                                                         HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not found",
                ex.getMessage(), request.getContextPath());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(LengthException.class)
    public ResponseEntity<Error> objectNotFoundException(LengthException ex,
                                                         HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Fields passed are invalid",
                ex.getMessage(), request.getContextPath());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

// REFATORACAO PARA A API "IBGE"

    @org.springframework.web.bind.annotation.ExceptionHandler(IvalidFieldsException.class)
    public ResponseEntity<Error> objectNotFoundException(IvalidFieldsException ex,
                                                         HttpServletRequest request){
        Error error = new Error(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Invalid fields parsed",
                ex.getMessage(), request.getContextPath());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
