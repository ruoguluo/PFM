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
			var aDataSet = [
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55'],
				['Pa123456','CCU1','In Consultation', '2011-12-12 03:30:00','55']
			];
			
			$(document).ready(function() {
				$('#dynamic').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>' );
				$('#example').dataTable( {
					"aaData": aDataSet,
					"aoColumns": [
						{ "sTitle": "Patient ID", "sClass": "center" },
						{ "sTitle": "Location", "sClass": "center" },
						{ "sTitle": "State", "sClass": "center" },
						{ "sTitle": "Start Time", "sClass": "center","sWidth":"200px" },
						{ "sTitle": "Duration (minutes)", "sClass": "center" }
					]
				} );	
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<div class="full_width big">
				Patient Current Wait Time
			</div>
			
			<p></p>			
			<h1>Wait time table</h1>
			<div id="dynamic"></div>
			<div class="spacer"></div>
		</div>
	</body>
</html>
