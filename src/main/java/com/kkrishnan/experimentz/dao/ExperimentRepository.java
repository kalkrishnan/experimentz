package com.kkrishnan.experimentz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.kkrishnan.experimentz.entities.Experiment;
import com.kkrishnan.experimentz.entities.User;

public interface ExperimentRepository extends JpaRepository<Experiment, Integer> {

	List<Experiment> findByUser(@Param("user") User user);

}
