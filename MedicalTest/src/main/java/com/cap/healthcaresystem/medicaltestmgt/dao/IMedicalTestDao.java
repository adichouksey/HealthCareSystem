package com.cap.healthcaresystem.medicaltestmgt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.healthcaresystem.medicaltestmgt.entities.MedicalTest;

public interface IMedicalTestDao extends JpaRepository<MedicalTest,String>{

	

}
