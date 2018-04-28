package com.kkrishnan.experimentz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kkrishnan.experimentz.entities.ConditionType;

@RepositoryRestResource(collectionResourceRel = "conditionType", path = "conditionType")
public interface ConditionTypeRepository extends JpaRepository<ConditionType, Integer> {

	ConditionType findByConditionName(String name);
	
	@Query("select distinct t.conditionName from ConditionType t")
	List<String> findAllNames();
}
