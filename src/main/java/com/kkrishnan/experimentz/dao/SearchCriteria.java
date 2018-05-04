package com.kkrishnan.experimentz.dao;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SearchCriteria {

	private String userName;
	private String measurementName;
	private String version;
	private String formulaId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date startDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date endDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMeasurementName() {
		return measurementName;
	}

	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isValid() {
		return !(this.formulaId == null && this.version == null && this.measurementName == null
				&& this.userName == null && this.startDate == null && this.endDate == null);
	}

	@Override
	public String toString() {
		return "SearchCriteria [userName=" + userName + ", measurementName=" + measurementName + ", version=" + version
				+ ", formulaId=" + formulaId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
