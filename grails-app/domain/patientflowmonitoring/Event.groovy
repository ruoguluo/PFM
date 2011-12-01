package patientflowmonitoring

class Event {
	
	enum EventName{
		Triage,
		Registered,
		WaitForConsultation,
		WaitForConsultationCompleted,
		ConsultationStarted,
		ConsultationCompleted,
		OrderRequest,
		WaitForOrderExecution,
		OrderRequestCompleted,
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
	Date timeStamp
	Map eventAttrs = [:]
	Patient patient;
	
	static belongesTo = [patient:Patient]

    static constraints = {
		patient()
		eventName(nullable:true)
		eventAttrs(nullable:true)
		timeStamp(nullable:true)
    }
	
	String toString(){"${this.eventName}"}
}
