<html>
  <head>
    <script type='text/javascript' src='https://www.google.com/jsapi'></script>
    <p> Current Patient Wait Time</p>
    <script type='text/javascript'>
      google.load('visualization', '1', {packages:['table']});
      google.setOnLoadCallback(drawTable);
      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Patient ID');
        data.addColumn('string', 'Service Item');
        data.addColumn('number', 'Wait Time (minutes)');
        data.addRows(2);
        data.setCell(0, 0, 'Pa123456');
        data.setCell(0, 1, 'Bed');
        data.setCell(0, 2, 35);
        data.setCell(1, 0, 'Pa111111');
        data.setCell(1, 1, 'Consultation');
        data.setCell(1, 2, 55);
        var table = new google.visualization.Table(document.getElementById('table_div'));
        table.draw(data, {showRowNumber: true});
      }
    </script>
  </head>

  <body>
    <div id='table_div'></div>
  </body>
</html>