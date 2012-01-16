package patientflowmonitoring

import patientflowmonitoring.Admission;
import patientflowmonitoring.Discharge;
import patientflowmonitoring.Statistics;

class AdmissionController {

    def scaffold = true
	
	def getHourlyAdmission (def dayTag){
		
		def c1 = Admission.createCriteria()
		def result = c1 {
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		return result
	}
	
	def hourlyDischarge= {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		List dataSet = getHourlyDischarge(dayTag)
		
		def retVal = new StringBuffer()
		retVal.append("[")
		dataSet.each{
			retVal.append("{\"hour\":${it[0]},\"discharge\":${it[1]}},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		//render(contentType:"application/json",text:retVal)
		return retVal
	}
	
	def hourlyAdmissionDischarge = {
		def admission = hourlyAdmission()
		def discharge = hourlyDischarge()
		def retVal = "{\"hourlyAdmission\":${admission},\"hourlyDischarge\":${discharge}}"
		render(contentType:"application/json",text:retVal)
	}
	
	def hourlyAdmission = {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		List dataSet = getHourlyAdmission(dayTag)
		
		def retVal = new StringBuffer()
		retVal.append("[")
		dataSet.each{
			retVal.append("{\"hour\":${it[0]},\"admission\":${it[1]}},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		//render(contentType:"application/json",text:retVal)
		return retVal
	}
	
	def getHourlyDischarge (def dayTag){
		
		def c2 = Discharge.createCriteria()
		def result = c2 {
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		return result
	}
	
	def getAdmissionVsDischarge = {
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def hourlyAdmission = getHourlyAdmission(dayTag)
		def hourlyDischarge = getHourlyDischarge(dayTag)

		render(view:"admissionVsDischarge", model:[admission:hourlyAdmission, discharge:hourlyDischarge])
	}
	
	
}
