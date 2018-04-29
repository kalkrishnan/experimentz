package com.kkrishnan.experimentz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kkrishnan.experimentz.entities.Test;
import com.kkrishnan.experimentz.entities.User;

public interface TestRepository extends JpaRepository<Test, Integer>, TestSearchRepository {

	List<Test> findByUser(@Param("user") User user);


}
