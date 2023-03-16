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
	private int history_id;

	@Column(name = "doctor_id")
	private int doctor_id;

	@Column(name = "patient_id")
	private int patient_id;

	@Column(name = "specialist")
	private String specialist;

	@Column(name = "no_of_appointment")
	private int no_of_appointment;

	@Column(name = "payment_id")
	private int payment_id;

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public int getNo_of_appointment() {
		return no_of_appointment;
	}

	public void setNo_of_appointment(int no_of_appointment) {
		this.no_of_appointment = no_of_appointment;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	@Override
	public String toString() {
		return "HistoryEntity [history_id=" + history_id + ", doctor_id=" + doctor_id + ", patient_id=" + patient_id
				+ ", specialist=" + specialist + ", no_of_appointment=" + no_of_appointment + ", payment_id="
				+ payment_id + "]";
	}



}
