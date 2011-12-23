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
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		render(view:"todayArrivalsByHour", model:[mapping:results])
	}
}
