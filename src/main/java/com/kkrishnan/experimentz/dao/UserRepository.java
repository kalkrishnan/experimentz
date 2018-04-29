package com.kkrishnan.experimentz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kkrishnan.experimentz.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);

	@Query("select distinct t.userName from User t")
	public List<String> findAllUserNames();
}
