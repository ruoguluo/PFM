package patientflowmonitoring

class Event {
	
	String eventId = "" + new Date()
	
	enum EventName{
		Triage,
		Registered,
		WaitForConsultation,
		WaitForConsultationCompleted,
		ConsultationStarted,
		ConsultationCompleted,
		OrderRequest,
		WaitForOrderExecution,
		OrderExecutionCompleted,
		WaitForConsultation2,
		BedRequest,
		PatientAdmittedWithNoBed,
		PatientAdmittedWithBed,
		WaitForBed,
		WaitForBedCompleted,
		PatientTransportRequest,
		WaitForTransport,
		WaitForTransportCompleted,
		PatientTransportStarted,
		PatientTransportCompleted,
		PatientArrivedInBed,
		Discharge
	}
	
	EventName eventName
	Date timeStamp = new Date()
	Map eventAttrs = [:]
	Patient patient;
	
	static belongesTo = [patient:Patient]

    static constraints = {
		event_id()
		patient()
		eventName(nullable:true)
		eventAttrs(nullable:true)
		timeStamp(nullable:true)
    }
	
	static mapping = {
		//id column:'event_id',generator:'hilo',params:[table:'hi_value',column:'next_value',max_lo:100]
	}
	
//	static mapping={
//		id generator:"hilo"
//	}
	
	//String toString(){"${this.eventName}_${this.id}"}
}
