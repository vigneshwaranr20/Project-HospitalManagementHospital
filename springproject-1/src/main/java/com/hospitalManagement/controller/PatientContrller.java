package com.hospitalManagement.controller;

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
     
	@PostMapping("/Login")
	@ResponseBody
	public String loginData(@RequestBody Map<String,Object> Register)
	{
		Map<String,Object> login=patientService.getAllData(Register);
		String rs=new Gson().toJson(login);
		logger.info(rs);
		return rs;
	}
	@GetMapping("/PatientDetails")
	public String listUsers4() {
		return "PatientDetails";
	}
    
	@PostMapping("/AllDoctorsDetails")
	@ResponseBody
	public String patient() {
		logger.info("data");
		Map<String, Object> allList = patientService.getData();
//		logger.info('Map allList');
		String data = new Gson().toJson(allList);
		logger.info(data);
		return data;
	}
	
	@PostMapping("/Appointments")
	@ResponseBody
	public String Schedule (Map <String ,Object> Appointment) {
		Map<String,Object> App=patientService.getAppointmentdata(Appointment);		
		return null;
		
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