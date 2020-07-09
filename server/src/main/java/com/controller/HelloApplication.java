package com.controller;

import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.model.User.encryptPassword;

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
	public ResponseEntity<List<User>> getUsers(HttpServletResponse response, HttpServletRequest request) {
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("username")) userName = cookie.getValue();
			}
		}
		if(userName == null) {
			response.setHeader("Location","http://localhost:3000/log-in");
			response.setStatus(302);
			return null;
		}else {
			return ResponseEntity.ok(repository.findAll());
		}
	}

	@GetMapping(value = "/createUser")
	public void createUser(@RequestParam(value = "name", defaultValue = "Gosho") String name, @RequestParam(value = "pass", defaultValue = "Tosho") String pass) {
		repository.insert(new User(name, pass));
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public void register(@RequestParam("username") String username, @RequestParam("password") String password,  HttpServletResponse response) {

		repository.insert(new User(username, encryptPassword(password)));

		//show a message "successful log in"
		Cookie loginCookie = new Cookie("username", username);
		//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(30*60);
		response.addCookie(loginCookie);

		response.setHeader("Location","http://localhost:3000/messeges");
		response.setStatus(302);
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void register(HttpServletResponse response) {
		response.setHeader("Location","http://localhost:3000/sign-up");
		response.setStatus(302);
	}

	@GetMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		Cookie loginCookie = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("username")){
					loginCookie = cookie;
					break;
				}
			}
		}
		if(loginCookie != null){
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		response.setHeader("Location","http://localhost:3000/sign-up");
		response.setStatus(302);
	}


	@GetMapping("/login")
	public boolean login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response, HttpSession session) {
		User user = repository.findByUsername(username);
		if (user == null) {
			//show a message "this user doest exist or smth like that"

			response.setHeader("Location","http://localhost:3000/log-in");
			response.setStatus(302);
			return false;
		}
		if(!user.validatePassword(password)){
			//show a message "wrong password"
			response.setHeader("Location","http://localhost:3000/log-in");
			response.setStatus(302);
			return false;
		}

		//show a message "successful log in"
		Cookie loginCookie = new Cookie("username", username);
		//setting cookie to expiry in 30 mins
		loginCookie.setMaxAge(30*60);
		response.addCookie(loginCookie);

		System.out.println(loginCookie.getValue());
		response.setHeader("Location","http://localhost:3000/messages");
		response.setStatus(302);
		return true;
	}

/*
	@RequestMapping(value = "/login", method =  RequestMethod.POST)
	public boolean login(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password,
			HttpServletResponse response)
	{

		User user = repository.findByUsername(username);
		if (user == null) {
			//show a message "this user doest exist or smth like that"
			response.setHeader("Location","http://localhost:3000/sign-up");
			response.setStatus(302);
			return false;
		}
		if(!user.validatePassword(password)){
			//show a message "wrong password"
			response.setHeader("Location","http://localhost:3000/log-in");
			response.setStatus(302);
			return false;
		}

		//show a message "successful log in"
		//session here

		response.setHeader("Location","http://localhost:3000/messages");
		response.setStatus(302);
		return true;
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void login(HttpServletResponse response) {

		response.setHeader("Location","http://localhost:3000/sign-up");
		response.setStatus(302);
	}*/
}