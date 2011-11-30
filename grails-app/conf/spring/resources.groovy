// Place your Spring DSL code here

import org.apache.activemq.ActiveMQConnectionFactory

beans = {
	
	jmsConnectionFactory(ActiveMQConnectionFactory){
		brokerURL = "tcp://localhost:61616"
	}
	
	defaultJmsTemplate(org.springframework.jms.core.JmsTemplate){
		connectionFactory = ref("jmsConnectionFactory")
	}
	
	handler1(com.pfm.handler.Handler1){
		
	}
	
	triagescoreHandler(com.pfm.handler.TriageScoreHandler){}
	patientregisteredHandler(com.pfm.handler.PatientRegisteredHandler){}
	waitforconsultationHandler(com.pfm.handler.WaitForConsultationHandler){}
	waitforconsultationcompletedHandler(com.pfm.handler.WaitForConsultationCompletedHandler){}
	consultationstartedHandler(com.pfm.handler.ConsultationStartedHandler){}
	orderrequestHandler(com.pfm.handler.OrderRequestHandler){}
	ConsultationCompleted(com.pfm.handler.ConsultationCompletedHandler){}
	WaitForOrderExecution(com.pfm.handler.WaitForOrderExecutionHandler){}
	OrderExecutionCompleted(com.pfm.handler.OrderExecutionCompletedHandler){}
	BedRequest(com.pfm.handler.BedRequestHandler){}
	PatientAdmittedWithNoBed(com.pfm.handler.PatientAdmittedWithNoBedHandler){}
	WaitForBed(com.pfm.handler.WaitForBedHandler){}
	Discharge(com.pfm.handler.DischargeHandler){}
	PatientAdmittedWithBed(com.pfm.handler.PatientAdmittedWithBedHandler){}
	WaitedForBedCompleted(com.pfm.handler.WaitedForBedCompletedHandler){}
	PatientTransportRequest(com.pfm.handler.PatientTransportRequestHandler){}
	WaitForTransport(com.pfm.handler.WaitForTransportHandler){}
	WaitForTransportCompleted(com.pfm.handler.WaitForTransportCompletedHandler){}
	PatientTransportStarted(com.pfm.handler.PatientTransportStartedHandler){}
	PatientTransportCompleted(com.pfm.handler.PatientTransportCompletedHandler){}
}
