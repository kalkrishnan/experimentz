package com.kkrishnan.experimentz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kkrishnan.experimentz.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);
}
