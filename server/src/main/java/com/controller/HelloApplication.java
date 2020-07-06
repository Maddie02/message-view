package com.conroller;

import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloApplication {

	@Autowired
	private UserRepo repository;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping(value = "/createUser")
	public void createUser(@RequestParam(value = "name", defaultValue = "Gosho") String name, @RequestParam(value = "pass", defaultValue = "Tosho") String pass) {
		repository.insert(new User(name, pass));
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public boolean register(@RequestParam("username") String username, @RequestParam("password") String password) {
		repository.insert(new User(username, password));
		return true;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "register???";
	}
}