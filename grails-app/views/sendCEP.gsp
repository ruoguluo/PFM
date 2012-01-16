<%@ page import="groovy.io.FileType" %>


<%

def folder = application.getRealPath("/xml")
def baseDir = new File(folder)
def files =[]
def fileContents = []
baseDir.eachFileRecurse(FileType.FILES){
        files<<it.name
        def t =""
        it.eachLine{
                t+=it+"\n"
        }
        fileContents<<t
}        
def fileName = request.getParameter("fileName")
if (fileName==null) fileName = files[0]
%>
<g:javascript library="jquery" plugin="jquery"/>
<script>

var fileContents =[]

function loadTestCase(fileName){
        //window.location="<%=request.getContextPath() %>/msgList.gsp?fileName="+fileName;
}

var changeTestCase=function(){
	//alert(this.selectedIndex);
	$('#body').val(fileContents[this.selectedIndex]);
	$('#loaded').hide();
}

$(document).ready(function() {

<% fileContents.each{
%>
fileContents.push(<%=it%>);
<%
}
%>	
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


})
</script>
<html>
<g:javascript library="jquery" plugin="jquery"/>
<body>

<p>send CEP event</p>
<p>
<g:select from="${files}" name="testCase" value="${fileName}"/>
<div id="loadingDiv"><img src="<%=request.getContextPath() %>/images/spinner.gif"/></div>
<div id="loaded">Sent</div>
</p>

   <g:form>
   
   <textarea name="body" id="body" rows="15" cols="60">
   <%=fileContents[0] %>
   </textarea>

    <g:submitToRemote controller="message" action="sendCEP" value="send"/>

   </g:form>

</body>
</html>
