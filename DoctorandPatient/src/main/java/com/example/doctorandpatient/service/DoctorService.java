package com.example.doctorandpatient.service;

import java.util.List;

import com.example.doctorandpatient.model.Doctor;

public interface DoctorService {
	
	List<Doctor> getAllDetails();
	Doctor addDoctor(Doctor doctor);
	Doctor deleteDoctor(long id);
	Doctor updateDoctor(Doctor doctor);
	Doctor addDoctorDataByIdandPatientId(long doctorid,long patientid);
	Doctor DoctorFindById(long id);
}
