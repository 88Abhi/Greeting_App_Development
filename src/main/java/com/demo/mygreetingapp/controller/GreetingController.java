package com.demo.mygreetingapp.controller;

import com.demo.mygreetingapp.entity.GreetingMessage;
import com.demo.mygreetingapp.service.GreetingService;
import com.demo.mygreetingapp.model.GreetingModel;
import com.demo.mygreetingapp.model.GreetingRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Base URL for all endpoints
@RestController
@RequestMapping("/greet")
public class GreetingController {
	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	// Create and Save Greeting
	@PostMapping
	public GreetingModel createGreeting(@RequestBody GreetingRequest request) {
		return greetingService.generateAndSaveGreeting(request);
	}

	// Fetch All Saved Greetings
	@GetMapping("/all")
	public List<GreetingMessage> getAllGreetings() {
		return greetingService.getAllGreetings();
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