<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/ico"
	href="http://www.datatables.net/media/images/favicon.ico" />

<title>DataTables example</title>
<style type="text/css" title="currentStyle">
@import "../../css/demo_page.css";

@import "../../css/demo_table.css";
</style>
<script type="text/javascript" language="javascript"
	src="../../js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="../../js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8">

			console.info("<%=patient%>");

			<%
				def events = [];
				def eventList = patient.events
				eventList.each({
					events<<"['${it.eventName}','${it.timeStamp}']"
				})
				//println events
				
				def states = [];
				def stateList = patient.states;
				stateList.each({
					states<<"['${it.stateName}','${it.startTime}','${it.endTime}','${it.duration}']"
				})
			%>
		
			/* Data set - can contain whatever information you want */
			var eventDataSet = <%=events%>;

			var stateDataSet = <%=states%>;
			
			$(document).ready(function() {
				$('#events').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="event_table"></table>' );
				$('#event_table').dataTable( {
					"aaData": eventDataSet,
					"aoColumns": [
						{ "sTitle": "Event data received" },
						{ "sTitle": "Received Time", "sClass": "center" }
					]
				} );	
				$('#states').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="state_table"></table>' );
				$('#state_table').dataTable( {
					"aaData": stateDataSet,
					"aoColumns": [
						{ "sTitle": "State" },
						{ "sTitle": "Start Time", "sClass": "center" },
						{ "sTitle": "End Time", "sClass": "center",
							"fnRender":function(oObj){
									if (oObj.aData[2]=="null")
										return 'N/A';
									return oObj.aData[2];
								}
							 },
						{ "sTitle": "Duration (mins)", "sClass": "center","sWidth":"5%",
							"fnRender":function(oObj){
									if (oObj.aData[2]=="N/A")
										return 'N/A';
									return oObj.aData[3];
								}
							 }
					]
				} );					
			} );
		</script>
</head>
<body id="dt_example">
	<div id="container">
		<div class="full_width big">Patient Info</div>

		<%=patient%>
		<h1>Clinical Info</h1>
		<h1>Events Received</h1>
		<div id="events"></div>
		<div class="spacer"></div>
		<h1>States</h1>
		<div id="states"></div>
	</div>
</body>
</html>
