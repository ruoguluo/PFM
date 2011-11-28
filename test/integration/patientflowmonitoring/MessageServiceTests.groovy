package patientflowmonitoring

import grails.test.*

class MessageServiceTests extends GroovyTestCase {
	
//	def messageService
	def jmsService
	
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }
	
	void testSendPFMMsg(){
		jmsService.send(queue:'PFM_Event','PFM event test1')
	}

//    void testSomething() {
//
//    }
	
//	void testWriteToQueue(){
//		messageService.sendMessage()
//	}
}
