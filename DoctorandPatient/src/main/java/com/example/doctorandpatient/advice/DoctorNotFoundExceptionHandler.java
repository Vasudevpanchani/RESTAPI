package com.example.doctorandpatient.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.doctorandpatient.dto.ResponseDTO;
import com.example.doctorandpatient.exception.DoctorNotFoundException;

@RestControllerAdvice
public class DoctorNotFoundExceptionHandler {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseDTO DoctorNotFoundExceptionHandling(DoctorNotFoundException ex) {
		return new ResponseDTO(404, "Error", ex.getMessage());
	}
}
