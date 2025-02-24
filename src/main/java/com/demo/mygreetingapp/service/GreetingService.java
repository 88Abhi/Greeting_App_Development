package com.demo.mygreetingapp.service;

import com.demo.mygreetingapp.entity.GreetingMessage;
import com.demo.mygreetingapp.model.GreetingModel;
import com.demo.mygreetingapp.model.GreetingRequest;
import com.demo.mygreetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service layer to handle business logic
@Service
public class GreetingService {
	@Autowired
	private final GreetingRepository greetingRepository;

	// Constructor-based Dependency Injection
	public GreetingService(GreetingRepository greetingRepository) {
		this.greetingRepository = greetingRepository;
	}

	// Generate and Save Greeting Message
	public GreetingModel generateAndSaveGreeting(GreetingRequest request) {
		String message;

		if (request.getFirstName() != null && request.getLastName() != null) {
			message = "Hello, " + request.getFirstName() + " " + request.getLastName() + "!";
		}
		else if (request.getFirstName() != null) {
			message = "Hello, " + request.getFirstName() + "!";
		}
		else if (request.getLastName() != null) {
			message = "Hello, " + request.getLastName() + "!";
		}
		else {
			message = "Hello, World!";
		}

		// Save message in the database
		GreetingMessage greetingMessage = new GreetingMessage(message);
		greetingRepository.save(greetingMessage);

		return new GreetingModel(message);
	}

	// Retrieve All Saved Messages
	public List<GreetingMessage> getAllGreetings() {
		return greetingRepository.findAll();
	}

	// Put Method to  update the data
	public String putGreetingMessage() {
		return "Hello Abhishek, this is a PUT request!";
	}

	// Delete method to delete the data
	public String deleteGreetingMessage() {
		return "Hello Abhishek, this is a DELETE request!";
	}
}