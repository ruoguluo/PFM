package patientflowmonitoring

class PatientController {
	
	def scaffold = true

	def getPatientMap = {
		
		def c = Patient.createCriteria()
		
		def patientList = c.list{
			notEqual("roomID","")
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
	
	def getPatientDetails = {
		
		Patient patient = Patient.findByPatientID(params.id)
		
		render(view:"patientDetails",model:
			[patient:patient])
		
//		println patient
		//render(text:"Ok", contentType:"text/html",encoding:"UTF-8")
	}
}
