package com.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Payment_details")

public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private int payment_id;

	@Column(name = "amount")
	private int amount;

	@Column(name = "date")
	private String date;

	@Column(name = "patient_id")
	private int patient_id;
	
	

	public PaymentEntity() {

	}

	public PaymentEntity (int payment_id, int amount, String date ,int patient_id  ) {
		this.payment_id =payment_id;
		this.amount = amount;
		this.date = date;
		this.patient_id = patient_id;
	}	
	

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
}
