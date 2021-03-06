package com.cap.healthcaresystem.medicaltestmgt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")

public class MedicalTest {

	@Id
	private String testId;
	private String testName;

	public MedicalTest() {
		super();

	}

	public MedicalTest(String testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;

	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testName=" + testName + "]";
	}

	
	
	
	
	
	
	
	/**
	 * Override Hashcode
	 * 
	 * @return hash
	 */

	@Override
	public int hashCode() {
		return testId.hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || !(object instanceof MedicalTest))
			return false;
		MedicalTest test = (MedicalTest) object;
		return this.testId.equals(test.getTestId());
	}

}
