package com.cg.healthcaresystem.diagnosticcenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import com.cg.healthcaresystem.diagnosticcenter.dto.CenterDetailsDto;
import com.cg.healthcaresystem.diagnosticcenter.dto.CenterDto;
import com.cg.healthcaresystem.diagnosticcenter.entities.DiagnosticCenter;

import com.cg.healthcaresystem.diagnosticcenter.exceptions.CenterAlreadyExitsException;
import com.cg.healthcaresystem.diagnosticcenter.exceptions.CenterNotFoundException;
import com.cg.healthcaresystem.diagnosticcenter.service.IDiagnosticCenterService;
import com.cg.healthcaresystem.diagnosticcenter.util.CenterUtil;


@RestController
@RequestMapping("/centers")
@Validated
/**
 * 
 * @author Anushka Soni
 * @project name: Health Care System.
 * 
 *
 */
public class DiagnosticCenterRestController {
	private static final Logger Log = LoggerFactory.getLogger(DiagnosticCenterRestController.class);

	@Autowired
	private IDiagnosticCenterService service;
	

	/**
	 * This method is used to view the center details
	 * 
	 * @return list of centers
	 */
	@GetMapping
	ResponseEntity<List<CenterDetailsDto>> viewAll() {
		List<DiagnosticCenter> centerList = service.viewAllDiagnosticCenter();
		List<CenterDetailsDto> list = CenterUtil.convertToDetailsDto(centerList);
		ResponseEntity<List<CenterDetailsDto>> response = new ResponseEntity<>(list, HttpStatus.OK);
		return response;
	}
	

	/**
	 * This method is used to add center
	 * 
	 * @param reqDto
	 * @return added details of center
	 */
	@PostMapping("/add")
	ResponseEntity<CenterDetailsDto> add(@Valid @RequestBody CenterDto reqDto) {
		DiagnosticCenter center = new DiagnosticCenter();
		// center.setCenterId(reqDto.getCenterId());
		center.setCenterName(reqDto.getCenterName());
		//center.setListOfTests(reqDto.getListOfTests());
		//center.setAppointments(reqDto.getAppointments());
		center = service.addDiagnosticCenter(center);
		CenterDetailsDto dto = CenterUtil.convertToDetailsDto(center);
		ResponseEntity<CenterDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;

	}


	/**
	 * This method is used to delete center by Id
	 * 
	 * @param centerId
	 * @return true/false
	 */
	@DeleteMapping("/delete/{centerId}")
	ResponseEntity<Boolean> delete(@PathVariable("centerId") String centerId) {
		boolean result = service.removeDiagnosticCenter(centerId);
		CenterUtil.removeEntry(centerId);
		ResponseEntity<Boolean> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;

	}

	/**
	 * This method is used to view the center details with provided ID
	 * 
	 * @param centerId
	 * @return searched center
	 */
	@GetMapping("/get/{centerId}")
	ResponseEntity<CenterDetailsDto> getById(@PathVariable("centerId") String centerId) {
		DiagnosticCenter center = service.findDiagnosticCenterById(centerId);
		CenterDetailsDto dto = CenterUtil.convertToDetailsDto(center);
		ResponseEntity<CenterDetailsDto> response = new ResponseEntity<>(dto, HttpStatus.OK);
		return response;

	}

	/**
	 * This method is used to modify center details
	 * 
	 * @param centerId
	 * @param dto
	 * @return modified center
	 */
	@PutMapping("/modify/{centerId}")
	ResponseEntity<CenterDetailsDto> modify(@PathVariable("centerId") String centerId,
			@Valid @RequestBody CenterDto dto) {

		DiagnosticCenter center = service.findDiagnosticCenterById(centerId);
		// center.setCenterId(dto.getCenterId());
		center.setCenterName(dto.getCenterName());
		center = service.modifyCenter(center);
		CenterDetailsDto details = CenterUtil.convertToDetailsDto(center);
		ResponseEntity<CenterDetailsDto> response = new ResponseEntity<>(details, HttpStatus.OK);
		return response;

	}

	/**
	 * 
	 * handle userDefine Exception
	 */
	@ExceptionHandler(CenterNotFoundException.class)
	public ResponseEntity<String> handleCenterNotFound(CenterNotFoundException ex) {
		Log.error("center not found exception", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	@ExceptionHandler(CenterAlreadyExitsException.class)
	public ResponseEntity<String> handleCenterAlreadyExits(CenterAlreadyExitsException ex) {
		Log.error("center already exits exception", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	/*
	 * @ExceptionHandler(Throwable.class) public ResponseEntity<String>
	 * handleAll(Throwable ex) { Log.error("Something went wrong", ex); String msg =
	 * "something went wrong"; ResponseEntity<String> response = new
	 * ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR); return response; }
	 */
}
