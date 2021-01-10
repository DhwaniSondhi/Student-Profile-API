package org.practice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.practice.services.customexceptions.DuplicateKeyException;
import org.practice.services.customexceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * https://developpaper.com/question/on-service-layer-exception-encapsulation/
 * https://dzone.com/articles/spring-rest-service-exception-handling-1
 * https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
 * https://www.baeldung.com/global-error-handler-in-a-spring-rest-api
 * http://zetcode.com/springboot/controlleradvice/
 * */
@ControllerAdvice
public class StudentControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException exp){
		return getResponse(exp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DuplicateKeyException.class)
	public ResponseEntity<Map<String, String>> handleDuplicateKeyException(DuplicateKeyException exp){
		return getResponse(exp, HttpStatus.CONFLICT);
	}
	
	public ResponseEntity<Map<String, String>> getResponse(RuntimeException exp, HttpStatus status){
		Map<String, String> body=new HashMap<String, String>();
		body.put("Error", exp.getMessage());
		
		return new ResponseEntity<Map<String, String>>(body, status);
	}
}
