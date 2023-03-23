package com.hospitalManagement.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hospitalManagement.entity.PatientEntity;
import com.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.serviceimpl.PatientServiceImpl;

@Controller
public class PatientContrller {

	private static final Logger logger = LoggerFactory.getLogger(PatientContrller.class);

	@Autowired
	PatientServiceImpl patientService;

	@Autowired
	PatientRepository patientRepository;

	@PostMapping("/sample")
	@ResponseBody
	public String sampleMethod() {
		logger.info("Sample Method");
		return "String";
	}

	@GetMapping("/patients")
	public String listUsers() {
		return "patients";
	}

	@GetMapping("/Appointment")
	public String listUsers1() {
		return "Appointment";
	}

	@GetMapping("/Register")
	public String listUsers2() {
		return "Register";
	}
	@PostMapping("/Register")
	@ResponseBody
	public String insertData(@RequestBody Map<String, Object> patients) {
		Map<String,Object> data= patientService.getAllPatients(patients);
		String rs=new Gson().toJson(data);
		logger.info("Check"+ rs);
		return rs;
		
	}


	@GetMapping("/Login")
	public String listUsers3() {
		return "Login";
	}

	@GetMapping("/PatientDetails")
	public String listUsers4() {
		return "PatientDetails";
	}

//	@PostMapping("/doctor")
//	@ResponseBody
//	public String patient() {
//		logger.info("output");
//		Map<String, Object> history = patientService.getAllPatients();
//		String data = new Gson().toJson(history);
//		return data;
//	}
//
//	@PostMapping("/check")
//	@ResponseBody
//	public String queryResult() {
//		logger.info("check");
//		Map<String, Object> user = patientService.getPatients();
//		String data2 = new Gson().toJson(user);
//		return data2;
//	}
	
	
}