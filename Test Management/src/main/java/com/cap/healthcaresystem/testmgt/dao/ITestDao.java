package com.cap.healthcaresystem.testmgt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.healthcaresystem.testmgt.entities.Test;

public interface ITestDao extends JpaRepository<Test,String>{

	

}
