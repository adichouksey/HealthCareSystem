package com.cap.healthcaresystem.medicaltestmgt.service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import com.cap.healthcaresystem.medicaltestmgt.entities.MedicalTest;

public interface MedicalTestService {

    public MedicalTest addTest(MedicalTest test);

	public boolean removeTest(String testId);

	public MedicalTest modifyTest (MedicalTest test);
	
	public List<MedicalTest> fetchAllTest();
	
	public MedicalTest findTestById(String testId);
	
    
}
