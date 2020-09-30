package com.cg.healthcaresystem.diagnosticcenter.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointment {

	private String userId;
	@Id
	private String appointmentId;
	@OneToOne
	private Test test;
	private Date dateTime;
	private Boolean approved;
	private String CenterName;

	public Appointment() {
		super();
	}

	public Appointment(String userId, String appointmentId, Test test, Date date, Boolean approved, String centerName) {

		this.userId = userId;
		this.appointmentId = appointmentId;
		this.test = test;
		this.dateTime = date;
		this.approved = approved;
		this.CenterName = centerName;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public String getCenterName() {
		return CenterName;
	}

	public void setCenterName(String centerName) {
		CenterName = centerName;
	}

}
