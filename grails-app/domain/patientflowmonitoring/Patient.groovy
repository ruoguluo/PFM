package patientflowmonitoring

class Patient {

	String patientID
	PatientState currentState
	Event lastEventReceived
	Map props = [:]
	List states
	List events
	
	static hasMany = [states:PatientState,events:Event]
	
	static constraints = {
		lastEventReceived(nullable:true)
		props(nullable:true)
		states(nullable:true)
		events(nullable:true)
	}
	

	void terminateCurrentState(Date ts){
	  currentState.setEndTime(ts);
	}
	
	void startCurrentState(Date ts){
	  currentState.setStartTime(ts);
	}
	
	void changeState(PatientState newState, Date ts){
	  terminateCurrentState(ts);
	  setCurrentState(newState,ts);
	}
	
	void setCurrentState(Patient newState, Date ts){
	  currentState = newState;
	  startCurrentState(ts);
	  states.add(currentState);
	}
	
	void appendEvents(Event event){
	  events.add(event)
	  lastEventReceived  = event
	}
	

}
