package com.conroller;

import com.model.User;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.List;

@RestController
public class HelloApplication {

	private static final String key = "PaSsEnCrIpTiOn!?";

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

		String encryptedPass = "";

		try {
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(pass.getBytes());
			encryptedPass = new String(encrypted);
			//System.err.println(encryptedPass);

			/*cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encrypted));
			System.err.println(decrypted);*/
		} catch (Exception ex) {
			System.out.println("Something went wrong!");
		}

		repository.insert(new User(name, encryptedPass));
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public boolean register(@RequestParam("username") String username, @RequestParam("password") String password) {

		String encryptedPass = "";

		try {
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(password.getBytes());
			encryptedPass = new String(encrypted);
		} catch (Exception ex) {
			System.out.println("Something went wrong!");
			return false;
		}

		repository.insert(new User(username, encryptedPass));
		return true;
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "register???";
	}
}}