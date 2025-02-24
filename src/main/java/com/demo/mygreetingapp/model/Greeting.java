package com.demo.mygreetingapp.model;

// Greeting model to represent the response data
public class Greeting {
	private String message;

	// Constructor for greeting class
	public Greeting(String message) {
		this.message = message;
	}

	// Getter method for message
	public String getMessage() {
		return message;
	}

	// Setter method for message
	public void setMessage(String message) {
		this.message = message;
	}
}
