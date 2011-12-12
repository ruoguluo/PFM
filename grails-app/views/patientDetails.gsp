<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" />
		
		<title>DataTables example</title>
		<style type="text/css" title="currentStyle">
			@import "css/demo_page.css";
			@import "css/demo_table.css";
		</style>
		<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
		<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
		<script type="text/javascript" charset="utf-8">
			/* Data set - can contain whatever information you want */
			var eventDataSet = [
			    				['Event data1', '2011-12-12 03:30:00'],
			    				['Event data2', '2011-12-12 03:30:00'],
			    				['Event data3', '2011-12-12 03:30:00'],
			    				['Event data4', '2011-12-12 03:30:00'],
			    				['Event data5', '2011-12-12 03:30:00'],
			    				['Event data6', '2011-12-12 03:30:00'],
			    				['Event data7', '2011-12-12 03:30:00'],
			    				['Event data8', '2011-12-12 03:30:00'],
			    				['Event data9', '2011-12-12 03:30:00'],
			    				['Event data10', '2011-12-12 03:30:00'],
			    				['Event data11', '2011-12-12 03:30:00'],
			    				['Event data12', '2011-12-12 03:30:00'],
			    				['Event data13', '2011-12-12 03:30:00'],
			    				['Event data14', '2011-12-12 03:30:00'],
			    				['Event data15', '2011-12-12 03:30:00'],
			    				['Event data16', '2011-12-12 03:30:00'],
			    				['Event data17', '2011-12-12 03:30:00'],
			    				['Event data18', '2011-12-12 03:30:00'],
			    				['Event data19', '2011-12-12 03:30:00'],
			    				['Event data20', '2011-12-12 03:30:00']
			];

			var stateDataSet = [
			    				['State1', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State2', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State3', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State4', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State5', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State6', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State7', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State8', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State9', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State10', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State11', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State12', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State13', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State14', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State15', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State16', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State17', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State18', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State19', '2011-12-12 03:30:00','2011-12-12 03:30:00'],
			    				['State20', '2011-12-12 03:30:00','2011-12-12 03:30:00']
			];
			
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
						{ "sTitle": "End Time", "sClass": "center" }
					]
				} );					
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<div class="full_width big">
				Patient Info
			</div>
			
			<p></p>			
			<h1>Events Received</h1>
			<div id="events"></div>
			<div class="spacer"></div>
			<h1>States</h1>
			<div id="states"></div>
		</div>
	</body>
</html>
