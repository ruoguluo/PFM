<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<nav:resources/>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/ico"
	href="http://www.datatables.net/media/images/favicon.ico" />

<title>Patient Details</title>
<style type="text/css" title="currentStyle">
@import "<%=request.getContextPath() %>/css/demo_page.css";

@import "<%=request.getContextPath() %>/css/demo_table.css";
</style>

<style type="text/css" media="screen">
	body { font: 0.8em Arial, sans-serif; }
	.menu { padding: 0; clear: both; }
	.menu li { display: inline; }
	.menu li a { background: #ccf; padding: 10px; float:left; border-right: 1px solid #ccf; border-bottom: none; text-decoration: none; color: #000; font-weight: bold;}
	.menu li.active a { background: #eef; }
	.content { float: left; clear: both; border: 1px solid #ccf; border-top: none; border-left: none; background: #eef; padding: 10px 20px 20px; width: 400px; }
</style>


<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath() %>/js/jquery.tabify.source.js"></script>	
<script type="text/javascript" charset="utf-8">

			//console.info("<%=patient%>");

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
					"aaSorting": [[ 1, "asc" ]],
					"aoColumns": [
						{ "sTitle": "Event data received" },
						{ "sTitle": "Received Time", "sClass": "center" }
					]
				} );	
				$('#states').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="state_table"></table>' );
				$('#state_table').dataTable( {
					"aaData": stateDataSet,
					"aaSorting": [[ 1, "asc" ]],
					"aoColumns": [
						{ "sTitle": "State" },
						{ "sTitle": "Start Time", "sClass": "center",
							"fnRender":function(oObj){
								if (oObj.aData[1]=="null")
									return 'N/A';
								return oObj.aData[1];
							} },
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

				$('#menutab').tabify();
			} );
		</script>
</head>
<body id="dt_example">

	<div id="container">
		<nav:render group="tabs"/>
		<h1 align="center">Patient Info:<%=patient%></h1>
		
		<ul id="menutab" class="menu">
			<li class="active"><a href="#clinicalInfo">Clinical Info</a></li>
			<li><a href="#otherInfo">Other Info</a></li>
		</ul>

		<div id="clinicalInfo">
				<h1>Clinical Pathway</h1>
					<%=clincalPathWay %>
		</div>
				
		<div id="otherInfo">
				<h1>Events Received</h1>
				<div id="events"></div>
				<div class="spacer"></div>
				<h1>States</h1>
				<div id="states"></div>
		</div>

	</div>
</body>
</html>
