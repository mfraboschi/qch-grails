<!DOCTYPE html>
<html>
	<head>
		<title>¿Que comemos hoy? - Ingresar</title>
	</head>
  <body>
    <g:form name="formLogin" controller="usuario" action="autenticar">
    	Usuario:<g:textField name="nickname"/><br>
		  Password:<g:passwordField name="password"/><br>
    	<g:submitButton name="ingresar" value="Ingresar"/>
    </g:form>
    <label>${mensaje}</label>
  </body>
</html>
