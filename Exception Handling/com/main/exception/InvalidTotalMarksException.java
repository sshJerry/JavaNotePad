package com.main.exception;

public class InvalidTotalMarksException extends Exception {
	private String message;
	public InvalidTotalMarksException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}