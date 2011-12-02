<html>
  <head>
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
        data.setValue(0, 0, '00:00');
        data.setValue(0, 1, 0);
        data.setValue(0, 2, 0);
        data.setValue(1, 0, '01:00');
        data.setValue(1, 1, 0);
        data.setValue(1, 2, 0);
        data.setValue(2, 0, '02:00');
        data.setValue(2, 1, 0);
        data.setValue(2, 2, 0);
        data.setValue(3, 0, '03:00');
        data.setValue(3, 1, 0);   
        data.setValue(3, 2, 0);   
        data.setValue(4, 0, '04:00');
        data.setValue(4, 1, 0);
        data.setValue(4, 2, 0);
        data.setValue(5, 0, '05:00');
        data.setValue(5, 1, 0);        
        data.setValue(5, 2, 0);        
        data.setValue(6, 0, '06:00');
        data.setValue(6, 1, 1);   
        data.setValue(6, 2, 1);   
        data.setValue(7, 0, '07:00');
        data.setValue(7, 1, 0);
        data.setValue(7, 2, 0);
        data.setValue(8, 0, '08:00');
        data.setValue(8, 1, 0);        
        data.setValue(8, 2, 0);        
        data.setValue(9, 0, '09:00');
        data.setValue(9, 1, 0);   
        data.setValue(9, 2, 0);   
        data.setValue(10, 0, '10:00');
        data.setValue(10, 1, 0);
        data.setValue(10, 2, 0);
        data.setValue(11, 0, '11:00');
        data.setValue(11, 1, 0);        
        data.setValue(11, 2, 0);        
        data.setValue(12, 0, '12:00');
        data.setValue(12, 1, 0);   
        data.setValue(12, 2, 0);   
        data.setValue(13, 0, '13:00');
        data.setValue(13, 1, 0);
        data.setValue(13, 2, 0);
        data.setValue(14, 0, '14:00');
        data.setValue(14, 1, 0);        
        data.setValue(14, 2, 0);        
        data.setValue(15, 0, '15:00');
        data.setValue(15, 1, 0);                                                                                                 
        data.setValue(15, 2, 0);                                                                                                 
        data.setValue(16, 0, '16:00');
        data.setValue(16, 1, 0);
        data.setValue(16, 2, 0);
        data.setValue(17, 0, '17:00');
        data.setValue(17, 1, 0);        
        data.setValue(17, 2, 0);        
        data.setValue(18, 0, '18:00');
        data.setValue(18, 1, 0);   
        data.setValue(18, 2, 0);   
        data.setValue(19, 0, '19:00');
        data.setValue(19, 1, 0);
        data.setValue(19, 2, 0);
        data.setValue(20, 0, '20:00');
        data.setValue(20, 1, 0);        
        data.setValue(20, 2, 0);        
        data.setValue(21, 0, '21:00');
        data.setValue(21, 1, 0);                                                                                                 
        data.setValue(21, 2, 0);                                                                                                 
        data.setValue(22, 0, '22:00');
        data.setValue(22, 1, 0);        
        data.setValue(22, 2, 0);        
        data.setValue(23, 0, '23:00');
        data.setValue(23, 1, 0);    
        data.setValue(23, 2, 0);    
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, {width: 800, height: 600, title: 'Today Admission Vs Discharge by Hour',
                          hAxis: {title: 'Time', titleTextStyle: {color: 'blue'}}
                         });
      }
    </script>
  </head>

  <body>
    <div id="chart_div"></div>
  </body>
</html>