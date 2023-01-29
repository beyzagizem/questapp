package com.example.quest.core.eception;

import com.example.quest.core.utility.result.ErrorResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlboalExeptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        String errorMessage = "";
        for (int i = 0; i < errors.size(); i++) {
            errorMessage += errors.get(i);
            errorMessage += ", ";
        }
        errorMessage = errorMessage.substring(0, errorMessage.length() - 2);
        return new ResponseEntity<>(new ErrorResult(errorMessage), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
