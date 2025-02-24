package com.demo.mygreetingapp.model;

// Greeting model to represent the response data
public class GreetingModel {
	private String message;

	// Constructor for greeting class
	public GreetingModel(String message) {
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
