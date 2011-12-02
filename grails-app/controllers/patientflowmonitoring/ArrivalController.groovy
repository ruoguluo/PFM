package patientflowmonitoring

import patientflowmonitoring.Arrival;
import patientflowmonitoring.Statistics;

class ArrivalController {
	def scaffold = true
	
	def getTodayArrivals = {
		def arrivals = [:]
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def c = Arrival.createCriteria()
		def results = c {
//			eq("dayTag",dayTag)
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		//render(results)
		//redirect(uri:"/todayArrivalsByHour.gsp",params:[mapping:results])
		render(view:"todayArrivalsByHour", model:[mapping:results])
	}
}
