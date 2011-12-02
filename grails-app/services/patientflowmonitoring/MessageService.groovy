package patientflowmonitoring

import java.util.Map
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes;
import org.springframework.context.*;
import com.pfm.handler.EventHandler
import grails.plugin.jms.*
import patientflowmonitoring.Bed.BedStatus;


class MessageService implements ApplicationContextAware{
	// MessageService is listening to the JMS queue
	
	def applicationContext
	
	def jmsService

    static transactional = true
	static expose = ['jms']
	
//	static destination = "PFM_Event"
//	static listenerCount = 5
	
	def patientService
	def bedService
	def monitorService
	def grailsApplication
	
	def void setApplicationContext(ApplicationContext appContext){
		
	}

    def serviceMethod() {

    }
	
	@Queue(name='PFM_Event')
	def PFM_EventArrive(msg){
		log.info('what I received is ' + msg)
		//ApplicationContext ctx = (ApplicationContext)session.getServletContext().getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT);
		def ctx = grailsApplication.mainContext
//		log.info("ctx=" + ctx);
		def props = processMsg(msg)
		EventHandler h = ctx.getBean (props['event'].toLowerCase()+"Handler")
		log.info("h=" + h)
		h.Handle (props)
	}
	
	def processMsg(msg){
		def parts = msg.split(',')
		def props = [:]
		parts.each{
			def t = it.split(":")
			props.put (t.getAt (0), t.getAt(1))
		}
		return props
	}
	
	
	
	
	
	
	@Queue(name='msg.new')
	def createMessage(msg){
			def messageInstance = new Message(body:msg)
			if (messageInstance.save(flash:true)){
				log.info "Save message: id = {$messageInstance.id}"
			} else {
				log.warn 'Could not save message'
			}
			
			def bed = new Bed(bedId:"abcd")		
			bed.status = BedStatus.EMPTY	
			if (bed.save(flash:true)){
				log.info "Save bed: id = {bed.bedId}"
			} else {
				log.warn 'Could not save bed'
			}
			
			return null;
	}

		
	
	
//	void sendMessage(){
//		sendQueueJMSMessage("PFM_Event",[userId:"rluo", content:"sendingTest"])
//	}
	
//	void onMessage(msg){
//		//triage messages and call other services
//	}
}

