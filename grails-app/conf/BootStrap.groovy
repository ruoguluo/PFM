import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName

class BootStrap {

    def init = { servletContext ->
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_BED
		def patient = new Patient(patientID:'Pa111111',roomID:"CCU2")
		patient.setCurrentState(patientState, null)
		patient.save()
    }
    def destroy = {
    }
}
