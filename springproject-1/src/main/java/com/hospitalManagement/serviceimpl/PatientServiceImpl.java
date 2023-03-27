package com.hospitalManagement.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hospitalManagement.entity.PatientEntity;
import com.hospitalManagement.repository.DoctorRepository;
import com.hospitalManagement.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository ;

	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	public Map<String, Object> getAllPatients() {

		Map<String, Object> op = new HashMap<>();
		List<PatientEntity> gh = patientRepository.findAll();
		op.put("history_table", gh);
		return op;
	}

//	public Map<String, Object> getPatients() {
//		Map<String, Object> p = new HashMap<>();
//		List<Map<String, Object>> findData = patientRepository.queryResult();
//		p.put("patient_details", findData);
//		return p;
//		
//	}

	
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


		public Map<String,Object> getAllData(Map<String,Object> Register)
		{
			String number = (String) Register.get("mobile_number");		
			String createpassword = (String) Register.get("create_password");
			Long Number=Long.valueOf(number);
			
			List<Map<String,Object>> check=patientRepository.getData(Number, createpassword);
			Map<String,Object> get = new HashMap<>();
			logger.info("Check" + check);
			if(check.isEmpty())
			{
				get.put("Sucess" ,check);
				
			}
			else
			{
				get.put("status", "201");
				logger.info("map" + get);
			}
			return get;
		}
		
		public Map<String,Object> getData()
		{
			List<Map<String, Object>> result = doctorRepository.AllDoctorsDetails();
			Map <String ,Object> data = new HashMap <>();
			String dataString = result.toString();
			logger.info("check"+dataString);
			data.put("doctor",dataString);
			logger.info("check"+data);
			return data;
		}
		
		public Map<String,Object> getAppointmentdata(Map<String,Object> Appointments)
	    {
	      String PatientMobileNumber = (String) Appointments.get("mobile_number");   
	      String PatientName = (String) Appointments.get("name");
	      String Patientdisease = (String) Appointments.get("disease");
	      String PatientAge = (String) Appointments.get("age");
	      String date = (String) Appointments.get("Date_&_Time");
	      String PatientAddress = (String) Appointments.get("address");
	      String Specialist = (String) Appointments.get("Specialist");

	      Long Number=Long.valueOf(PatientMobileNumber);
	      int age=Integer.valueOf(PatientAge);
	      
	      
	      
	      
		return Appointments;
	    }
}
