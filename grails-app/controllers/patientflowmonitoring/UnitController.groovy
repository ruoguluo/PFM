package patientflowmonitoring

class UnitController {

	def showUnitPerformance={
		
		def unit = params.id
		
		def c = Patient.createCriteria()
		
		def patientList = c.list{
			like ("roomID", unit+"%")
		}
		
		//render(text:patientList.size(), contentType:"text/html",encoding:"UTF-8")
		
		render(view:"unitPerformance",model:
			[patients:patientList,unit:unit])
	}
}
