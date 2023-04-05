package com.hospitalManagement.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.HistoryEntity;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {
	 @Modifying
	  @Transactional
	@Query (value = "INSERT INTO history_table (name,doctor_name,specialist,date,patient_id) VALUES (?1,?2,?3,?4,?5)",nativeQuery=true)
	void insertDate(String name,String doctor_name,String specialist,String date ,int patient_id);
	 
	@Query (value = "select *from history_table where patient_id =?1" , nativeQuery= true)
	List <Map<String,Object>>historyDetails(int patient_id);
	
	
}