package com.hospitalManagement.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

	@Query(nativeQuery = true, value = "Select * from patient_details where mobile_number = '7397577541'")
	public List<Map<String, Object>> queryResult();

	  @Modifying
	  @Transactional
	  @Query(value ="INSERT INTO patient_details(mobile_number, create_password,confirm_password) VALUES(?1,?2,?3)", nativeQuery = true) 
	  void insertPatient( long mobile_number, String create_password, String confirm_password);

}