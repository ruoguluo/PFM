package com.pfm.handler

import patientflowmonitoring.Bed
import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName

class TriageScoreHandler extends EventHandler {
	
	@Override
	public Object Handle(Map props) {
		
		def patientId = props['Patient_ID']
		log.info(patientId + " arrived TriageScoreHandler")
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.NEW
		patientState.stateAttributes = ['tester':'lrg']
		if(patientState.save()){
			log.info('patientState saved')
		}else{
			log.info('patientState not saved')
		}
		
		def patient = new Patient(patientID:patientId)
		patient.currentState = patientState
		if(patient.save()){
			log.info('patient saved')
		}else{
			log.info('patient not saved')
		}
		
		def bed = new Bed(bedId:'abcd')
		println bed.save()
		
		return null;
	}

}
