package patientflowmonitoring

class Event {
	
	enum EventName{
		WitForConsultation,
		ConsultationStarted,
		ConsultationCompleted,
		WaitForOrderExecution,
		OrderExecutionCompleted,
		WaitForConsultation,
		WaitForBed,
		WaitForTransport,
		PatientTransportStarted,
		PatientArrivedInBed
	}
	
	EventName eventName
	Date ts
	Map eventAttributes

    static constraints = {
    }
}
