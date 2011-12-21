package patientflowmonitoring

import patientflowmonitoring.PatientState.PatientStateName

class PatientController {
	
	def scaffold = true
	
	static navigation = [
		[group:'tabs',action:'getPatientMap', title:'Unit Map',order:0],
		[action:'getPatientDetails', title:'Patient Details',order:5]
	]
	

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
		
		if (params.id){
			Patient patient = Patient.findByPatientID(params.id)
			render(view:"patientDetails",model:
				[patient:patient])
		}else{
			getPatientMap()
		}

	}
	
	def getCurrentPatientsWaitTime = {
	
		def patients = Patient.withCriteria(){
			currentState{
				or{
					eq("stateName",PatientStateName.WAIT_FOR_CONSULTATION)
					eq("stateName",PatientStateName.WAIT_FOR_ORDER_EXECUTION)
					eq("stateName",PatientStateName.WAIT_FOR_BED)
					eq("stateName",PatientStateName.WAIT_FOR_TRANSPORT)
				}
			}
		}

		render(view:"currentPatientsWaitTime",model:[patients:patients])
	}
}
