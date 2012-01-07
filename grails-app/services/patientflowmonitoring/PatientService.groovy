package patientflowmonitoring

import java.util.Map;
import patientflowmonitoring.PatientState.PatientStateName

class PatientService {

    static transactional = true

    def serviceMethod() {

    }
	
	def updatePatientState(){
		
	}
	
	def Map queryPatientMap(){
		
//		def c = Patient.createCriteria()
//		
//		def patientList = c.list{
//			notEqual("roomID","")
//		}
		
		def patientList = Patient.withCriteria(){
			currentState{
				not{
					eq("stateName",PatientStateName.DISCHARGED)
				}
			}
			notEqual("roomID","")
		}
		
		
		def patientMap = [:]
		
		patientList.each({
			patientMap[it.roomID]=it.patientID
		})
		
		println(patientMap)
		
		return patientMap
	}
	
	def List getWaitingPatients(){
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
		return patients
	}
}
