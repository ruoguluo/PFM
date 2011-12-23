// Place your Spring DSL code here

import org.apache.activemq.ActiveMQConnectionFactory

beans = {
	
	jmsConnectionFactory(ActiveMQConnectionFactory){
		brokerURL = "tcp://localhost:61616"
	}
	
	defaultJmsTemplate(org.springframework.jms.core.JmsTemplate){
		connectionFactory = ref("jmsConnectionFactory")
	}
	
	triagescoreHandler(com.pfm.handler.TriageScoreHandler){}
	patientregisteredHandler(com.pfm.handler.PatientRegisteredHandler){}
	waitforconsultationHandler(com.pfm.handler.WaitForConsultationHandler){}
	waitforconsultationcompletedHandler(com.pfm.handler.WaitForConsultationCompletedHandler){}
	consultationstartedHandler(com.pfm.handler.ConsultationStartedHandler){}
	orderrequestHandler(com.pfm.handler.OrderRequestHandler){}
	consultationcompletedHandler(com.pfm.handler.ConsultationCompletedHandler){}
	waitfororderexecutionHandler(com.pfm.handler.WaitForOrderExecutionHandler){}
	orderrequestcompletedHandler(com.pfm.handler.OrderRequestCompletedHandler){}
	orderexecutioncompletedHandler(com.pfm.handler.OrderExecutionCompletedHandler){}
	bedrequestHandler(com.pfm.handler.BedRequestHandler){}
	patientadmittedwithnobedHandler(com.pfm.handler.PatientAdmittedWithNoBedHandler){}
	waitforbedHandler(com.pfm.handler.WaitForBedHandler){}
	dischargeHandler(com.pfm.handler.DischargeHandler){}
	patientadmittedwithbedHandler(com.pfm.handler.PatientAdmittedWithBedHandler){}
	waitedforbedcompletedHandler(com.pfm.handler.WaitedForBedCompletedHandler){}
	patienttransportrequestHandler(com.pfm.handler.PatientTransportRequestHandler){}
	waitfortransportHandler(com.pfm.handler.WaitForTransportHandler){}
	waitfortransportcompletedHandler(com.pfm.handler.WaitForTransportCompletedHandler){}
	patienttransportstartedHandler(com.pfm.handler.PatientTransportStartedHandler){}
	patienttransportcompletedHandler(com.pfm.handler.PatientTransportCompletedHandler){}
}
