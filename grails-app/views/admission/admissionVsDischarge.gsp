  <!--   R:
  	<%=admission.size%>&nbsp;<%=discharge.size%>  --> 
  	<%
		
		def ah = []
		def dh = []
		for (i in 0..23){
			ah[i]=0
			dh[i]=0
		}
		
		for (int i=0;i<admission.size;i++){
			//println ((List)(mapping.get(i)));
			def List t1 = (List)(admission.get(i))
			ah[t1[0]]=t1[1]
		}  
		//println(ah)
		
		for (int i=0;i<discharge.size;i++){
			//println ((List)(mapping.get(i)));
			def List t2 = (List)(discharge.get(i))
			dh[t2[0]]=t2[1]
		}
		//println(dh)
		
	%>
  
  
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Time');
        data.addColumn('number', 'Admission');
        data.addColumn('number', 'Discharge')
        data.addRows(24);
        <% for (int h=0;h<24;h++){%>
		data.setValue(<%=h%>, 0, "<%=h%>");
		data.setValue(<%=h%>, 1, <%=ah[h]%>);
		data.setValue(<%=h%>, 2, <%=dh[h]%>);
		<% } %>

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_admissionVsDischarge_div'));
        chart.draw(data, {width: 800, height: 600, title: 'Today Admission Vs Discharge by Hour',
                          hAxis: {title: 'Time', titleTextStyle: {color: 'blue'}}
                         });
      }
    </script>

    <div id="chart_admissionVsDischarge_div"></div>
