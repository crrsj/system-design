package br.com.design.excetions;

import org.springframework.validation.FieldError;

public record ValidFields (String field, String message) {
    public  ValidFields(FieldError errors){
        this(errors.getField(), errors.getDefaultMessage());
    }
}
