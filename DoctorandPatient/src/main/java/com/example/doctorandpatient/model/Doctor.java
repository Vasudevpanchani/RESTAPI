package com.example.doctorandpatient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor_table")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private long id;
	@Column(name = "doctor_name")
	private String name;
	@Column(name = "doctor_speciality")
	private String speciality;
	@Column(name = "doctor_hospital")
	private String hospital;

	@OneToOne
	private Patient patient;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", speciality=" + speciality + ", hospital=" + hospital
				+ ", patient=" + patient + "]";
	}

}
