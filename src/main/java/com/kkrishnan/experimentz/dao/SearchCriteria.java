package com.kkrishnan.experimentz.dao;

public class SearchCriteria {

	private String userName;
	private String measurementName;
	private String version;
	private String formulaId;

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

	@Override
	public String toString() {
		return "SearchCriteria [userName=" + userName + ", measurementName=" + measurementName + ", version=" + version
				+ ", formulaId=" + formulaId + "]";
	}

	public boolean isValid() {
		return !(this.formulaId == null && this.version == null && this.measurementName == null
				&& this.userName == null);
	}

}
