package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class OrderRequestHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.OrderRequest
//		def patient = Patient.findByPatientID(patientId)
//		patient.appendEvent(event)
//		patient.save()
		
		return null;
	}

}
