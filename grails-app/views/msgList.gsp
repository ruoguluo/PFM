<html>
<body>

<g:javascript library="jquery" plugin="jquery"/>

<h1>Message List</h1>

<p>Now you can send it one by one:</p>

<%
def i=0
def msgs = []
def file = new File('c:\\tmp\\testData.txt')
file.eachLine{line->
	//println line
	msgs.add(line)
}
%>

<g:while test="${i < msgs.size}">
   <g:form>
    <p> <g:submitToRemote controller="message" action="save" value="send"/> <%=msgs.get(i)%></p>
    <input type="hidden" name="body" value="<%=msgs.get(i)%>"/>

   </g:form>
    <%i++%>
   
</g:while>

<br/>
<%=msgs.size()%> messages

</body>
</html>
