package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class PatientTransportStartedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientTransportStarted
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_TRANSPORT
//		patient.setCurrentState(patientState,null)
		updatePatientState(patientState)
		
		return null;
	}

}
