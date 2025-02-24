package com.demo.mygreetingapp.controller;

import com.demo.mygreetingapp.model.GreetingModel;
import com.demo.mygreetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet") // Base URL for all endpoints
public class GreetingController {

	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	// Handles GET requests
	@GetMapping
	public GreetingModel getGreeting() {
		return new GreetingModel(greetingService.getGreetingMessage());
	}

	// Handles POST requests
	@PostMapping
	public GreetingModel postGreeting() {
		return new GreetingModel(greetingService.postGreetingMessage());
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