<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>
<!DOCTYPE html>
<html>
	<head>
		<title>¿Que comemos hoy? - Crear Grupo</title>
	</head>
  <body>
    <h1>Ingrese sus datos</h1>
    <g:form name="formNuevoGrupo" controller="grupo" action="guardarGrupo">
    	
    	Nombre: <g:textField name="nombre"/><br>
			
    	<g:submitButton name="ingresar" value="Ingresar"/>
	  </g:form>
  </body>
</html>
