package com.cg.healthcaresystem.diagnosticcenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcaresystem.diagnosticcenter.entities.Test;

public interface ITestDao extends JpaRepository<Test, String> {

}
