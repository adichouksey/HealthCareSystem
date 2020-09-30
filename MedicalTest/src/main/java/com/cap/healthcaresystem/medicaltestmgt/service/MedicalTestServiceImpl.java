package com.cap.healthcaresystem.medicaltestmgt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.healthcaresystem.medicaltestmgt.dao.IMedicalTestDao;
import com.cap.healthcaresystem.medicaltestmgt.entities.MedicalTest;
import com.cap.healthcaresystem.medicaltestmgt.exceptions.MedicalTestNotFoundException;
import com.cap.healthcaresystem.medicaltestmgt.util.MedicalTestUtil;



/**
* The TestServiceImp class implements TestService
*
* @author  : Aditya Chouksey
* @version : 1.0
* 
*/


@Service
public class MedicalTestServiceImpl implements MedicalTestService {

	
	// Tells the application context to inject an instance of ITestDao here
	@Autowired
	private IMedicalTestDao testDao;

	
	
	
	
	
	/**
	   * This method is used to add the test. 
	   * @param  test  :This is the  parameter to process test
	   * @return added test  : This returns added test
	   */
	
	
	
	
	@Override
	public MedicalTest addTest(MedicalTest test) {
	String testId=generateTestId();
	test.setTestId(testId);
	MedicalTestUtil.checkPresenceOfTest(test);
	
		return testDao.save(test);

	}

	
	

	/**
	   * This method is used to remove the test. 
	   * @param  testId  :This is the  parameter to delete the test
	   * @return boolean  : This return either test deleted successfully or not
	   */
	
	@Override
	public boolean removeTest(String testId) {
		Optional<MedicalTest> optional = testDao.findById(testId);
		if (optional.isPresent()) {
			MedicalTest test = optional.get();
			testDao.delete(test);
			return true;
		}
		throw new MedicalTestNotFoundException("Test Id not found");
	}

	
	/**
	   * This method is used to fetch all the test details. 
	   * 
	   * @return List  : This return the list of all test
	   */
	
	
	@Override
	public List<MedicalTest> fetchAllTest() {
		List<MedicalTest> list = testDao.findAll();
		return list;
	}

	
	
	/**
	   * This method is used to modify the test. 
	   * @param  test  :This is the  parameter to modify the test
	   * @return modify test  : This return modified test
	   */
	
	@Override
	public MedicalTest modifyTest(MedicalTest test) {

		MedicalTestUtil.checkPresenceOfTest(test);
         return testDao.save(test);
	}

	
	/**
	   * This method is used to find the test by testId. 
	   * @param  testId  :This is the  parameter to find the test
	   * @return test  : This return  test according to testId
	   */
	
	@Override
	public MedicalTest findTestById(String testId) {

		Optional<MedicalTest> optional = testDao.findById(testId);
		if (optional.isPresent()) {
			MedicalTest test = optional.get();
			return test;
		}
		throw new MedicalTestNotFoundException("Test not found for Test Id= " + testId);
	}
	
	
	
	String id="T0";
	String generateTestId() {
		id="T"+(Integer.parseInt(id.substring(1,id.length()))+1);
		return id;
	}
	
	
	
	}

