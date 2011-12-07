<html>
  <head>
  <link rel="stylesheet" type="text/css" href="js/jquery.jqplot.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.jqplot.js"></script>
<script type="text/javascript" src="js/plugins/jqplot.barRenderer.min.js"></script>
<script type="text/javascript" src="js/plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script type="text/javascript" src="js/plugins/jqplot.pointLabels.min.js"></script>
  </head>

<script>
$(document).ready(function(){
    var s1 = [200, 600, 700, 1000,200, 600, 700, 1000,200, 600, 700, 1000,200, 600, 700, 1000,200, 600, 700, 1000,200, 600, 700, 1000];
    var s2 = [460, 210, 690, 820,460, 210, 690, 820,460, 210, 690, 820,200, 600, 700, 1000,200, 600, 700, 1000,200, 600, 700, 1000];
    var s3 = [-260, -440, 320, 200,-260, -440, 320, 200,-260, -440, 320, 200,200, 600, 700, 1000,200, 600, 700, 1000,200, 600, 700, 1000];
    // Can specify a custom tick Array.
    // Ticks should match up one for each y value (category) in the series.
    var ticks = ['00:00', '01:00', '02:00', '03:00','04:00', '05:00', '06:00', '07:00','08:00', '09:00', '10:00', '11:00',
                 '00:00', '01:00', '02:00', '03:00','04:00', '05:00', '06:00', '07:00','08:00', '09:00', '10:00', '11:00'];
<%--     --%>
<%--var s1 = [200, 600, 700, 1000];--%>
<%--var s2 = [460, -210, 690, 820];--%>
<%--var s3 = [-260, -440, 320, 200];--%>
<%--// Can specify a custom tick Array.--%>
<%--// Ticks should match up one for each y value (category) in the series.--%>
<%--var ticks = ['May', 'June', 'July', 'August'];--%>

    var plot1 = $.jqplot('chart1', [s1, s2], {
        // The "seriesDefaults" option is an options object that will
        // be applied to all series in the chart.
        seriesDefaults:{
            renderer:$.jqplot.BarRenderer,
            rendererOptions: {fillToZero: true}
        },
        // Custom labels for the series are specified with the "label"
        // option on the series option.  Here a series option object
        // is specified for each series.
        series:[
            {label:'Admission'},
            {label:'Discharge'},
            {label:'Airfare'}
        ],
        // Show the legend and put it outside the grid, but inside the
        // plot container, shrinking the grid to accomodate the legend.
        // A value of "outside" would not shrink the grid and allow
        // the legend to overflow the container.
        legend: {
            show: true,
            placement: 'outsideGrid'
        },
        axes: {
            // Use a category axis on the x axis and use our custom ticks.
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks
            },
            // Pad the y axis just a little so bars can get close to, but
            // not touch, the grid boundaries.  1.2 is the default padding.
            yaxis: {
                pad: 1.05,
                tickOptions: {formatString: '$%d'}
            }
        }
    });
});
</script>
  <body>
  <p>Admission Vs. Discharge</p>
    <div id="chart1"></div>
  </body>
</html>