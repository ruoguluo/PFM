package com.pfm.handler

import org.apache.commons.logging.LogFactory;

import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;

abstract class EventHandler {
	
	static final log = LogFactory.getLog(this)
	
	def Event event
	def Patient patient
	def String patientId
	
	def void handle(Map props){

		pre_process(props)
		process(props)
		post_process()
		
		log.info("~~~event ${event.eventName} is processed~~~")
	}
	
	def void pre_process(props){
		event = new Event()
		event.eventAttrs = props
		event.timeStamp = createTimeStamp(props['timestamp'])
		patientId = props['Patient_ID']
		patient = Patient.findByPatientID(patientId)
		if (!patient){
			patient = new Patient(patientID:patientId)
		}
	}
	
	def void post_process(){
		patient.appendEvent(event)
		patient.save()
	}
	
	def abstract process(Map props)
	
	def Date createTimeStamp(String ts){
		if (ts.startsWith("*")){
			def c= new GregorianCalendar()
			def year = c.get(Calendar.YEAR).toString()
			def month = (c.get(Calendar.MONTH)+1).toString().padLeft(2,'0')
			def date = c.get(Calendar.DATE).toString()
			ts=ts.replace("*", "${year}-${month}-${date}")
		}
		return Date.parse ("yyyy-MM-dd/HH-mm-ss", ts)
	}
	
	def void updatePatientState(PatientState ps){
		patient.setCurrentState(ps,createTimeStamp(event.eventAttrs['timestamp']))
	}
	
}
