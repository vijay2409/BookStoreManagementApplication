package com.cg.bookstore.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.User;
import com.cg.bookstore.services.ILoginService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {
	
	@Autowired
	private ILoginService loginService;

	@PostMapping("/users")
	public User addUser(@Valid @RequestBody User user) {
		return loginService.addUser(user);
	}
	
	@DeleteMapping("/users/{email}")
	public String removeUser(@PathVariable String email) {
		return loginService.removeUser(email);
	}
	
	
	@PostMapping("/validate")
	public User validateLogin(@RequestBody User user) {
		return loginService.validateLogin(user);
	}

}
