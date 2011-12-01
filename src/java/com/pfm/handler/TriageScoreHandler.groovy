package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Bed
import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;

class TriageScoreHandler extends EventHandler {
	
	def process(Map props){
		
		event.eventName = EventName.Triage
		
		def patientId = props['Patient_ID']
		log.info(patientId + " arrived TriageScoreHandler")
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.NEW
		
		patient = new Patient(patientID:patientId)
		patient.setCurrentState(patientState, null)
		
		return null;
	}

}
