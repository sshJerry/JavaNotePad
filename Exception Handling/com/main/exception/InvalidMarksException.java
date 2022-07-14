package com.main.exception;

public class InvalidMarksException extends Exception {
	private String message;
	public InvalidMarksException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}