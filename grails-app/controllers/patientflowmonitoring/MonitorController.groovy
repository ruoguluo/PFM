package patientflowmonitoring

class MonitorController {
	
	def scaffold = true
	static navigation = [
		[group:'tabs',action:'showGrails', title:"Grails",order:20],
		[action:'showTestDriverPage',title:'Test',order:30]
		
	]
	
	def showTestDriverPage={
		redirect(uri:"/msgList.gsp")
	}
	
	def showGrails={
		redirect(uri:"/index.gsp")
	}
	
}
