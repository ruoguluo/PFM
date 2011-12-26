package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Bed
import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.Arrival;

class TriageScoreHandler extends EventHandler {
	
	def process(Map props){
		
		event.eventName = EventName.Triage  // assignment the event name value, which must be a predefined value in Event.EventName
		
		log.info(patientId + " arrived TriageScoreHandler") // for logging purpose only
		
		def patientState = new PatientState()				// Since this event will cause the state change of the patient, the following three lines are for updating patient state
		patientState.stateName = PatientStateName.NEW
		updatePatientState(patientState)
		
		def Arrival arrival = new Arrival()					// This event will add a new Arrival object into the PFM system for statistics. 
		arrival.setTimeStamp(createTimeStamp(props['timestamp']))
		arrival.save()

		return null;	//No return value is needed
	}

}
