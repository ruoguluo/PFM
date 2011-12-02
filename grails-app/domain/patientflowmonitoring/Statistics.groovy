package patientflowmonitoring

import java.util.Date;

class Statistics {
	Date timeStamp;
	String dayTag;
	int hour;
	
	
	def void setTimeStamp(Date ts){
		timeStamp = ts;
		dayTag = createDayTag(ts)
		hour = ts.getHours();
	}
	
	def static String createDayTag(Date ts){
		return (1900+ts.getYear())+"-"+(ts.getMonth()+1)+"-"+ts.getDate()
	}
}
