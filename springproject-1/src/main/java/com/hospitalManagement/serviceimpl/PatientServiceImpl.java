package com.hospitalManagement.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hospitalManagement.entity.PatientEntity;
import com.hospitalManagement.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	@Autowired
	PatientRepository patientRepository;

	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	public Map<String, Object> getAllPatients() {

		Map<String, Object> op = new HashMap<>();
		List<PatientEntity> gh = patientRepository.findAll();
		op.put("history_table", gh);
		return op;
	}

	public Map<String, Object> getPatients() {
		Map<String, Object> p = new HashMap<>();
		List<Map<String, Object>> findData = patientRepository.queryResult();
		p.put("patient_details", findData);
		return p;
		
	}

	
	public Map<String , Object> getAllPatients(@RequestBody Map<String, Object> patients)
	{
		Map<String ,Object> cs=new HashMap<>();
		String number = (String) patients.get("mobile_number");
		
	
		String createpassword = (String) patients.get("create_password");
		String confirmpassword = (String) patients.get("confirm_password");


		Long number2 = Long.valueOf(number);
//		logger.info("Number" + number2);
		List<Map<String, Object>> getData =patientRepository.getPhoneNumber(number2);
	
	       logger.info("result"+number2);
	logger.info("check" + number);
	if(getData.isEmpty())
	{
		patientRepository.insertPatient(number2, createpassword, confirmpassword);
     	cs.put("Success", getData);
	}
	else {
	cs.put("status","201");
	}
	return cs;
	}
}	

