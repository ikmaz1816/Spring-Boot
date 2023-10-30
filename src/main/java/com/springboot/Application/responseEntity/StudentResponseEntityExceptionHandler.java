package com.springboot.Application.responseEntity;

import com.springboot.Application.entity.ErrorMessage;
import com.springboot.Application.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class StudentResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StudentException.class)
        public ResponseEntity<ErrorMessage> reponse(StudentException exception, WebRequest request)
        {
            ErrorMessage e=new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

}

