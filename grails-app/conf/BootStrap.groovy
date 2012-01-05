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
		def room = new Room()
		room.roomId = "2012"
		room.save()
		def unit = new Unit()
		unit.unitId = "ED"
		unit.rooms.add(room)
		unit.save()
	}
}
