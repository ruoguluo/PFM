<%@ page import="groovy.io.FileType" %>

<%
def i=0
def msgs = []
def msgs_js = []

def folder = application.getRealPath("/txt")
def baseDir = new File(folder)
def files =[]
baseDir.eachFileRecurse(FileType.FILES){
	files<<it.name
}

def fileName = request.getParameter("fileName")
if (fileName==null) fileName = files[0]

def file = new File(application.getRealPath("/txt")+'/'+fileName)
file.eachLine{line->
	//println line
	msgs.add(line)
	msgs_js.add("'${line}'");
}
%>

<html>
<nav:resources/>
<g:javascript library="jquery" plugin="jquery"/>
<script>
$.ajaxSetup ({
	cache: false
});

var msgs_js = <%=msgs_js%>;

var checkPoint=<%=msgs.size-1%>

var sendMsgs=function (){

	for (var i=0;i<=checkPoint;i++){
	
		$.ajax({
			url:'message/save2',
			type:'post',
			async:false,
			data:{body:msgs_js[i]},
		});	
	}
	//alert("done!")
}

var sendSomeMsgs=function(){
	checkPoint=$("#cp").val()
	sendMsgs()
	checkPoint=<%=msgs.size-1%>
}

function loadTestCase(fileName){
	window.location="<%=request.getContextPath() %>/msgList.gsp?fileName="+fileName;
}

var changeTestCase=function(){
	//alert($('#testCase').val());
	loadTestCase($('#testCase').val());
}


$(document).ready(function() {

	$('#all').click(sendMsgs);
	$('#uptoCertainPoint').click(sendSomeMsgs);
	$('#testCase').change(changeTestCase);

	$('#loadingDiv')
	.hide()  // hide it initially
	.ajaxStart(function() {
	    $(this).show();
	})
	.ajaxStop(function() {
	    $(this).hide();
	})
	;

	$('#loaded')
	.hide()  // hide it initially
	.ajaxStart(function() {
	    $(this).hide();
	})
	.ajaxStop(function() {
	    $(this).show();
	})
	;

})

</script>
<body>
<div><nav:render group="tabs"/></div>
<h1>Message List</h1>
<div align="right">
Select a test case:</br>

<g:select from="${files}" name="testCase" value="${fileName}"/>

</div>
<div>Now you can send it one by one</div>
<div>or by one click to send all in a sequence &nbsp; <button type="button" id="all">Click</button></div>
<div>or to send till reach a certain check point:&nbsp;<input size=2 id="cp"/>&nbsp;<button type="button" id="uptoCertainPoint">Click</button></div>
<div id="loadingDiv"><img src="<%=request.getContextPath() %>/images/spinner.gif"/></div>
<div id="loaded">Sent</div>
<g:while test="${i < msgs.size}">
   <g:form>
    <p> <%=i %>&nbsp;
    <input name="body" size="150" value="<%=msgs.get(i)%>"/> 
    <g:submitToRemote controller="message" action="save2" value="send"/>
     </p>
<%--    <input type="hidden" name="body" value="<%=msgs.get(i)%>"/>--%>

   </g:form>
    <%i++%>
   
</g:while>

<br/>
<%=msgs.size()%> messages

</body>
</html>
