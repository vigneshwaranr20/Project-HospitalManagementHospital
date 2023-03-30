package com.hospitalManagement.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.DoctorEntity;


public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
	
	 @Query (value = "Select * From doctor_table" , nativeQuery = true)
	 public List<Map<String , Object>> AllDoctorsDetails();
	 
	 @Query (value ="select doctor_id ,doctor_name  from doctor_table where specialist = ?",nativeQuery=true)
	 public List<Map<String , Object>> fetchData (String specialist );
	 
	 @Query (value = "select distinct specialist from doctor_table ", nativeQuery = true)
	 public List <String > getData();
	 
}