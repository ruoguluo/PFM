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

		var marker2 = $('#marker').clone();
		var map_top = $('#map').offset().top;
		var map_left = $('#map').offset().left;
		renderSpots()

		$(window).resize(function() {
			map_top = $('#map').offset().top;
			map_left = $('#map').offset().left;
			renderSpots();
			});	

		function renderSpots(){
			marker2.id="marker2"
				marker2.css('left', map_left+150)
				marker2.css('top',  map_top+280)
				marker2.css("display","inline")
				marker2.attr("title","marker2")
				marker2.bind('click',function(){
					alert('Marker2 is clicked');
					});
				$('#td_map').append(marker2);
				
				$('#marker').css('left', map_left+100).css('top', map_top+290).show();
		}

		//alert(coord["ED1"]["top"]);
		
	} );	


	var coord = {'ED1':{'top':290,'left':100},
			'ED2':{'top':280,'left':150}};
	
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
      <td id="td_map"><img alt="plane1" src="images/plane1.png" height="614" width="850" id="map"/>
      <img src="images/blue_spot.png" id="marker" 
style="display: none;position: absolute;" title="marker"/></td>
    </tr>
  </tbody>
</table>



</body>
</html>
