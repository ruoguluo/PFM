package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class PatientTransportCompletedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientTransportCompleted
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_BED
//		patient.setCurrentState(patientState,null)
		updatePatientState(patientState)
		patient.roomID = props['Unit_ID']
		return null;
	}

}
