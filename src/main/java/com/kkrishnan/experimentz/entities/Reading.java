package com.kkrishnan.experimentz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
public class Reading {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "condition_id")
	@JsonUnwrapped
	private ConditionType condition;
	@Column
	private String sample;
	@Column
	private String control;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ConditionType getCondition() {
		return condition;
	}

	public void setCondition(ConditionType condition) {
		this.condition = condition;
	}

	public String getSample() {
		return sample;
	}

	public void setSample(String sample) {
		this.sample = sample;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}
}
