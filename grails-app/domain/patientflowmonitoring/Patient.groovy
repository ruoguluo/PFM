package patientflowmonitoring

class Patient {

	String patientID
	PatientState currentState
	Event lastEventReceived
	String roomID
	Map props = [:]
	List states = []
	List events = []
	
	static hasMany = [states:PatientState,events:Event]
	
	static mapping = {
		events cascade:'all-delete-orphan'
		states cascade:'all-delete-orphan'
	}
	
	static constraints = {
		patientID(unique:true)
		roomID(nullable:true)
		currentState()
		lastEventReceived(nullable:true)
		states(nullable:true)
		events(nullable:true)
		props(nullable:true)
	}
	

	void terminateCurrentState(Date ts){
	  currentState?.setEndTime(ts);
	}
	
	void startCurrentState(Date ts){
	  currentState?.setStartTime(ts);
	}
	
	void changeState(PatientState newState, Date ts){
	  terminateCurrentState(ts);
	  setCurrentState(newState,ts);
	}
	
	void setCurrentState(PatientState newState, Date ts){
	  terminateCurrentState(ts);
	  currentState = newState;
	  states.add(currentState);
	  startCurrentState(ts);
	}
	
	public void appendEvent(Event event){
	  events.add(event)
	  lastEventReceived  = event
	}
	
//	public void appendState(PatientState newState){
//		states.add(newState)
//		currentState = newState
//	}
	
	String toString() {"${this.patientID}"}
}
