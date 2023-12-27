package com.example.doctorandpatient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_table")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private long id;
	@Column(name = "patient_name")
	private String name;
	@Column(name = "patient_number")
	private String number;
	
	public Patient(long id, String name, String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}
	
	public Patient() {
		super();
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", number=" + number + "]";
	}
	
}
