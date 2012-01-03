package patientflowmonitoring

import java.util.Map
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes;
import org.springframework.context.*;
import com.pfm.handler.EventHandler
import grails.plugin.jms.*
import patientflowmonitoring.Bed.BedStatus;


class MessageService {
	// MessageService is listening to the JMS queue
	
	def jmsService

    static transactional = true
	static expose = ['jms']
	
	def patientService
	def bedService
	def monitorService
	def grailsApplication
	
    def serviceMethod() {

    }
	
	@Queue(name='PFM_Event')
	def PFM_EventArrive(msg){
		log.info('what I received is ' + msg)
		def ctx = grailsApplication.mainContext
		def props = processMsg(msg)
		EventHandler h = ctx.getBean (props['event'].toLowerCase()+"Handler")
		log.info("h=" + h)
		h.handle (props)
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

}

