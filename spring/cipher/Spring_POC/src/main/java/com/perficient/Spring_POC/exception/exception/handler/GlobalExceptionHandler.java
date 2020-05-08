package com.perficient.Spring_POC.exception.exception.handler;

import com.perficient.Spring_POC.exception.CustomEntityNotFoundException;
import com.perficient.Spring_POC.exception.UnmodifiableEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = CustomEntityNotFoundException.class)
    protected ResponseEntity<Object> handleStudentNotFound(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(value = UnmodifiableEntityException.class)
    protected ResponseEntity<Object> handleUnmodifiableEntity(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
