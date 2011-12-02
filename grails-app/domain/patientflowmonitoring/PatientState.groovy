package patientflowmonitoring

import groovy.time.TimeCategory

class PatientState {
	
	enum PatientStateName {
		NEW,
		TRIAGE_COMPLETE,
		TRIAGE_SCORE,
		WAIT_FOR_CONSULTATION,
		IN_CONSULTATION,
		CONSULTATION_COMPLETE,
		WAIT_FOR_ORDER_EXECUTION,
		ORDER_EXECUTION,
		ORDER_EXECUTION_COMPLETE,
		WAIT_FOR_BED,
		WAIT_FOR_TRANSPORT,
		IN_TRANSPORT,
		IN_BED,
		DISCHARGED}
	
	PatientStateName stateName;
	Patient patient;
	Date startTime;
	Date endTime;
	int duration;
	Map stateAttributes=[:];
	
	static belongesTo = [patient:Patient]

    static constraints = {
		patient()
		stateName()
		startTime(nullable:true)
		endTime(nullable:true)
		duration(nullable:true)
		stateAttributes(nullable:true)
    }
	
	def void setEndTime(Date ts){
		endTime = ts
		if (startTime!=null&&endTime!=null){
			duration = TimeCategory.minus(endTime,startTime).toMilliseconds()/60000
		}
	}
	
	String toString() {"${this.stateName}"}
}
