// Place your Spring DSL code here

import org.apache.activemq.ActiveMQConnectionFactory

beans = {
	
	jmsConnectionFactory(ActiveMQConnectionFactory){
		brokerURL = "tcp://localhost:61616"
	}
	
	defaultJmsTemplate(org.springframework.jms.core.JmsTemplate){
		connectionFactory = ref("jmsConnectionFactory")
	}
}
