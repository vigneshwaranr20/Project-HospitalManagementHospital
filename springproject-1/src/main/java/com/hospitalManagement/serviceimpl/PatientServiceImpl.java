package com.hospitalManagement.serviceimpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalManagement.entity.HistoryEntity;
import com.hospitalManagement.repository.PatientRepository;


@Service
public class PatientServiceImpl {
	
	
	@Autowired
	PatientRepository patientRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);                
	

	public Map<String,Object> getAllPatients(){
		
		Map<String , Object> op = new HashMap<>();
		List<HistoryEntity> gh = patientRepository.findAll();
		op.put("history_table", gh);
		return op;
	}
	
	public Map<String,Object> getPatients(){
		Map <String,Object> p = new HashMap<>();
		List <Map<String,Object>> findData = patientRepository.queryResult();
		p.put("patient_details", findData);
		return p;
	}

}







