<!DOCTYPE html>
<html>
	<head>
		<title>¿Que comemos hoy? - Crear Usuario</title>
	</head>
  <body>
    <h1>Ingrese sus datos</h1>
    <g:form name="formNuevoUsuario" controller="app" action="guardarUsuario">
    	<label>Nombre</label><g:textField name="nombre"/><br>
		  <g:radio name="sexo" value="m"/>Masculino<br>
  		<g:radio name="sexo" value="f"/>Femenino<br>
    	Fecha Nacimiento<g:formatDate name="fechaNacimiento" date="${new Date()}"/><br><br>
		  Altura (cm)<g:textField name="alturaEnCentimetros"/><br>
		  Peso<g:textField name="pesoEnGramos"/><br>
    	Usuario:<g:textField name="id"/><br>
		  Password:<g:passwordField name="password"/><br>
    	<g:submitButton name="ingresar" value="Ingresar"/>
	  </g:form>
  </body>
</html>
