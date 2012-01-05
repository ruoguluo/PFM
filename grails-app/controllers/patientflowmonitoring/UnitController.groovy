package patientflowmonitoring

class UnitController {
	
	def scaffold = true
	
	static navigation = [
		[group:'tabs',action:'showUnitPerformance', title:"Report",order:10],
	]
	
	def queryUnitPerformance(def unit){
		def c = Patient.createCriteria()
		
		def patientList = c.list{
			like ("roomID", unit+"%")
		}
		
		List dataSet = [];
		patientList.each({
			def p = it
			def states = p.states
			states.each({
				//	println it
				if (it.toString().startsWith("WAIT")){
					List temp = []
					temp<<"\"${p}\""
					temp<<"\"${it}\""
					temp<<"\"${it.duration}\""
					dataSet<<temp
					//dataSet<<"['${p}','${it}','${it.duration}']"
				}
			})
		})
		
		return dataSet
	}
	
	def getUnitPerformance = {
		
		def unit = params.id
		if (!unit){
			unit = "ED"
		}
		
		List dataSet = queryUnitPerformance(unit);
		
		def retVal = new StringBuffer()
		retVal.append("[")
		dataSet.each{
			retVal.append("{patientId:${it[0]},state:${it[1]},duration:${it[2]}},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(retVal)
		
	}
	
	def showUnitPerformance={
		
		def unit = params.id
		if (!unit){
			unit = "ED"
		}
		
		def dataSet = queryUnitPerformance(unit);
		
		//render(text:patientList.size(), contentType:"text/html",encoding:"UTF-8")
		
		render(view:"unitPerformance",model:
			[dataSet:dataSet,unit:unit])
	}
	
}
