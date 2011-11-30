package patientflowmonitoring

class Event {
	
	enum EventName{
		Triage,
		Registered,
		WaitForConsultation,
		WaitForConsultationCompleted,
		ConsultationStarted,
		ConsultationCompleted,
		WaitForOrderExecution,
		OrderExecutionCompleted,
		WaitForConsultation2,
		WaitForBed,
		WaitForTransport,
		PatientTransportStarted,
		PatientArrivedInBed
	}
	
	EventName eventName
	Date timeStamp
	Map eventAttrs = [:]
	Patient patient;
	
	static belongesTo = [patient:Patient]

    static constraints = {
		patient()
		eventName()
		eventAttrs(nullable:true)
		timeStamp(nullable:true)
    }
	
	String toString(){"${this.eventName}"}
}
