import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Unit
import patientflowmonitoring.Room

class BootStrap {

    def init = { servletContext ->
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_BED
		def patient = new Patient(patientID:'Pa111111',roomID:"CCU2")
		patient.setCurrentState(patientState, null)
		patient.save()
		createUnits()
    }
    def destroy = {
    }
	
	def createUnits() {
		def room1 = new Room()
		room1.roomId = "2012"
		room1.save()
		def unit1 = new Unit()
		unit1.unitId = "ED"
		unit1.rooms.add(room1)
		unit1.save()
		
		def room2 = new Room()
		room2.roomId = "2052"
		room2.save()
		def unit2 = new Unit()
		unit2.unitId = "CCU"
		unit2.rooms.add(room2)
		unit2.save()
		
	}
}
