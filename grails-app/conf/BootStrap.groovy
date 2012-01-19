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
		
		jmsService.send(queue:'PFM_Event','event:TriageScore,timestamp:2011-11-11/03-30-00,Provider_ID:Nurse745774,CTAS:2,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:PatientRegistered,RFTag_ID:Tag123Patient,timestamp:2011-11-11/03-40-00,Room_ID:ED5,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation,timestamp:2011-11-11/04-00-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultationCompleted,timestamp:2011-11-11/04-20-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted,timestamp:2011-11-11/04-20-00,Provider_ID:Phy777777,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1111,OrderType:ECG,Provider_ID:Phy777777,timestamp:2011-11-11/04-30-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1112,OrderType:BloodSample,Provider_ID:Phy777777,timestamp:2011-11-11/04-30-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1113,OrderType:BloodAnalysis,Provider_ID:Phy777777,timestamp:2011-11-11/04-30-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:ConsultationCompleted,timestamp:2011-11-11/04-40-00,Provider_ID:Phy777777,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForOrderExecution,timestamp:2011-11-11/04-40-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1111,OrderType:ECG,Provider_ID:Nurse121212,timestamp:2011-11-11/05-05-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1112,OrderType:BloodSample,Provider_ID:Nurse121212,timestamp:2011-11-11/05-08-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1113,OrderType:BloodAnalysis,Provider_ID:Nurse121212,timestamp:2011-11-11/05-40-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderExecutionCompleted,timestamp:2011-11-11/05-40-00,Provider_ID:Nurse121212,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation,timestamp:2011-11-11/05-41-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultationCompleted,timestamp:2011-11-11/06-05-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted,timestamp:2011-11-11/06-05-00,Provider_ID:Phy777777,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:BedRequest,timestamp:2011-11-11/06-15-00,Provider_ID:Phy777777,Unit_ID:CCU2,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1162,timestamp:2011-11-11/06-20-00,OrderType:Angiogram,Provider_ID:Phy777777,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1163,OrderType:PCI,Provider_ID:Phy777777,timestamp:2011-11-11/06-20-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:ConsultationCompleted,timestamp:2011-11-11/06-35-00,Provider_ID:Phy777777,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:PatientAdmittedWithNoBed,timestamp:2011-11-11/06-35-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForBed,timestamp:2011-11-11/06-35-00,Unit_ID:CCU2,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:Discharge,timestamp:2011-11-11/06-50-00,Provider_ID:Phy666666,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientAdmittedWithBed,Bed_ID:Bed207,timestamp:2011-11-11/08-55-00,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitedForBedCompleted,timestamp:2011-11-11/09-05-00,Unit_ID:CCU2,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:PatientTransportRequest,Unit_ID:CCU2,timestamp:2011-11-11/09-05-00,Transport_ID:Transporter147258,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForTransport,timestamp:2011-11-11/09-05-00,Unit_ID:CCU2,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:WaitForTransportCompleted,timestamp:2011-11-11/09-30-00,Unit_ID:CCU2,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:PatientTransportStarted,Unit_ID:CCU2,timestamp:2011-11-11/09-30-00,Transport_ID:Transporter147258,Patient_ID:Pa234567')
		jmsService.send(queue:'PFM_Event','event:PatientTransportCompleted,Unit_ID:CCU2,timestamp:2011-11-11/09-40-00,Transport_ID:Transporter147258,Patient_ID:Pa234567')
		
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
