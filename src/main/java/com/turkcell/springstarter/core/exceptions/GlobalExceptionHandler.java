package com.turkcell.springstarter.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //.class -> bu türdeki excepitonlar diye belirtmek için
    //bu exception her devreye girdiğinde bu metot çalışacak
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException exception){
        return exception.getMessage();
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors= new HashMap<>();
        List<FieldError> validationErrors= exception.getBindingResult().getFieldErrors();

        for(FieldError error:validationErrors){
            errors.put(error.getField(),error.getDefaultMessage());
        }
        return errors;
    }

    /*
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleException(){
        return "Bilinmedik hata";
    }*/
}
