package patientflowmonitoring

import java.util.List;

class Unit {
	
	String unitId
	List rooms = []
	
	static hasMany = [rooms:Room]

    static constraints = {
    }
}
