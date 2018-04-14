package com.kkrishnan.experimentz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kkrishnan.experimentz.entities.IngredientType;

@RepositoryRestResource(collectionResourceRel = "ingredientType", path = "ingredientType")
public interface IngredientTypeRepository extends JpaRepository<IngredientType, Integer> {

	IngredientType findByName(String name);
}
