package patientflowmonitoring

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
	Map stateAttributes=[:];
	
	static belongesTo = [patient:Patient]

    static constraints = {
		stateName()
		startTime(nullable:true)
		endTime(nullable:true)
		stateAttributes(nullable:true)
    }
	
	String toString() {"${this.stateName}"}
}
