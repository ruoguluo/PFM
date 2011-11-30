package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class WaitForOrderExecutionHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForConsultation
		
		def patient = Patient.findByPatientID(patientId)
		log.info("patient is ${patient}")
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_CONSULTATION
		
		patient.setCurrentState(patientState,null)
		patient.appendEvent(event)
		patient.save()
		
		return null;
	}

}
