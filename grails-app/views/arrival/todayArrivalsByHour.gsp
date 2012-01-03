
  	<%
	  	def ah = []
		for (i in 0..23)
			ah[i]=0
	  
		for (int i=0;i<mapping.size;i++){
			//println ((List)(mapping.get(i)));
			def List t = (List)(mapping.get(i))
			ah[t[0]]=t[1]
		}  
		//println(ah)
	%>
  
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Time');
        data.addColumn('number', 'Arrivals');
        data.addRows(24);
		<% for (int h=0;h<24;h++){%>
			data.setValue(<%=h%>, 0, "<%=h%>");
			data.setValue(<%=h%>, 1, <%=ah[h]%>);
		<% } %>
        
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_arrivals_div'));
        chart.draw(data, {width: 800, height: 600, title: 'Today Arrivals by Hour',
                          hAxis: {title: 'Time', titleTextStyle: {color: 'blue'}}
                         });
      }
    </script>

    <div id="chart_arrivals_div"></div>
