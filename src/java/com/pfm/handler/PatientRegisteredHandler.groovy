package com.pfm.handler;

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;

public class PatientRegisteredHandler extends EventHandler {

	def process(Map props){

		event.eventName = EventName.Registered
		
		patient.roomID = props['Room_ID']
		
//		log.info("PatientRegisteredHandler")
		
//		log.info("patient id is ${patientId}")
//		def patient = Patient.findByPatientID(patientId)
//		log.info("patient is ${patient}")
//		
//		patient.appendEvent(event)
//		patient.save()
		
		return null;
	}

}
