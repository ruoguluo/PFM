<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
      
<%
	def patients = [];
	def patientList = mapping.values().toList();
	patientList.each({
		patients<<"${it}"
	})
	def roomList = mapping.keySet().toList();
%>      
      
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<nav:resources/>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>Unit Map 1</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
	<style type="text/css" title="currentStyle">
		@import "<%=request.getContextPath() %>/css/demo_page.css";
		@import "<%=request.getContextPath() %>/css/demo_table.css";
	</style>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
	
	<script type="text/javascript" charset="utf-8">
	
	console.info("<%=patients%>")
	//var aDataSet = <%=patients%>;
	
	$(document).ready(function() {

		//$('#dynamic').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>' );
		$('#example').dataTable( {
	        "bPaginate": false,
	        "bLengthChange": false,
	        "bFilter": false,
	        "bSort": false,
	        "bInfo": false,
	        "bAutoWidth": false
			//"aaData": aDataSet,
			//"aoColumns": [
			//	{ "sTitle": "Patient ID", "sClass": "center",
			//		"fnRender":function(oObj){
			//			return "<a href='getPatientDetails/"+oObj.aData[0]+"'>"+oObj.aData[0]+"</a>";
			//		}
			//	}
			//]
		} );
		
		var map_top = $('#map').offset().top;
		var map_left = $('#map').offset().left;

		<% for (i in 0..<roomList.size()){%>
		var marker<%=i%> = $('#marker').clone();
		<%}%>
		
		renderSpots()

		$(window).resize(function() {
			map_top = $('#map').offset().top;
			map_left = $('#map').offset().left;
			renderSpots();
			});	

		function renderSpots(){
			<% for (i in 0..<roomList.size()){%>
			marker<%=i%>.id="marker<%=i%>"
				marker<%=i%>.css('left', map_left+coord["<%=roomList[i]%>"]["left"])

				marker<%=i%>.css('top',  map_top+coord["<%=roomList[i]%>"]["top"])
				marker<%=i%>.css("display","inline")
				marker<%=i%>.attr("title","<%=patientList[i]%>")
				marker<%=i%>.bind('click',function(){
					//alert('Marker<%=i%> is clicked');
					window.location="getPatientDetails/<%=patientList[i]%>";
					});
				$('#td_map').append(marker<%=i%>);
			<%}%>	
				//$('#marker').css('left', map_left+100).css('top', map_top+290).show();
		}

		//alert(coord["ED1"]["top"]);
		
	} );	


	var coord = {'ED1':{'top':290,'left':95},
			'ED2':{'top':285,'left':140},
			'ED3':{'top':285,'left':200},
			'ED4':{'top':275,'left':250},
			'ED5':{'top':270,'left':302},
			'ED6':{'top':265,'left':362},
			'ED7':{'top':529,'left':103},
			'ED8':{'top':517,'left':150},
			'ED9':{'top':505,'left':217},
			'ED10':{'top':493,'left':267},
			'ED11':{'top':480,'left':317},
			'ED12':{'top':468,'left':367},
			
			'CCU1':{'top':245,'left':480},
			'CCU2':{'top':240,'left':535}};

	function ed_click(){
		//alert('clicked');
		window.location="../unit/showUnitPerformance/ED"
	}


	</script>

</head>

<body id="dt_example">
<div id="container">
<nav:render group="tabs"/>
<h1>OSLER Unit Map</h1>

<table border="1" style="width: 100%">
  <tbody>
    <tr>
      <td width="200" valign="top">
      <div align="center"><h2>Patient List</h2></div>
		<div id="dynamic">
			<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
			<thead>
				<tr>
					<th>Patient Id</th>
				</tr>
			</thead>
			<tbody>
				<%p=0%>
				<g:while test="${p < patients?.size}">
					<% def css=session.patient?.patientID==patients[p]?"selected":""  %>
					<tr class="<%=css%>"><td class="center"><a href="getPatientDetails/<%=patients[p] %>"><%=patients[p] %></a></td></tr>
					<%p++%>
				</g:while>
			</tbody>
			</table>
		</div>
		</td>
      <td id="td_map"><img alt="plane1" src="<%=request.getContextPath() %>/images/plane1.png" height="614" width="850" id="map" usemap="#unitmap" border="0"/>
      <img src="<%=request.getContextPath() %>/images/blue_spot.png" id="marker" style="display: none;position: absolute;" title="marker"/></td>
    </tr>
  </tbody>
</table>

<map name="unitmap">
	<area shape="poly" coords="80,185,360,155,400,500,80,545" onClick="javascript:ed_click()" title="ED Unit Area" /> 
</map>

</div>
</body>
</html>
