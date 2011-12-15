package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;
import patientflowmonitoring.Discharge;

class DischargeHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.Discharge
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.DISCHARGED
//		patient.setCurrentState(patientState,null)
		patient.roomID = ""
		updatePatientState(patientState)
		
		def Discharge discharge = new Discharge()
		discharge.setTimeStamp(createTimeStamp(props['timestamp']))
		discharge.save()
		
		return null;
	}

}
