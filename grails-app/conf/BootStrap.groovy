import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Unit
import patientflowmonitoring.Room

class BootStrap {
	
	def jmsService

    def init = { servletContext ->
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_BED
		def patient = new Patient(patientID:'Pa111111',roomID:"CCU2")
		patient.setCurrentState(patientState, null)
		patient.save()
		createUnits()
		createTestRecords()
    }
    def destroy = {
    }
	
	def createTestRecords(){
		jmsService.send(queue:'PFM_Event','event:TriageScore,timestamp:2011-11-11/03-30-00,Provider_ID:Nurse745774,CTAS:2,Patient_ID:Pa123456')
		jmsService.send(queue:'PFM_Event','event:PatientRegistered,RFTag_ID:Tag123Patient,timestamp:2011-11-11/03-40-00,Room_ID:ED1,Patient_ID:Pa123456')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation,timestamp:2011-11-11/04-00-00,Patient_ID:Pa123456')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultationCompleted,timestamp:2011-11-11/04-20-00,Patient_ID:Pa123456')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted,timestamp:2011-11-11/04-20-00,Provider_ID:Phy777777,Patient_ID:Pa123456')
		
		jmsService.send(queue:'PFM_Event','event:TriageScore,timestamp:2011-11-11/05-30-00,Provider_ID:Nurse745774,CTAS:2,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:PatientRegistered,RFTag_ID:Tag123Patient,timestamp:2011-11-11/05-40-00,Room_ID:ED2,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation,timestamp:2011-11-11/06-00-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultationCompleted,timestamp:2011-11-11/06-20-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted,timestamp:2011-11-11/06-20-00,Provider_ID:Phy777777,Patient_ID:Pa123457')
		
		jmsService.send(queue:'PFM_Event','event:Discharge,timestamp:2011-11-11/06-50-00,Provider_ID:Phy666666,Patient_ID:Pa111111')
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
