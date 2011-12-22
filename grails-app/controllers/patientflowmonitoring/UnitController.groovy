package patientflowmonitoring

class UnitController {
	
	static navigation = [
		[group:'tabs',action:'showUnitPerformance', title:"Report",order:10],
	]
	
	def showUnitPerformance={
		
		def unit = params.id
		if (!unit){
			unit = "ED"
		}
		
		def c = Patient.createCriteria()
		
		def patientList = c.list{
			like ("roomID", unit+"%")
		}
		
		//render(text:patientList.size(), contentType:"text/html",encoding:"UTF-8")
		
		render(view:"unitPerformance",model:
			[patients:patientList,unit:unit])
	}
	
}
