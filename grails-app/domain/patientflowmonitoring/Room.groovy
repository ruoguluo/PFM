package patientflowmonitoring

class Room {
	
	String roomId
	List beds = []
	
	static hasMany = [beds:Bed]

    static constraints = {
    }
	
	String toString(){
		return roomId
	}
}
