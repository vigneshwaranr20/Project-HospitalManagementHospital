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
import com.hospitalManagement.repository.HistoryRepository;
import com.hospitalManagement.repository.PatientRepository;

@Service
public class PatientServiceImpl {

	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	DoctorRepository doctorRepository ;
	
	@Autowired
	HistoryRepository historyRepository;

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
			
		Map<String,Object> check=patientRepository.getData(Number, createpassword);
			Map<String,Object> get = new HashMap<>();
			logger.info("Check" + check);
			if(check.isEmpty())
			{
				get.put("Sucess" ,check);
				
			}
			else
			{
				get.put("Number", check.get("mobile_number"));
				get.put("status", "201");
				logger.info("map" + get);
			}
			return get;
		}
		
		public Map<String,Object> getData()
		{
			List<Map<String, Object>> result = doctorRepository.AllDoctorsDetails();
			Map <String ,Object> data = new HashMap <>();
			//String dataString = result.toString();
			//logger.info("check"+dataString);
			data.put("doctor",result);
			logger.info("check"+data);
			return data;
		}
		
		public Map<String,Object> getAppointmentdata(@RequestBody Map<String,Object> Appointments)
	    {
			
		  long PatientMobileNumber = Long.valueOf((String)Appointments.get("mobile_number"));  
	      String PatientName = (String) Appointments.get("name");
	      String Patientdisease = (String) Appointments.get("disease");
			/* String PatientGender = (String) Appointments.get("gender"); */
	      String PatientAge = (String) Appointments.get("age");
	      String PatientAddress = (String) Appointments.get("address");
	      String DoctorName = (String) Appointments.get("doctor_name");
	      String Specialist = (String) Appointments.get("Specialist");
	      String date = (String) Appointments.get("date");
	      
	      List<Map<String, Object>> patientResult = patientRepository.getPatientId(PatientMobileNumber);
	          
	      int patient_id = (int) patientResult.get(0).get("patient_id");
	      logger.info("checkresult" +patient_id); 
	      
	     
	      
          logger.info("age = " + PatientAge);
			/* long Number=Long.valueOf(PatientMobileNumber); */
			 
	      int age=Integer.valueOf(PatientAge);
	      
	        patientRepository.insertData(PatientName, Patientdisease, age, PatientAddress, DoctorName, Specialist, date, PatientMobileNumber);
			historyRepository.insertDate(PatientName,DoctorName,Specialist,date,patient_id); 
	        logger.info("vky"+ date);
	        
	        
	        
	        
	      Map<String , Object> p = new HashMap<>();
	      p.put("success",patientResult);  
	        logger.info("Check"+ p);
	        return p;
	         
	    }
		
		public Map<String,Object> getDoctordata(Map <String , Object> schedule)
		{
			
			 String specialist = (String) schedule.get("specialist");
			
			 logger.info("service "+ specialist);
			List< Map<String,Object>> result=doctorRepository.fetchData(specialist);
			 Map<String , Object> value = new HashMap<>();
			 for (int i=0 ; i<result.size();i++) {
				 int Doctor_id = (int) result.get(i).get("doctor_id");
				
				 String Doctor_name = (String) result.get(i).get("doctor_name");
				 logger.info("fayaz" +Doctor_name);
				  logger.info( "output" +result.get(i));
					value.put(String.valueOf(Doctor_id), Doctor_name);
					
				 
			 }
			  logger.info("output" + value );
		      return value;	
		}
	      
		public List<String>getSpecialistData ()
		{
			List<String> result=doctorRepository.getData();	
			logger.info(""+result);
			return result;
		}
		
		public Map<String ,Object> getHistory1 (Map<String, Object> showsummery){
			
			String cusNumber = (String) showsummery.get("mobile_number");
			long Number=Long.valueOf(cusNumber);
			List<Map<String,Object>>showpatient=patientRepository.getPatientId(Number);
			int patient_id = (int) showpatient.get(0).get("patient_id");
			logger.info("vicky" + patient_id);
			
			
		 Map<String ,Object> resultdata	=new HashMap<>();
		 List<Map<String,Object>>patientDetails= historyRepository.historyDetails(patient_id);
		 resultdata.put("check", patientDetails);
		 logger.info("resultChecking"+resultdata);
		 return resultdata;
		}
		
		
		
		
		
		
		
		

	      
	    
}
