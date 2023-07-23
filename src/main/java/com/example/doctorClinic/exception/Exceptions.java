package com.example.doctorClinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse>notFound(NotFound notFound){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setError(notFound.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse>badRequest(BadRequest notFound){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setError(notFound.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse>badRequest(Exception notFound){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setError(notFound.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FAILED_DEPENDENCY);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> errorResponseResponseEntity(NotContent notContent){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setError(notContent.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NO_CONTENT);
    }


}
