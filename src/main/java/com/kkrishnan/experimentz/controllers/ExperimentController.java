package com.kkrishnan.experimentz.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kkrishnan.experimentz.dao.ConditionTypeRepository;
import com.kkrishnan.experimentz.dao.MeasurementRepository;
import com.kkrishnan.experimentz.dao.MeasurementTypeRepository;
import com.kkrishnan.experimentz.dao.SearchCriteria;
import com.kkrishnan.experimentz.dao.TestRepository;
import com.kkrishnan.experimentz.dao.UserRepository;
import com.kkrishnan.experimentz.entities.ConditionType;
import com.kkrishnan.experimentz.entities.Measurement;
import com.kkrishnan.experimentz.entities.MeasurementType;
import com.kkrishnan.experimentz.entities.Reading;
import com.kkrishnan.experimentz.entities.Test;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/testApi" })
public class ExperimentController {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private MeasurementTypeRepository measurementTypeRepository;

	@Autowired
	private MeasurementRepository measurementRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConditionTypeRepository conditionTypeRepository;

	@PostMapping
	public Test create(@RequestBody Test test) {
		for (Measurement measurement : test.getMeasurements()) {
			MeasurementType type = measurement.getType();
			type.setId(measurementTypeRepository.findByMeasurementName(type.getMeasurementName()).getId());
			for (Reading reading : measurement.getReadings()) {
				ConditionType condition = reading.getCondition();
				condition.setId(conditionTypeRepository.findByConditionName(condition.getConditionName()).getId());
			}
		}
		return testRepository.save(test);
	}

	// @GetMapping
	// public List<Test> getUserExperiments(@RequestParam User user) {
	// List<Test> e = testRepository.findByUser(user);
	//
	// return e;
	// }

	@RequestMapping(value = "/tests", method = RequestMethod.POST)
	public List<Test> getTests(@RequestBody SearchCriteria searchCriteria) {
		if (searchCriteria.isValid()) {
			return testRepository.findByCriteria(searchCriteria);
		}

		return Collections.emptyList();
	}

	@RequestMapping(value = "/measurementTypes", method = RequestMethod.GET)
	public List<String> getMeasurements() {

		return measurementTypeRepository.findAllNames();
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<String> getUsers() {

		return userRepository.findAllUserNames();
	}

	@RequestMapping(value = "/conditionTypes", method = RequestMethod.GET)
	public List<String> getConditions() {

		return conditionTypeRepository.findAllNames();
	}
}
