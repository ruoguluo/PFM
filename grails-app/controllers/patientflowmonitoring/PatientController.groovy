package patientflowmonitoring

class PatientController {
	
	def scaffold = true

	def getPatientMap = {
		
		def c = Patient.createCriteria()
		
		def patientList = c.list{
			notEqual("roomID","")
		}
		
		
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

	}
	
	def getCurrentPatientsWaitTime = {
		
/*		def c = Patient.createCriteria()
		
		def patientList = c.list{
			like("currentState","WAIT%")
		}*/
		def patients = []
		def patientList = Patient.findAllByPatientIDIsNotNull()
		patientList.each ({
			if (it.currentState.toString().startsWith("WAIT")){
				patients<<it
			}
		}
		)
		
		//render(text:patients.size(), contentType:"text/html",encoding:"UTF-8")
		render(view:"currentPatientsWaitTime",model:[patients:patients])
	}
}
