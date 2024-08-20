package com.rishi.productservice15aug.advise;

import com.rishi.productservice15aug.dto.ErrorDTO;
import com.rishi.productservice15aug.exceptions.InvalidProductIdException;
import com.rishi.productservice15aug.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ErrorDTO> handleInvalidProductException(InvalidProductIdException e){
        String code = HttpStatus.BAD_REQUEST.toString();

        return new ResponseEntity<>(new ErrorDTO(e.getMessage(), code), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException e){
        String code = HttpStatus.NOT_FOUND.toString();

        return new ResponseEntity<>(new ErrorDTO(e.getMessage(), code), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e){
        String code = HttpStatus.INTERNAL_SERVER_ERROR.toString();
        return new ResponseEntity<>(new ErrorDTO(e.getMessage(), code), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
