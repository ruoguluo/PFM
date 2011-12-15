package patientflowmonitoring

class PatientController {
	
	def scaffold = true

    //def index = { }
	
	def getPatientMap = {
		
		def c = Patient.createCriteria()
		
		def patientList = c.list{
			isNotNull("roomID")
		}
		
//		println(patientList.size())
		
		def patientMap = [:]
		
		patientList.each({
			patientMap[it.roomID]=it.patientID
		})
		
		println(patientMap)
		
		render(view:"UnitMap1",model:
			[mapping:patientMap])
	}
}
