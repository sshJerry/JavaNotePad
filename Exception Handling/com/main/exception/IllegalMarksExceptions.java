package com.main.exception;

public class IllegalMarksExceptions extends Exception {
	private String message;
	public IllegalMarksExceptions(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}

//Construcotsd are used to initalze instance variables.