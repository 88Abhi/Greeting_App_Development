package com.demo.mygreetingapp.controller;

import com.demo.mygreetingapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

// REST Controller to handle HTTP requests
@RestController
@RequestMapping("/greet")
public class GreetingController {
	// GET Request to return a simple greeting message
	@GetMapping
	public Greeting getGreeting() {
		return new Greeting("Hello from BridgeLabz - GET Method");
	}

	// POST Request to return a greeting message for POST
	@PostMapping
	public Greeting postGreeting(@RequestBody Greeting greeting) {
		return new Greeting("Hello " + greeting.getMessage() + " from BridgeLabz - POST Method");
	}

	// PUT Request to return a greeting message for PUT
	@PutMapping
	public Greeting putGreeting() {
		return new Greeting("Hello from BridgeLabz - PUT Method");
	}

	// DELETE Request to return a greeting message for DELETE
	@DeleteMapping
	public Greeting deleteGreeting() {
		return new Greeting("Hello from BridgeLabz - DELETE Method");
	}
}
