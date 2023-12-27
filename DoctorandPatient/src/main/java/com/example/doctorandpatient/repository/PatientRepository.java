package com.example.doctorandpatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.doctorandpatient.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
}
