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
    <title>¿Qué comemos hoy? - Ver Grupo</title>
    <asset:stylesheet href="default.css"/>
</head>
<body>
<header>
    <h1><a href="/que-comemos-hoy/receta/index"></a></h1>
    <h2>¿Qué comemos hoy?</h2>
    <h4><a style="color: black" href="/que-comemos-hoy/usuario/perfil">${usuario.nombre}</a>  |  <a style="color: #2E5C8A" href="/que-comemos-hoy/">Log Out</a></h4>
</header>
<section id="mainContent" class="clear">
    <nav>
        <h3>Menu</h3>
        <ul>
            <li><a href="/que-comemos-hoy/receta/index">Home</a></li>
            <li><a href="/que-comemos-hoy/grupo/index">Mis Grupos</a></li>
            <li><a href="/que-comemos-hoy/grupo/verGrupos">Ver Grupos</a></li>
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
                ${grupo.creadorId}</p>
                <b><g:link                 action="verMiembros" id="${grupo.id}">${miembros}</g:link></b>

            </ul>
             <div style="display: inline-block; border-style: solid; border-color: #E3E0BB; height: 20px; width: 120px;">
             <b><g:link style="color:blue" action="eliminarGrupo" id="${grupo.id}">${eliminar}</g:link></b>
			 <b><g:link style="color:red" action="abandonarGrupo" id="${grupo.id}">${abandonar}</g:link></b>
             <b><g:link style="color:green" action="unirseAGrupo" id="${grupo.id}">${unirse}</g:link></b>

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
