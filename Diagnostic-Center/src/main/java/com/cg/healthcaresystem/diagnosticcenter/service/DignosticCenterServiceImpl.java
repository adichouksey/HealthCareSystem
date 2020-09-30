package com.cg.healthcaresystem.diagnosticcenter.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.healthcaresystem.diagnosticcenter.dao.IAppointmentDao;
import com.cg.healthcaresystem.diagnosticcenter.dao.IDiagnosticCenterDao;
import com.cg.healthcaresystem.diagnosticcenter.dao.ITestDao;
import com.cg.healthcaresystem.diagnosticcenter.entities.Appointment;
import com.cg.healthcaresystem.diagnosticcenter.entities.DiagnosticCenter;
import com.cg.healthcaresystem.diagnosticcenter.entities.Test;
import com.cg.healthcaresystem.diagnosticcenter.exceptions.CenterNotFoundException;
import com.cg.healthcaresystem.diagnosticcenter.util.CenterUtil;

/**
 * 
 * @author anushka soni
 *
 */
@Service
@Transactional
public class DignosticCenterServiceImpl implements IDiagnosticCenterService {

	@Autowired
	private IDiagnosticCenterDao dao;
	@Autowired
	private ITestDao testDao;
	@Autowired
	private IAppointmentDao appointmentDao;

	/***
	 * 
	 * This method is used to add center
	 * 
	 * @param:center reference object
	 * @return added center
	 */

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter center) {
		String centerId = generateCenterId();
		center.setCenterId(centerId);

		List<Test> testList = new ArrayList<>();
		Test test = new Test(generateTestId(), "SugarTest");
		Test test2 = new Test(generateTestId(), "Blood Test");
		Test test3 = new Test(generateTestId(), "Blood Pressure");
		testList.add(test);
		testList.add(test2);
		testList.add(test3);
		testDao.save(test);
		testDao.save(test2);
		testDao.save(test3);
		center.setListOfTests(testList);// adding the test in center

		List<Appointment> appointmentList = new ArrayList<>();
		Date date = new Date();
		testDao.save(test);
		Appointment appointment = new Appointment(generateUserId(), generateAppId(), test, date, true,
				center.getCenterName());
		appointmentList.add(appointment);
		appointmentDao.save(appointment);
		center.setAppointments(appointmentList);// adding appointment
		CenterUtil.checkPresenceOfCenter(center);// check existence
		return dao.save(center);

	}

	/**
	 * to view all the centers
	 * 
	 * @retun list of centers
	 */
	@Override
	public List<DiagnosticCenter> viewAllDiagnosticCenter() {
		List<DiagnosticCenter> centerList = dao.findAll();
		return centerList;
	}

	/**
	 * @param centerId to remove the center details
	 * @return true/false
	 * 
	 */

	@Override
	public boolean removeDiagnosticCenter(String centerId) {
		Optional<DiagnosticCenter> optional = dao.findById(centerId);
		if (optional.isPresent()) {
			DiagnosticCenter center = optional.get();
			dao.delete(center);
			return true;
		}

		throw new CenterNotFoundException("No center with given details" + centerId);
	}

	/**
	 * @param center reference
	 * @return modified center
	 */
	@Override
	public DiagnosticCenter modifyCenter(DiagnosticCenter center) {
		CenterUtil.checkPresenceOfCenter(center);
		return dao.save(center);
	}

	/**
	 * @param centerId
	 * @return matched centerId with its center details
	 */
	@Override
	public DiagnosticCenter findDiagnosticCenterById(String centerId) {
		Optional<DiagnosticCenter> optional = dao.findById(centerId);
		if (optional.isPresent()) {
			DiagnosticCenter center = optional.get();
			return center;
		}
		throw new CenterNotFoundException("NO center with provided Id " + centerId);

	}

	private String centerId = "C0";
	private String testId = "T0";
	private String appId = "A0";
	private String userId = "U0";

	String generateCenterId() {

		centerId = "C" + (Integer.parseInt(centerId.substring(1, centerId.length())) + 1);
		return centerId;
	}

	String generateTestId() {

		testId = "T" + (Integer.parseInt(testId.substring(1, testId.length())) + 1);
		return testId;
	}

	String generateAppId() {

		appId = "A" + (Integer.parseInt(appId.substring(1, appId.length())) + 1);
		return appId;
	}

	String generateUserId() {

		userId = "U" + (Integer.parseInt(userId.substring(1, userId.length())) + 1);
		return userId;
	}

}