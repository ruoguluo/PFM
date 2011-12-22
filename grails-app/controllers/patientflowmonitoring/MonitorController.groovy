package patientflowmonitoring

class MonitorController {
	
	def scaffold = true
	static navigation = [
		[group:'tabs',action:'showGrails', title:"Grails",order:20]
	]
	
	def showGrails={
		redirect(uri:"/index.gsp")
	}
	
}
