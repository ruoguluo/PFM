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
//		patientState.stateAttributes = ['tester':'lrg']
//		if(patientState.save()){
//			log.info('patientState saved')
//		}else{
//			log.info('patientState not saved')
//		}
		
		def patient = new Patient(patientID:patientId)
		//patient.currentState = patientState
		patient.setCurrentState(patientState, null)
		patient.appendEvent(event)
		
		if(patient.save()){
			log.info('patient saved')
		}else{
			log.info('patient not saved')
		}
		
//		def bed = new Bed(bedId:'abcd')
//		println bed.save()
		
		return null;
	}

}
