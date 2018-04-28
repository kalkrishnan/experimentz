package com.kkrishnan.experimentz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kkrishnan.experimentz.entities.MeasurementType;

@RepositoryRestResource(collectionResourceRel = "measurementType", path = "measurementType")
public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Integer> {

	MeasurementType findByMeasurementName(String name);
	
	@Query("select distinct t.measurementName from MeasurementType t")
	List<String> findAllNames();
}
