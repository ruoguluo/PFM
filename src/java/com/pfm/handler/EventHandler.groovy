package com.pfm.handler

import org.apache.commons.logging.LogFactory;

import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;

abstract class EventHandler {
	
	static final log = LogFactory.getLog(this)
	
	def event
	def patient
	def patientId
	
	def Handle(Map props){
		event = new Event()
		event.eventAttrs = props
		patientId = props['Patient_ID']
		patient = Patient.findByPatientID(patientId)
		if (patient){
			patient = patient.merge()
		}
		process(props)
		
		patient.appendEvent(event)
		patient.save()
		//patient = patient.merge()
//		try{
//			patient.save()
//		}catch (org.hibernate.NonUniqueObjectException e){
//			log.info("NonUniqueObjectException")
//			patient.merge()
//		}
//		
//		if (event.eventName == EventName.Triage){
//			patient.save()
//		}else{
//			patient = patient.merge()
//			patient.save()
//		}
		
		log.info("~~~event ${event.eventName} is processed~~~")
	}
	
	def abstract process(Map props)
}
