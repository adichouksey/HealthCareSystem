package com.cap.healthcaresystem.testmgt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;



import com.cap.healthcaresystem.testmgt.entities.Test;

public interface TestService {

    public Test addTest(Test test);

	public boolean removeTest(String testId);

	public boolean modifyTest (Test test);
	
	public List<Test> fetchAllTest();
	
	public Test findTestById(String testId);
	

	
}
