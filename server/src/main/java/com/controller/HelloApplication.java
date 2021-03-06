package com.controller;

import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HelloApplication {

	@Autowired
	private UserRepo repository;

	@GetMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping(value = "/getUsers/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getCurrentUser(@PathVariable(value = "name") String name){
		List<User> newList = new ArrayList<User>();
		newList.add(repository.findByUsername(name));
		return ResponseEntity.ok(newList);
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public boolean register(@RequestParam("username") String username, @RequestParam("password") String password,  HttpServletResponse response) {
		if(repository.findByUsername(username) != null){
			response.setHeader("Location","http://localhost:3000/log-in");
			response.setStatus(302);
			return false;
		}
		repository.insert(new User(username, User.encryptPassword(password)));
		response.setHeader("Location","http://localhost:3000");
		response.setStatus(302);
		return true;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void register(HttpServletResponse response) {
		response.setHeader("Location","http://localhost:3000/sign-up");
		response.setStatus(302);
	}

	@RequestMapping(value = "/login", method =  RequestMethod.POST)
	public boolean login(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			HttpServletResponse response)
	{

		User user = repository.findByUsername(username);
		if (user == null) {
			response.setHeader("Location","http://localhost:3000/sign-up");
			response.setStatus(302);
			return false;
		}
		if(!user.validatePassword(password)){
			response.setHeader("Location","http://localhost:3000/log-in");
			response.setStatus(302);
			return false;
		}
		//session here
		response.setHeader("Location","http://localhost:3000/messages");
		response.setStatus(302);
		return true;
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void login(HttpServletResponse response) {
		response.setHeader("Location","http://localhost:3000/log-in");
		response.setStatus(302);
	}
}