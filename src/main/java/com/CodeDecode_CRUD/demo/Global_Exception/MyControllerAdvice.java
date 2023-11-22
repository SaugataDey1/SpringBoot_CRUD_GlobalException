package com.CodeDecode_CRUD.demo.Global_Exception;

import com.CodeDecode_CRUD.demo.Exception.BusinessException;
import com.CodeDecode_CRUD.demo.Exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.CodeDecode_CRUD.demo.Exception.NoSuchElements_Exception;

@RestControllerAdvice
public class MyControllerAdvice
{
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException)
    {
        return new ResponseEntity<String>("Input field is Empty, Please look", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElements_Exception.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElements_Exception noSuchElementsException)
    {
        return new ResponseEntity<String>("No value present in DB, please change your request : " + noSuchElementsException.getErrorMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException businessException)
    {
        return new ResponseEntity<String>("given employee Id is null",HttpStatus.BAD_REQUEST);
    }
}
