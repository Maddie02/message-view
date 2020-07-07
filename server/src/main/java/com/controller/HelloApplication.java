package com.controller;

import com.model.User;
import com.repository.UserRepo;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloApplication {

	@Autowired
	private UserRepo repository;

	@GetMapping("/hello")
	public String hello(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping(value = "/createUser")
	public void createUser(
			@RequestParam(value = "name", defaultValue = "Gosho") String name,
			@RequestParam(value = "pass", defaultValue = "Tosho") String pass) {
		repository.insert(new User(name, pass));
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public void register(
			@RequestParam("username") String username,
			@RequestParam("password") String password,  HttpServletResponse response) {
		repository.insert(new User(username, password));
		response.setHeader("Location","http://localhost:3000/messages");
		response.setStatus(302);
	}

	@RequestMapping(value="/register2", method = RequestMethod.POST)
	public void register(HttpServletResponse response) {
		response.setHeader("Location","http://localhost:3000/sign-up");
		response.setStatus(302);
	}


}