package com.kkrishnan.experimentz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkrishnan.experimentz.dao.UserRepository;
import com.kkrishnan.experimentz.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUserName(username);
	}

	@Override
	public User update(User user) {
		return null;
	}
}