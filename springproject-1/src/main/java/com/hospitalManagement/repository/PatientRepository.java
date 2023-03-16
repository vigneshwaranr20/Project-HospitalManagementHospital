package com.hospitalManagement.repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.HistoryEntity;
public interface PatientRepository extends JpaRepository<HistoryEntity ,Integer> {
	
	@Query(nativeQuery = true,value="Select * from patient_details where mobile_number = '7397577541'")
	public List <Map<String,Object>> queryResult();

}