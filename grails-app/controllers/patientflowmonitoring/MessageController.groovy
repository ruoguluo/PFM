package patientflowmonitoring

class MessageController {
	
	def jmsService
	def scaffold = true
	
	def save = {
		jmsService.send(queue:'msg.new',params.body)
		jmsService.send(queue:'PFM_Event',params.body)
		flash.message = "Message queued for persistence"
		redirect(action: "list")
	}
	
	def update = {
		jmsService.send(queue:'msg.update',[id:params.id,body:params.body])
		flash.message = "Message queued for update"
		redirect(action: "list")
	}
}
