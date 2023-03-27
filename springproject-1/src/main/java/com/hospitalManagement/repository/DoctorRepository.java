package com.hospitalManagement.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.DoctorEntity;


public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
	
	 @Query (value = "Select * From doctor_table" , nativeQuery = true)
	 public List<Map<String , Object>> AllDoctorsDetails();
	 
	 @Query (value ="INSERT INTO doctor_table (Doctor_name.specialist)Values ('?','?')",nativeQuery=true)
	 void insertData (String Doctor_name,String specialist );
	 
}