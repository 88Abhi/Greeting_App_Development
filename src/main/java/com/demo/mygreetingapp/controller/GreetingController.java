package com.demo.mygreetingapp.controller;

import com.demo.mygreetingapp.entity.GreetingMessage;
import com.demo.mygreetingapp.model.GreetingModel;
import com.demo.mygreetingapp.model.GreetingRequest;
import com.demo.mygreetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/greet") // Base URL for all endpoints
public class GreetingController {
	@Autowired
	private final GreetingService greetingService;

	// Constructor to initialize greeting service (DI = dependency Injection)
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

	// Created a method to get messages using id
	@GetMapping("/{Id}")
	public GreetingMessage getGreetingById(@PathVariable Long Id) {
		return greetingService.getGreetingById(Id);
	}

	// Created a method to get all messages using id
	@GetMapping("/{id}")
	public ResponseEntity<GreetingMessage> getAllGreetingById(@PathVariable Long id) {
		return ResponseEntity.ok(greetingService.getGreetingById(id));
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
