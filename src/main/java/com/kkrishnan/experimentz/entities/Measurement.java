package com.kkrishnan.experimentz.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
public class Measurement {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "measurement_id")
	@JsonUnwrapped
	private MeasurementType type;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "reading_id")
	@JsonUnwrapped
	private List<Reading> readings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MeasurementType getType() {
		return type;
	}

	public void setType(MeasurementType type) {
		this.type = type;
	}

	public List<Reading> getReadings() {
		return readings;
	}

	public void setReadings(List<Reading> readings) {
		this.readings = readings;
	}

}
