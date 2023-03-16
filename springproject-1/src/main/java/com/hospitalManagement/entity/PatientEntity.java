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
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	
	@Column(name = "Patient_id")
    private int id ;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "disease")
    private String disease;
	
	@Column(name = "gender")
    private String gender;
	
	@Column(name = "age")
    private int age;
	
	@Column(name =  "address")
    private String address;
	
	@Column(name ="mobile_number")
	private long mobile_number;
	
	
	
	public PatientEntity() {
		
	}
	public PatientEntity (int id, String name, String disease , String gender ,String address , long mobile_number  ) {
	this.id =id;
	this.name = name;
	this.disease = disease;
	this.gender = gender;
	this.address = address;
	this.mobile_number = mobile_number;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
    
    
}
