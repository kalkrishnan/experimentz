package com.kkrishnan.experimentz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kkrishnan.experimentz.dao.ExperimentRepository;
import com.kkrishnan.experimentz.dao.IngredientTypeRepository;
import com.kkrishnan.experimentz.entities.Experiment;
import com.kkrishnan.experimentz.entities.Ingredient;
import com.kkrishnan.experimentz.entities.IngredientType;
import com.kkrishnan.experimentz.entities.User;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/experimentApi" })
public class ExperimentController {

	@Autowired
	private ExperimentRepository experimentRepository;

	@Autowired
	private IngredientTypeRepository ingredientTypeRepository;

	@PostMapping
	public Experiment create(@RequestBody Experiment experiment) {
		for (Ingredient ingredient : experiment.getIngredients()) {
			IngredientType type = ingredient.getType();
			type.setId(ingredientTypeRepository.findByName(type.getName()).getId());
		}
		return experimentRepository.save(experiment);
	}

	@GetMapping
	public List<Experiment> getUserExperiments(@RequestParam User user) {
		List<Experiment> e = experimentRepository.findByUser(user);

		return e;
	}

	@RequestMapping(value = "/ingredientTypes", method = RequestMethod.GET)
	public List<String> getIngredients() {

		return ingredientTypeRepository.findAll().stream().map(i -> i.getName()).collect(Collectors.toList());
	}
}
