package com.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history_table")

public class HistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "history_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "doctor_name")
	private String doctor_name;

	

	@Column(name = "specialist")
	private String specialist;

	@Column(name = "date")
	private String date;
	
	@Column (name = "patient_id")
	private int patient_id;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getpatient_id() {
		return patient_id;
	}

	public void setpatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

}