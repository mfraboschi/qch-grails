<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>
<!DOCTYPE html>
<html>
	<head>
		<title>¿Que comemos hoy? - Crear Usuario</title>
	</head>
  <body>
    <h1>Ingrese sus datos</h1>
    <g:form name="formNuevoUsuario" controller="usuario" action="guardarUsuario">
    	Nombre: <g:textField name="nombre"/><br>
			-----------------------------<br>
			Usuario: <g:textField name="nickName"/><br>
		  Password: <g:passwordField name="password"/><br>
			-----------------------------<br>
			Fecha Nacimiento: <input type="text" name="fechaNacimiento"/><br>
		  Altura (cm): <g:textField name="alturaEnCentimetros"/><br>
		  Peso (g): <g:textField name="pesoEnGramos"/><br>
			-----------------------------<br>
			Sexo: <g:select name="sexo" from="${Sexo.values()}" valueMessagePrefix="ENUM.Sexo"/><br>
			Contextura: <g:select name="contextura" from="${Contextura.values()}" valueMessagePrefix="ENUM.Contextura"/><br>
			Dieta: <g:select name="dieta" from="${Dieta.values()}" valueMessagePrefix="ENUM.Dieta"/><br>
			Rutina: <g:select name="rutina" from="${Rutina.values()}" valueMessagePrefix="ENUM.Rutina"/><br><br>
    	<g:submitButton name="ingresar" value="Ingresar"/>
	  </g:form>
  </body>
</html>
