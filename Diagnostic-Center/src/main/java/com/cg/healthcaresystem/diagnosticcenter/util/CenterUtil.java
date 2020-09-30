package com.cg.healthcaresystem.diagnosticcenter.util;

import java.util.ArrayList;
import java.util.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.healthcaresystem.diagnosticcenter.dto.CenterDetailsDto;

import com.cg.healthcaresystem.diagnosticcenter.entities.DiagnosticCenter;

import com.cg.healthcaresystem.diagnosticcenter.exceptions.CenterAlreadyExitsException;

public class CenterUtil {

	static private Map<String, String> centers = new HashMap<>();

	static public void checkPresenceOfCenter(DiagnosticCenter center) {

	
		for(String diagnosticCenter:centers.values())
			if (diagnosticCenter.toLowerCase().equalsIgnoreCase(center.getCenterName().toLowerCase()))
					{
				throw new CenterAlreadyExitsException("CENTER ALREADY EXISTS");
			}

		centers.put(center.getCenterId(), center.getCenterName());
	}
		
		static public void removeEntry(String centerId)
		{
			centers.remove(centerId);
		}

	

	static public List<CenterDetailsDto> convertToDetailsDto(Collection<DiagnosticCenter> centerList) {
		List<CenterDetailsDto> dtos = new ArrayList<>();
		for (DiagnosticCenter center : centerList) {
			CenterDetailsDto dto = convertToDetailsDto(center);
			dtos.add(dto);
		}
		return dtos;
	}

	public static CenterDetailsDto convertToDetailsDto(DiagnosticCenter center) {
		CenterDetailsDto dto = new CenterDetailsDto();
		dto.setCenterId(center.getCenterId());
		dto.setCenterName(center.getCenterName());
		dto.setListOfTests(center.getListOfTests());
		dto.setAppointments(center.getAppointments());

		return dto;
	}

}
