package com.conroller;

import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloApplication {

	@Autowired
	private UserRepo repository;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping(value = "/createUser")
	public void createUser(@RequestParam(value = "name", defaultValue = "Gosho") String name, @RequestParam(value = "pass", defaultValue = "Tosho") String pass){
		repository.insert(new User(name, pass));
	}


}