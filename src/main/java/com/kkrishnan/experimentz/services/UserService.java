package com.kkrishnan.experimentz.services;

import java.util.List;

import com.kkrishnan.experimentz.entities.User;

public interface UserService {

	User create(User user);

	List<User> findAll();

	User findByUsername(String username);

	User update(User user);
}