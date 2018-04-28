package com.kkrishnan.experimentz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kkrishnan.experimentz.dao.ConditionTypeRepository;
import com.kkrishnan.experimentz.dao.MeasurementTypeRepository;
import com.kkrishnan.experimentz.dao.TestRepository;
import com.kkrishnan.experimentz.entities.ConditionType;
import com.kkrishnan.experimentz.entities.Measurement;
import com.kkrishnan.experimentz.entities.MeasurementType;
import com.kkrishnan.experimentz.entities.Reading;
import com.kkrishnan.experimentz.entities.Test;
import com.kkrishnan.experimentz.entities.User;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/testApi" })
public class ExperimentController {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private MeasurementTypeRepository measurementTypeRepository;

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

	@GetMapping
	public List<Test> getUserExperiments(@RequestParam User user) {
		List<Test> e = testRepository.findByUser(user);

		return e;
	}

	@RequestMapping(value = "/measurementTypes", method = RequestMethod.GET)
	public List<String> getMeasurements() {

		return measurementTypeRepository.findAllNames();
	}

	@RequestMapping(value = "/conditionTypes", method = RequestMethod.GET)
	public List<String> getConditions() {

		return conditionTypeRepository.findAllNames();
	}
}
