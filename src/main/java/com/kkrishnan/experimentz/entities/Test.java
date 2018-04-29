package com.kkrishnan.experimentz.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Test {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String formulaId;
	@Column
	private String version;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Measurement> measurements;
	@Column(name = "operation")
	private String operation;
	@Column(name = "timestamp")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp;
	@Column(name = "specification")
	private String specification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Measurement> getMeasurements() {
		return measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@PrePersist
	public void onPrePersist() {
		audit("INSERT");
	}

	private void audit(String operation) {
		setOperation(operation);
		setTimestamp((new Date()));
	}

}
