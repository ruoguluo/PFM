package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class WaitForConsultationHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForConsultation
		
//		def patient = Patient.findByPatientID(patientId)
//		log.info("patient is ${patient}")
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_CONSULTATION
		updatePatientState(patientState)
		//patient.setCurrentState(patientState,createTimeStamp(props['timestamp']))
//		patient.appendEvent(event)
//		patient.save()
		
		return null;
	}

}
