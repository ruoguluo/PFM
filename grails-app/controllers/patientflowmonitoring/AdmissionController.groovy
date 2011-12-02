package patientflowmonitoring

import patientflowmonitoring.Admission;
import patientflowmonitoring.Discharge;
import patientflowmonitoring.Statistics;

class AdmissionController {

    def scaffold = true
	
	def getAdmissionVsDischarge = {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def c1 = Admission.createCriteria()
		def resultAdmission = c1 {
//			eq("dayTag",dayTag)
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		def c2 = Discharge.createCriteria()
		def resultDischarge = c2 {
//			eq("dayTag",dayTag)
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		//render(resultAdmission+""+resultDischarge)
		render(view:"admissionVsDischarge", model:[admission:resultAdmission, discharge:resultDischarge])
	}
	
	
}
