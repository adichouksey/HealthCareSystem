package com.cap.healthcaresystem.testmgt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.healthcaresystem.testmgt.dao.ITestDao;

import com.cap.healthcaresystem.testmgt.entities.Test;

import com.cap.healthcaresystem.testmgt.exceptions.TestNotFoundException;



/**
* The TestServiceImp class implements TestService
*
* @author  : Aditya Chouksey
* @version : 1.0
* 
*/


@Service
public class TestServiceImpl implements TestService {

	
	// Tells the application context to inject an instance of ITestDao here
	@Autowired
	private ITestDao testDao;

	
	
	/**
	   * This method is used to add the test. 
	   * @param  test  :This is the  parameter to process test
	   * @return added test  : This returns added test
	   */
	
	
	@Override
	public Test addTest(Test test) {
		if (testDao.existsById(test.getTestId())) {
			throw new TestNotFoundException("Test with testId" + test.getTestId() + " alreadyExists");
		}
		

		return testDao.save(test);

	}

	
	

	/**
	   * This method is used to remove the test. 
	   * @param  testId  :This is the  parameter to delete the test
	   * @return boolean  : This return either test deleted successfully or not
	   */
	
	@Override
	public boolean removeTest(String testId) {
		Optional<Test> optional = testDao.findById(testId);
		if (optional.isPresent()) {
			Test test = optional.get();
			testDao.delete(test);
			return true;
		}
		throw new TestNotFoundException("Test Id not found");
	}

	
	/**
	   * This method is used to fetch all the test details. 
	   * 
	   * @return List  : This return the list of all test
	   */
	
	
	@Override
	public List<Test> fetchAllTest() {
		List<Test> list = testDao.findAll();
		return list;
	}

	
	
	/**
	   * This method is used to modify the test. 
	   * @param  test  :This is the  parameter to modify the test
	   * @return modify test  : This return modified test
	   */
	
	@Override
	public boolean modifyTest(Test test) {

		boolean exists = testDao.existsById(test.getTestId());
		if (exists) {
			test = testDao.save(test);
			return true;
		}
		throw new TestNotFoundException("Test Not Found For these id" + test.getTestId());
	}

	
	/**
	   * This method is used to find the test by testId. 
	   * @param  testId  :This is the  parameter to find the test
	   * @return test  : This return  test according to testId
	   */
	
	@Override
	public Test findTestById(String testId) {

		Optional<Test> optional = testDao.findById(testId);
		if (optional.isPresent()) {
			Test test = optional.get();
			return test;
		}
		throw new TestNotFoundException("Test not found for Test Id=" + testId);
	}
}
