package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class WaitForOrderExecutionHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForOrderExecution
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_ORDER_EXECUTION
//		patient.setCurrentState(patientState,null)
		updatePatientState(patientState)
		return null;
	}

}
