<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<nav:resources/>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" />
		
		<title>DataTables example</title>
		<style type="text/css" title="currentStyle">
			@import "<%=request.getContextPath() %>/css/demo_page.css";
			@import "<%=request.getContextPath() %>/css/demo_table.css";
		</style>
		<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
		<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="utf-8">
			/* Data set - can contain whatever information you want */
			
			<%
				//println patients
				def dataSet = [];
				patients.each({
					def p = it
					def states = p.states
					states.each({
						//	println it
						if (it.toString().startsWith("WAIT")){
							dataSet<<"['${p}','${it}','${it.duration}']"
						}
					})
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
						{ "sTitle": "Wait State", "sClass": "center" },
<%--						{ "sTitle": "Start Time", "sClass": "center","sWidth":"200px" },--%>
						{ "sTitle": "Duration (minutes)", "sClass": "center","sWidth":"5%" }
					]
				} );	
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<nav:render group="tabs"/>
			<div class="full_width big">
				Unit Performance
			</div>
			<%=unit %>
			<p></p>			
			<h1>Performance table</h1>
			<div id="dynamic"></div>
			<div class="spacer"></div>
			<h1>Statistics</h1>
			<g:include controller="arrival" action="getTodayArrivals" />
			<g:include controller="admission" action="getAdmissionVsDischarge" />
		</div>
	</body>
</html>
