package com.kkrishnan.experimentz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkrishnan.experimentz.entities.User;
import com.kkrishnan.experimentz.services.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/api" })
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User authenticate(@RequestBody User _user) {
		User user = userService.findByUsername(_user.getUserName());
		if (user.getPassword().equals("password")) {
			return user;
		} else
			return null;
	}

	@PutMapping
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

}
