package com.cap.healthcaresystem.medicaltestmgt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cap.healthcaresystem.medicaltestmgt.dto.MedicalTestDetailsDto;
import com.cap.healthcaresystem.medicaltestmgt.dto.MedicalTestDto;
import com.cap.healthcaresystem.medicaltestmgt.entities.MedicalTest;
import com.cap.healthcaresystem.medicaltestmgt.exceptions.MedicalTestAlreadyExistsException;
import com.cap.healthcaresystem.medicaltestmgt.exceptions.MedicalTestNotFoundException;
import com.cap.healthcaresystem.medicaltestmgt.service.MedicalTestService;
import com.cap.healthcaresystem.medicaltestmgt.util.MedicalTestUtil;

@RestController
@RequestMapping("/test")
public class MedicalTestController {

	private static final Logger log = LoggerFactory.getLogger(MedicalTestController.class);

	// Tells the application context to inject an instance of TestService here
	@Autowired
	private MedicalTestService testService;

	/**
	 * This method is used to Fetching the all the test.
	 * 
	 * @return list : This returns list of Test
	 */

	@GetMapping
	public ResponseEntity<List<MedicalTestDetailsDto>> fetchAllTest() {
		List<MedicalTest> testList = testService.fetchAllTest();
		List<MedicalTestDetailsDto> list = MedicalTestUtil.convertToDetailsDto(testList);
		ResponseEntity<List<MedicalTestDetailsDto>> response = new ResponseEntity<>(list, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to adding the test.
	 * 
	 * @param test :This is the parameter
	 * @return  : This returns status about the test added or not
	 */
	@PostMapping("/add")
	public ResponseEntity<MedicalTestDetailsDto> addTest(@RequestBody MedicalTestDto requestDto) {
		MedicalTest addtest = new MedicalTest();
		addtest.setTestName(requestDto.getTestName());
		addtest = testService.addTest(addtest);
		MedicalTestDetailsDto dto = MedicalTestUtil.convertToDetailsDto(addtest);
		ResponseEntity<MedicalTestDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to delete the test.
	 * 
	 * @param testId :This is the parameter
	 * @return  : This returns status about the test deleted or not
	 */

	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<Boolean> deleteTest(@PathVariable("testId") String testId) {

		boolean result = testService.removeTest(testId);
		MedicalTestUtil.removeEntry(testId);
		ResponseEntity<Boolean> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to modifying the test.
	 * 
	 * @param test :This is the parameter
	 * @return  : This returns status about the test modified or not
	 */

	@PutMapping("/modify/{testId}")
	public ResponseEntity<MedicalTestDetailsDto> modifyProduct(@PathVariable("testId") String testId,
			@RequestBody MedicalTestDto requestDto) {
		MedicalTest modifytest = testService.findTestById(testId);
		modifytest.setTestName(requestDto.getTestName());
		modifytest = testService.modifyTest(modifytest);
		MedicalTestDetailsDto dto = MedicalTestUtil.convertToDetailsDto(modifytest);
		ResponseEntity<MedicalTestDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;

	}

	/**
	 * This method is used to fetch the test by id.
	 * 
	 * @param testId :This is the parameter
	 * @return : This returns status about the test added or not
	 * 
	 */

	@GetMapping("/get/{testId}")
	public ResponseEntity<MedicalTestDetailsDto> findTestById(@PathVariable("testId") String testId) {
		MedicalTest test = testService.findTestById(testId);
		MedicalTestDetailsDto dto = MedicalTestUtil.convertToDetailsDto(test);
		ResponseEntity<MedicalTestDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;
	}

	@ExceptionHandler(MedicalTestAlreadyExistsException.class)
	public ResponseEntity<String> handleTestNotFound(MedicalTestAlreadyExistsException ex) {
		log.error("Test Name not Exists", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

}
