package patientflowmonitoring

class Bed {

	String bedId
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
