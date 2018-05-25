package com.online.store.checkout.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Rest Controller Advice to handle exception.
 */
@RestControllerAdvice
class CheckoutExceptionHandler {
	/*
	 * Method to handle exception.
	 * 
	 * @param e the exception object.
	 * @return the ResponseEntity with status HttpStatus.UNPROCESSABLE_ENTITY and error message.
	 */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e) {
        ErrorMessage error = new ErrorMessage("Exception", e.getMessage());
        return new ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
