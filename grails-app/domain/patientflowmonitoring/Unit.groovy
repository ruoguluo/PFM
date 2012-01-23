package patientflowmonitoring

import java.util.List;

class Unit {
	
	String unitId
	String name 
	
	List rooms = []
	
	static hasMany = [rooms:Room]

    static constraints = {
    }
}
