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
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00'],
				['CCU1','Pa123456','In Consultation', '2011-12-12 03:30:00']
			];
			
			$(document).ready(function() {
				$('#dynamic').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>' );
				$('#example').dataTable( {
					"aaData": aDataSet,
					"aoColumns": [
						{ "sTitle": "Lacation Label" },
						{ "sTitle": "Patient ID", 
							"fnRender":function(obj){
								var value = obj.aData[obj.iDataColumn];
								return '<a href="abc">'+value+'</a>';
								}
							},
						{ "sTitle": "Current State" },
						{ "sTitle": "Start Time", "sClass": "center" }
					]
				} );	
			} );
		</script>
	</head>
	<body id="dt_example">
		<div id="container">
			<div class="full_width big">
				Mapping for Rooms and Patients
			</div>
			
			<p></p>			
			<h1>Mapping chart</h1>
			<div id="dynamic"></div>
			<div class="spacer"></div>
		</div>
	</body>
</html>
