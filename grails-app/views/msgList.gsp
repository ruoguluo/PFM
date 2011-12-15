<html>
<body>

<g:javascript library="jquery" plugin="jquery"/>

<h1>Message List</h1>

<div>Now you can send it one by one</div>
<div>or by one click to execute all &nbsp; <button type="button" id="all">Click</button></div>
<div>or to execute to certain check point:&nbsp;<input size=2 id="cp"/>&nbsp;<button type="button" id="uptoCertainPoint">Click</button></div>

<%
def i=0
def msgs = []
def file = new File(application.getRealPath("/")+'/testData.txt')
file.eachLine{line->
	//println line
	msgs.add(line)
}
%>

<script>
$.ajaxSetup ({
	cache: false
});



var checkPoint=<%=msgs.size%>

var sendMsgs=function (){

	var counter = 0;
	<% for (i=0;i<msgs.size;i++){%>
	$.ajax({
		url:'message/save2',
		type:'post',
		async:false,
		data:{body:"<%=msgs.get(i)%>"},
	});	
	if (counter>=checkPoint) return;
	counter++;
	<%}
	i=0;
	%>
	
}

var sendSomeMsgs=function(){
	checkPoint=document.getElementById("cp").value
	sendMsgs()
	checkPoint=<%=msgs.size%>
}

$('#all').click(sendMsgs)

$('#uptoCertainPoint').click(sendSomeMsgs)

</script>

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
