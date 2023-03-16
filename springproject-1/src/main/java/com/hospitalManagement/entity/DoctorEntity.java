package com.hospitalManagement.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Doctor_table")

public class DoctorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Doctor_id")
	private int doctor_id;

	@Column(name = "doctor_name")
	private String doctor_name;

	@Column(name = "specialist")
	private String specialist;

	@Column(name = "mobile_number")
	private long mobile_number;

	@Column(name = "status")
	private String status;

	@Column(name = "amount")
	private int amount;

	@Column(name = "no_of_appoinment")
	private int no_of_appoinment;

	public DoctorEntity() {

	}

	public DoctorEntity (int doctor_id, String doctor_name, String specialist ,long mobile_number ,  String status ,int amount , int no_of_appoinment  ) {
		this.doctor_id =doctor_id;
		this.doctor_name = doctor_name;
		this.specialist = specialist;
		this.mobile_number = mobile_number;
		this.status = status;
		this.amount = amount;
		this.no_of_appoinment = no_of_appoinment;
	}	

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNo_of_appoinment() {
		return no_of_appoinment;
	}

	public void setNo_of_appoinment(int no_of_appoinment) {
		this.no_of_appoinment = no_of_appoinment;
	}

}
