<!DOCTYPE html>
<html>
	<head>
		<title>¿Que comemos hoy? - Crear Usuario</title>
	</head>
  <body>
    <h1>Ingrese sus datos</h1>
    <form action="500" method="POST">
    	<label>Nombre</label><input type="text" name="nombre"><br>
    	<label>Apellido</label><input type="text" name="apellido"><br>
		  <input type="radio" name="sexo" value="m">Masculino<br>
  		<input type="radio" name="sexo" value="f">Femenino<br>
    	Fecha Nacimiento<input type="date" name="fechaNacimiento" max="2000-12-31"><br><br>
		  Altura (cm)<input type="number" name="alturaEnCentimetros" min="100"><br>
		  Peso<input type="number" name="peso" min="90"><br>
		  Dieta<input type="text" name="dieta"><br>
    	Usuario:<input type="text" name="id"><br>
		  Password:<input type="password" name="password"><br>
    	<input type="submit" value="Ingresar">
	  </form>
  </body>
</html>
