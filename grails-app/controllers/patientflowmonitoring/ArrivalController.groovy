package patientflowmonitoring

import patientflowmonitoring.Arrival;
import patientflowmonitoring.Statistics;

class ArrivalController {
	def scaffold = true
	
	def getHourlyArrival(def dayTag) {
		
		def c = Arrival.createCriteria()
		def result = c {
			projections {
				groupProperty("hour")
				rowCount()
			}
			order("hour")
		}
		
		return result
	}
	
	def getTodayArrivals = {
		def arrivals = [:]
		def Date today = new Date()
		def dayTag = Statistics.createDayTag(today)
		
		def hourlyArrivals = getHourlyArrival(dayTag)

		render(view:"todayArrivalsByHour", model:[mapping:hourlyArrivals])
	}
}
