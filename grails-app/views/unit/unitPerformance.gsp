<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<nav:resources/>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		
		<title>Report</title>
		<style type="text/css" title="currentStyle">
			@import "<%=request.getContextPath() %>/css/demo_page.css";
			@import "<%=request.getContextPath() %>/css/demo_table.css";
			@import "<%=request.getContextPath() %>/css/jQuery_menu.css";
		</style>
		<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
		<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
		<script type="text/javascript" language="javascript" src="<%=request.getContextPath() %>/js/jquery.tabify.source.js"></script>	
		<script type="text/javascript" charset="utf-8">
			/* Data set - can contain whatever information you want */
			
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

				$('#menutab').tabify();
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<nav:render group="tabs"/>
			<h1>report</h1>
			<ul id="menutab" class="menu">
				<li class="active"><a href="#unit_performance">Unit Performance</a></li>
				<li><a href="#statistics">Statistic Charts</a></li>
			</ul>
			
			<div id="unit_performance">
				
				<h2>Unit: <%=unit %></h2>
				<div id="dynamic"></div>
			</div>
			
			<div id="statistics">
				<g:include controller="arrival" action="getTodayArrivals" />
				<g:include controller="admission" action="getAdmissionVsDischarge" />
			</div>
		</div>
	</body>
</html>
