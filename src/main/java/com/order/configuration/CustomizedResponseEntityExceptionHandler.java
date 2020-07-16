package com.order.configuration;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.order.entity.Error;
import com.order.entity.OrderResponse;
import com.order.exception.ProductException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends
		ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		Error error = new Error();
		error.setErrorCode("O1002");
		error.setErrorMessage(ex.getBindingResult().getFieldErrors().toString());
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setError(error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(orderResponse);
	}

	@ExceptionHandler(ProductException.class)
	public  ResponseEntity<Object> productHandler(ProductException e) {
		Error error = new Error();
		error.setErrorCode(e.getErrorMessage());
		error.setErrorMessage(e.getErrorMessage());
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setError(error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(orderResponse);

	}
}