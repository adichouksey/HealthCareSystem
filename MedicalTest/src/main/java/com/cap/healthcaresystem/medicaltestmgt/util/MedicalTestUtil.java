package com.cap.healthcaresystem.medicaltestmgt.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cap.healthcaresystem.medicaltestmgt.dto.MedicalTestDetailsDto;
import com.cap.healthcaresystem.medicaltestmgt.entities.MedicalTest;
import com.cap.healthcaresystem.medicaltestmgt.exceptions.MedicalTestAlreadyExistsException;

public class MedicalTestUtil {
	
	private static Map<String,String> tests=new HashMap<>();
	
	public static void checkPresenceOfTest(MedicalTest test) {
		if(tests.containsValue(test.getTestName())) {
			throw new MedicalTestAlreadyExistsException("Medical Test Already Exists");
		}
		tests.put(test.getTestId(),test.getTestName());
	}

	
	public static void removeEntry(String testId) {
		tests.remove(testId);
	}
	
	
	
	
	public static List<MedicalTestDetailsDto> convertToDetailsDto(Collection<MedicalTest> testList) {
		List<MedicalTestDetailsDto> dtos = new ArrayList<>();
		for (MedicalTest test : testList) {
			MedicalTestDetailsDto dto = convertToDetailsDto(test);
			dtos.add(dto);
		}
		return dtos;
	}

	public static MedicalTestDetailsDto convertToDetailsDto(MedicalTest test) {
		MedicalTestDetailsDto dto = new MedicalTestDetailsDto();
		dto.setTestId(test.getTestId());
		dto.setTestName(test.getTestName());
		
		return dto;
	}
}
