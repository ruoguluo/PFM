<html>
<body>

<g:javascript library="jquery" plugin="jquery"/>

<h1>Message List</h1>

<p>Now you can send it one by one</p>
<div><u id="all">or by one click</u></div>
<input type="hidden" id="result"/>

<%
def i=0
def msgs = []
def file = new File('c:\\tmp\\testData.txt')
file.eachLine{line->
	//println line
	msgs.add(line)
}
%>

<script>
$.ajaxSetup ({
	cache: false
});

$('#all').click(function(){
	//alert('all');
	<% for (i=0;i<msgs.size;i++){%>
	$.ajax({
		url:'message/save2',
		type:'post',
		async:false,
		data:{body:"<%=msgs.get(i)%>"},
	});	
		
	<%}
	i=0;
	%>
	alert("done!");
})
</script>

<g:while test="${i < msgs.size}">
   <g:form>
    <p> <g:submitToRemote controller="message" action="save2" value="send"/>
    <input name="body" size="200" value="<%=msgs.get(i)%>"/>
     </p>
<%--    <input type="hidden" name="body" value="<%=msgs.get(i)%>"/>--%>

   </g:form>
    <%i++%>
   
</g:while>

<br/>
<%=msgs.size()%> messages

</body>
</html>
