package com.cap.healthcaresystem.testmgt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.cap.healthcaresystem.testmgt.entities.Test;
import com.cap.healthcaresystem.testmgt.service.TestService;


@RestController
@RequestMapping("/test")
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	// Tells the application context to inject an instance of TestService here
	@Autowired
	private TestService testService;

	/**
	 * This method is used to Fetching the all the test.
	 * 
	 * @return ResponseEntity : This returns list of Test
	 */
	@GetMapping
	public ResponseEntity<List<Test>> fetchAllTest() {
		List<Test> testlist = testService.fetchAllTest();

		ResponseEntity<List<Test>> response = new ResponseEntity<>(testlist, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to adding the test.
	 * 
	 * @param test :This is the paramter
	 * @return ResponseEntity : This returns status about the test added or not
	 */
	@PostMapping("/add")
	public ResponseEntity<Test> addTest(@RequestBody Test test) {
		Test addtest = testService.addTest(test);
		ResponseEntity<Test> response = new ResponseEntity<Test>(addtest, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to delete the test.
	 * 
	 * @param testId :This is the parameter
	 * @return ResponseEntity : This returns status about the test deleted or not
	 */

	@DeleteMapping("/delete/{testId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("testId") String testId) {

		boolean result = testService.removeTest(testId);
		ResponseEntity<Boolean> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to modifying the test.
	 * 
	 * @param test :This is the parameter
	 * @return ResponseEntity : This returns status about the test modified or not
	 */

	@PutMapping("/modify/{testId}")
	public ResponseEntity<Test> modifyProduct(@RequestBody Test test, @PathVariable("testId") String testId) {
		Test modifytest = testService.findTestById(testId);

		boolean result = testService.modifyTest(test);
		ResponseEntity<Test> response = new ResponseEntity<>(modifytest, HttpStatus.OK);
		return response;
	}

	/**
	 * This method is used to fetch the test by id.
	 * 
	 * @param testId :This is the parameter
	 * @return ResponseEntity : This returns status about the test added or not
	 * 
	 */

	@GetMapping("/get/{testId}")
	public ResponseEntity<Test> findTestById(@PathVariable("testId") String testId) {
		Test test = testService.findTestById(testId);

		ResponseEntity<Test> response = new ResponseEntity<>(test, HttpStatus.OK);
		return response;
	}

}
