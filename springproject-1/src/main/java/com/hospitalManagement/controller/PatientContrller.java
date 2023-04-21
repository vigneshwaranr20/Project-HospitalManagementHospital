package com.hospitalManagement.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hospitalManagement.repository.DoctorRepository;
import com.hospitalManagement.repository.HistoryRepository;
import com.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.serviceimpl.PatientServiceImpl;

@Controller
public class PatientContrller {

	private static final Logger logger = LoggerFactory.getLogger(PatientContrller.class);

	@Autowired
	PatientServiceImpl patientService;

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	HistoryRepository paymentRepository;
	
	@Autowired
	DoctorRepository doctorRepository;

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
	@CrossOrigin
	@PostMapping("/Register")
	@ResponseBody
	public String insertData(@RequestBody Map<String, Object> patients) {
		logger.info("patients" + patients);
		Map<String,Object> data= patientService.getAllPatients(patients);
		String rs=new Gson().toJson(data);
		logger.info("Check"+ rs);
		return rs;
		
	}


	@GetMapping("/Login")
	public String listUsers3() {
		return "Login";
	}
    @CrossOrigin
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
    @CrossOrigin
	@PostMapping("/AllDoctorsDetails")
	@ResponseBody
	public String patient() {
		logger.info("data");
		Map<String, Object> allList = patientService.getData();
//		logger.info('Map allList');
		String data = new Gson().toJson(allList);
		logger.info("CONTROL CHECK"+data);
		return data;
	}
	
	@PostMapping("/submitAppointment")
	@ResponseBody
	public String Schedule (@RequestBody Map<String ,Object> appointment) {
		logger.info ("Appointment " + appointment.toString());
		Map<String,Object> App=patientService.getAppointmentdata(appointment);	
		String data2 = new Gson().toJson(App);
		logger.info("siva"+data2);
		return data2;
		
	}
	
	@PostMapping("/getDoctordata")
	@ResponseBody
	public String fetch (@RequestBody  Map<String , Object>  dr ) {
		logger.info("input " + dr);
		Map<String,Object> app=patientService.getDoctordata(dr);
		String doctorData=new Gson().toJson(app);
		logger.info("result"+doctorData);
		return doctorData;	
		
	}
	
	@PostMapping("/getSpecialistdata")
	@ResponseBody
	public String fetch1 () {		
		List<String> app=patientService.getSpecialistData();
		
		String specialist=new Gson().toJson(app);
		return specialist;	
		
	}
	
	@PostMapping("/getHistoryData")
	@ResponseBody
	public String getHistory(@RequestBody Map<String,Object> showsummery)
	{
		Map<String,Object>patientData=patientService.getHistory1(showsummery);
		String patientHistory=new Gson().toJson(patientData);
	
		return patientHistory;
		
	}
	
	/*
	 * @PostMapping("/doctor")
	 * 
	 * @ResponseBody public String patient() { logger.info("output"); Map<String,
	 * Object> history = patientService.getAllPatients(); String data = new
	 * Gson().toJson(history); return data; } //
	 *///	@PostMapping("/check")
//	@ResponseBody
//	public String queryResult() {
//		logger.info("check");
//		Map<String, Object> user = patientService.getPatients();
//		String data2 = new Gson().toJson(user);
//		return data2;
//	}
	
	
}