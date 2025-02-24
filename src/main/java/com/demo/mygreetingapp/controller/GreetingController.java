package com.demo.mygreetingapp.controller;

import com.demo.mygreetingapp.model.GreetingModel;
import com.demo.mygreetingapp.model.GreetingRequest;
import com.demo.mygreetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

// Base URL for all endpoints
@RestController
@RequestMapping("/greet")
public class GreetingController {

	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	// Handle GET requests (Default Greeting)
	@GetMapping
	public GreetingModel getDefaultGreeting() {
		return new GreetingModel(greetingService.getGreetingMessage(null, null));
	}

	// Handle POST requests (Personalized Greeting)
	@PostMapping
	public GreetingModel createGreeting(@RequestBody GreetingRequest request) {
		String message = greetingService.getGreetingMessage(request.getFirstName(), request.getLastName());
		return new GreetingModel(message);
	}

	// Handles PUT requests
	@PutMapping
	public GreetingModel putGreeting() {
		return new GreetingModel(greetingService.putGreetingMessage());
	}

	// Handles DELETE requests
	@DeleteMapping
	public GreetingModel deleteGreeting() {
		return new GreetingModel(greetingService.deleteGreetingMessage());
	}
}