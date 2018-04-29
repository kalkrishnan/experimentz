package com.kkrishnan.experimentz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kkrishnan.experimentz.entities.Measurement;
import com.kkrishnan.experimentz.entities.MeasurementType;

@RepositoryRestResource(collectionResourceRel = "measurement", path = "measurement")
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

	List<Measurement> findByType(MeasurementType measurementType);

}
