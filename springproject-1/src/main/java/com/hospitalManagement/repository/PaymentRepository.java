package com.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospitalManagement.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
	@Query (value = "INSERT INTO payment_details (date) VALUES ('?') " , nativeQuery=true)
	void insertDate(String date);
	
}