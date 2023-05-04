package com.hospitalManagement.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {


	  @Modifying
	  @Transactional
	  @Query(value ="INSERT INTO patient_details(mobile_number, create_password,confirm_password) VALUES(?1,?2,?3)", nativeQuery = true) 
	  void insertPatient( long mobile_number, String create_password, String confirm_password);
	  
	  @Query(value = "SELECT * FROM patient_details WHERE mobile_number=?1", nativeQuery = true)
     List< Map<String,Object>> getPhoneNumber(long number);
	  
	  @Query(value="Select * from patient_details where mobile_number=?1 && create_password=?2 ",nativeQuery = true)
	   Map<String,Object> getData(long mobile_number, String create_password);
      
	  @Modifying
	  @Transactional
	  @Query(value ="UPDATE patient_details SET name =?1, disease = ?2, age = ?3,  address = ?4 ,doctor_name = ?5 , specialist = ?6 , date =?7 "
	  		+ "WHERE mobile_number = ?8", nativeQuery = true)
	  void  insertData (String name,String disease,int age,String address,String doctor_name,String specialist,String date , long number );
	  
	  
	  @Query(value="Select patient_id from patient_details where mobile_number = ?1" ,nativeQuery=true)
	  List<Map<String, Object>> getPatientId(long PatientMobileNumber);

}