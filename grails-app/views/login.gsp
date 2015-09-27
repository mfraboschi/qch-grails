<!DOCTYPE html>
<html>
	<head>
		<title>¿Que comemos hoy? - Ingresar</title>
	</head>
  <body>
    <g:form name="formLogin" controller="app" action="autenticar">
    	Usuario:<g:textField name="id"/><br>
		  Password:<g:passwordField name="password"/><br>
    	<g:submitButton name="ingresar" value="Ingresar"/>
    </g:form>
  </body>
</html>
