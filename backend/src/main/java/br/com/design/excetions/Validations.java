package br.com.design.excetions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Validations {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validatingFields(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ValidFields::new).toList());
    }
}
