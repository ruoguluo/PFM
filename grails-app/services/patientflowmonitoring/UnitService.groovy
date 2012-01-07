package patientflowmonitoring

class UnitService {

    static transactional = true

    def serviceMethod() {

    }
	
	def getUnitIds(){
		def units = Unit.getAll();
		List unitIds = []
		units.each{
			unitIds<<it.unitId
		}
		return unitIds
	}
}
