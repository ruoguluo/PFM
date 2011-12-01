package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.Event.EventName;

class WaitForConsultationCompletedHandler extends EventHandler {

	@Override
	public Object process(Map props) {

		event.eventName = EventName.WaitForConsultationCompleted
//		def patient = Patient.findByPatientID(patientId)
//		patient.appendEvent(event)
//		patient.save()
		
		return null;
	}

}
