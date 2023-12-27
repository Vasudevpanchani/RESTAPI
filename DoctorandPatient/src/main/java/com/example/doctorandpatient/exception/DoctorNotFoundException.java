package com.example.doctorandpatient.exception;

public class DoctorNotFoundException extends RuntimeException{
	
	public DoctorNotFoundException(String message) {
		super(message);
	}
	public DoctorNotFoundException() {
		
	}
}
