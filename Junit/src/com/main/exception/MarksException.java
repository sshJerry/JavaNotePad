package com.main.exception;

public class MarksException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3639977697554778735L;
	private String message;
	
	public MarksException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "MarksException [message=" + message + "]";
	}
	
}
