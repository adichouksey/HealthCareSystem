package com.cg.healthcaresystem.diagnosticcenter.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthcaresystem.diagnosticcenter.entities.Appointment;

public interface IAppointmentDao extends JpaRepository<Appointment, BigInteger> {

}
