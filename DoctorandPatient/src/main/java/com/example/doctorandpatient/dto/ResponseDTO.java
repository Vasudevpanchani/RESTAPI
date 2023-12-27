package com.example.doctorandpatient.dto;

public class ResponseDTO {

	private int status;
	private String message;
	private Object Data;

	public ResponseDTO() {
		super();
	}

	public ResponseDTO(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		Data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

}
