package com.example.doctorandpatient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.doctorandpatient.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Query("SELECT d FROM Doctor as d ORDER BY d.id ASC")
	List<Doctor> findAll();
}
