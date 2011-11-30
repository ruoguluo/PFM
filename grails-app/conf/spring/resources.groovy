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
}
