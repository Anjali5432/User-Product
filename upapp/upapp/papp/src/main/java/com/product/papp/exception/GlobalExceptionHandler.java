package com.product.papp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.product.papp.model.MessageResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// handling global exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/*
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<MessageResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body(new MessageResponse(ex.getMessage()));
	    }
	// Handling ResponseStatusException
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<MessageResponse> handleResponseStatusException(ResponseStatusException ex) {
	    return ResponseEntity.status(ex.getStatusCode())
	           .body(new MessageResponse(ex.getReason()));
	    }
	    */
}