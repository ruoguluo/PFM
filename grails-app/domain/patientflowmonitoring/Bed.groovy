package patientflowmonitoring

class Bed {

	String bedId
	String roomId
	String unitId
	
	BedStatus status

	enum BedStatus{
		ORDERED,
		OCCUPIED,
		EMPTY,
		READY;
	}

	static constraints = {
	}
}
