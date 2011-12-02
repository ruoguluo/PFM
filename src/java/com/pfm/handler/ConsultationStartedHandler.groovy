package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ConsultationStartedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ConsultationStarted
		
//		def patient = Patient.findByPatientID(patientId)
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_CONSULTATION
		patientState.stateAttributes.put ('ProviderId', props['Provider_ID'])
		updatePatientState(patientState)
//		patient.setCurrentState(patientState,null)
//		patient.appendEvent(event)
//		patient.save()
		
		return null;
	}

}
