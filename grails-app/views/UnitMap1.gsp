<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>Unit Map 1</title>
  <meta name="generator" content="Amaya, see http://www.w3.org/Amaya/" />
	<style type="text/css" title="currentStyle">
		@import "css/demo_page.css";
		@import "css/demo_table.css";
	</style>
	<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
	<script type="text/javascript" language="javascript" src="js/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="utf-8">
	
	var aDataSet = [
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457'],
					['Pa123457']
				];
	
	$(document).ready(function() {
		$('#dynamic').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="example"></table>' );
		$('#example').dataTable( {
	        "bPaginate": false,
	        "bLengthChange": false,
	        "bFilter": false,
	        "bSort": false,
	        "bInfo": false,
	        "bAutoWidth": false,
			"aaData": aDataSet,
			"aoColumns": [
				{ "sTitle": "Patient ID", "sClass": "center" },
			]
		} );	
	} );	
	</script>
</head>

<body>
<h1>OSLER Unit Map</h1>

<p> </p>

<table border="1" style="width: 100%">
  <tbody>
    <tr>
      <td width="200">
      <div align="center"><h2>Patient List</h2></div>
		<div id="dynamic"></div>
		</td>
      <td><img alt="plane1" src="images/plane1.png" /></td>
    </tr>
  </tbody>
</table>
</body>
</html>
