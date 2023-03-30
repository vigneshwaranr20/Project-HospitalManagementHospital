package com.hospitalManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_details")

public class PatientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "Patient_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "disease")
	private String disease;

	

	@Column(name = "age")
	private int age;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile_number")
	private long mobile_number;

	@Column(name = "create_password")
	private String create_password;

	@Column(name = "confirm_password")
	private String confirm_password;

	public PatientEntity() {

	}

	public PatientEntity(int id, String name, String disease, int age, String address,
			long mobile_number, String create_password, String confirm_password) {
		this.id = id;
		this.name = name;
		this.disease = disease;
		
		this.age = age;
		this.address = address;
		this.mobile_number = mobile_number;
		this.create_password = create_password;
		this.confirm_password = confirm_password;
	}

	public long getId() {
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

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getCreate_password() {
		return create_password;
	}

	public void setCreate_password(String create_password) {
		this.create_password = create_password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

}
