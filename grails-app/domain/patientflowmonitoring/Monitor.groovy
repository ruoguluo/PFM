package patientflowmonitoring

class Monitor {
	
	List patients
	List beds
	
	static hasMany = [patients:Patient,beds:Bed]

    static constraints = {
    }
}
