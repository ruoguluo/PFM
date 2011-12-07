
<html>
  <head>
      
  </head>
	<g:javascript library="jquery" plugin="jquery"/>
  <body>
  <img src="images/map1.PNG" id="map"/>
<img src="images/blue_spot.png" id="marker" 
style="display: none;position: absolute;"/>
<script type="text/javascript">
$('#map').click(function(e)
{   
//alert("click");
	$('#marker').css('left', 258).css('top', 103).show();// Position of the marker is now e.pageX, e.pageY // ... which corresponds to where the click was.
});
</script>
  </body>
</html>