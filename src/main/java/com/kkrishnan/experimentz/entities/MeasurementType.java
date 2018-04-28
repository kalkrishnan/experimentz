package com.kkrishnan.experimentz.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MeasurementType {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String measurementName;
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Set<ConditionType> conditionTypes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

//	public Set<ConditionType> getConditionTypes() {
//		return conditionTypes;
//	}
//
//	public void setConditionTypes(Set<ConditionType> conditionTypes) {
//		this.conditionTypes = conditionTypes;
//	}

	public String getMeasurementName() {
		return measurementName;
	}

}
