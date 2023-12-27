package com.example.doctorandpatient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctorandpatient.exception.DoctorNotFoundException;
import com.example.doctorandpatient.model.Doctor;
import com.example.doctorandpatient.model.Patient;
import com.example.doctorandpatient.repository.DoctorRepository;
import com.example.doctorandpatient.repository.PatientRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public List<Doctor> getAllDetails() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor deleteDoctor(long id) {
		Doctor doctor = doctorRepository.findById(id).orElse(null);
		doctorRepository.deleteById(id);
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor editDoctor=doctorRepository.findById(doctor.getId()).orElse(null);
		if(editDoctor!=null) {
			editDoctor.setName(doctor.getName());
			editDoctor.setSpeciality(doctor.getSpeciality());
			editDoctor.setHospital(doctor.getHospital());
			doctorRepository.save(editDoctor);
			return editDoctor;
		}
		return null;
	}

	@Override
	public Doctor addDoctorDataByIdandPatientId(long doctorid, long patientid) {
		Doctor doctor=doctorRepository.findById(doctorid).get();
		Patient patient=new Patient();
		patient.setId(patientid);
		doctor.setPatient(patient);
		
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor DoctorFindById(long id) {
		return doctorRepository.findById(id).orElseThrow(()-> new DoctorNotFoundException("Doctor Data not found in database."));
	}
	
	
}
