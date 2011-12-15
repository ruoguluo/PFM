<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" />
		
		<title>DataTables example</title>
		<style type="text/css" title="currentStyle">
			@import "../css/demo_page.css";
			@import "../css/demo_table.css";
		</style>
		<script type="text/javascript" language="javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" language="javascript" src="../js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="utf-8">
			/* Data set - can contain whatever information you want */
			
			<%
				//println patients
				
				def dataSet = [];
				def now = new Date()
				def time0 = now.time%(86400000)
				patients.each({
						Date startTime = it.currentState.startTime

						def time1 = startTime.time%(86400000)
						//System.out.println(time1)
						dataSet<<"['${it}','${it.currentState}','${((time0-time1)/60000) as int}']"
				})
			%>
			
			var aDataSet = <%=dataSet%>
			
			$(document).ready(function() {
				$('#dynamic').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>' );
				$('#example').dataTable( {
					"aaData": aDataSet,
					"aoColumns": [
						{ "sTitle": "Patient ID", "sClass": "center" },
<%--						{ "sTitle": "Location", "sClass": "center" },--%>
						{ "sTitle": "Waiting State", "sClass": "center" },
<%--						{ "sTitle": "Start Time", "sClass": "center","sWidth":"200px" },--%>
						{ "sTitle": "Duration (minutes)", "sClass": "center","sWidth":"5%" }
					]
				} );	
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<div class="full_width big">
				Current Patients Wait Time
			</div>
			<%=unit %>
			<p></p>			
			<h1>Wait time table</h1>
			<div id="dynamic"></div>
			<div class="spacer"></div>
		</div>
	</body>
</html>
