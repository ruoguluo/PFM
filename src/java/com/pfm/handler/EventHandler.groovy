package com.pfm.handler

import org.apache.commons.logging.LogFactory;

import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;

abstract class EventHandler {
	
	static final log = LogFactory.getLog(this)
	
	def event = new Event()
	def patientId
	
	def Handle(Map props){
		
		event.eventAttrs = props
		patientId = props['Patient_ID']
		
		process(props)
		log.info("event ${event.eventName} is processed")
	}
	
	def abstract process(Map props)
}
