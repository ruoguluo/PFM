<%@ page import="groovy.io.FileType" %>

<html>
<g:javascript library="jquery" plugin="jquery"/>
<body>

<p>send CEP event</p>

   <g:form>
   
   <textarea name="body" rows="15" cols="60">
   
   </textarea>

    <g:submitToRemote controller="message" action="sendCEP" value="send"/>

   </g:form>

</body>
</html>