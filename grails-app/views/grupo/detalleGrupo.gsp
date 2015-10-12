<%@ page import="qch.enums.CategoriaEnum" %>
<%--
  Created by IntelliJ IDEA.
  User: mfraboschi
  Date: 28/9/15
  Time: 0:02
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width" />
    <title>¿Qué comemos hoy?</title>
    <asset:stylesheet href="default.css"/>
    <!--[if IE]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<header>
    <h1><a href="/"></a></h1>
    <h2>¿Qué comemos hoy?</h2>
</header>
<section id="mainContent" class="clear">
    <nav>
        <h3>Menu</h3>
        <ul>
            <li><a href="/que-comemos-hoy/receta/index">Home</a></li>
            <li><a href="/que-comemos-hoy/grupo/index">Crear Grupo</a></li>
            <li><a href="/que-comemos-hoy/historial/historialRecetas">Tu historial</a></li>
        </ul>
    </nav>
    <section id="mainRight">
        <ul>
            <b><h2>${grupo.nombre}</h2></b>
            <ul style="list-style:initial">
            <b>Descipcion: </b>
               ${grupo.descripcion}
            </div>
            <p><b>Creador: </b>
                ${grupo.creador.nombre}</p>
            </ul>
			 <b><g:link style="color:red" action="unirseAGrupo" id="${grupo.id}">${abandonar}</g:link></b>
             <b><g:link style="color:#85A32F" action="unirseAGrupo" id="${grupo.id}">${unirse}</g:link></b>
             
             <div style="text-align: center; margin-top: 10px">
                <label style="color: green; font-size: large;">${exito}</label>
            </div>
        </ul>
    </section>
    <!-- end mainRight -->
</section>
<!-- end mainContent -->
<footer>
    <p>&copy;2015 UTN - Diseño de Sistemas &nbsp;&nbsp; </p>
</footer>
</body>
</html>