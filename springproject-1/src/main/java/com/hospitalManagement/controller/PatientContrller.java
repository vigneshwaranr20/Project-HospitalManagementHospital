package com.hospitalManagement.controller;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hospitalManagement.serviceimpl.PatientServiceImpl;
 
@Controller
public class PatientContrller {
	
	private static final Logger logger = LoggerFactory.getLogger(PatientContrller.class);
	
	@Autowired
	PatientServiceImpl patientService;
	
	
	@PostMapping("/sample")
	@ResponseBody
	public String sampleMethod() {
		logger.info("Sample Method");
		return "String";
	}
	
	@GetMapping("/patients")
	public String listUsers(Model model) {
		model.addAttribute("patients",patientService.getAllPatients());
		return "patients";
	}
	
	@GetMapping("/Appointment")
	public String listUsers1(Model model) {
		model.addAttribute("Appointment",patientService.getAllPatients());
		return "Appointment";
	}
	
	@GetMapping("/Register")
	public String listUsers2(Model model) {
		model.addAttribute("Register",patientService.getAllPatients());
		return "Register";
	}
	
	@GetMapping("/Login")
	public String listUsers3(Model model) {
		model.addAttribute("Login",patientService.getAllPatients());
		return "Login";
	}
	
	@GetMapping("/PatientDetails")
	public String listUsers4(Model model) {
		model.addAttribute("PatientDetails",patientService.getAllPatients());
		return "PatientDetails";
	}
	
	
	@PostMapping("/doctor")
	@ResponseBody
	public String patient()
	{
	logger.info("output");
	Map<String, Object> history= patientService.getAllPatients();
	String data = new Gson().toJson(history);
	return data;
	}
	@PostMapping("/check")
	@ResponseBody
	public String queryResult()
	{
	logger.info("check");
	Map<String, Object> user= patientService.getPatients();
	String data2 = new Gson().toJson(user);
	return data2;
	}
}