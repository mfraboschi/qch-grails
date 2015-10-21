<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width"/>
        <title>¿Qué comemos hoy? - Mis grupos</title>
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
                    <li><a href="/que-comemos-hoy/grupo/crearGrupo">Crear grupo nuevo</a></li>
                    <li><a href="/que-comemos-hoy/grupo/verGrupos">Ver grupos</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Mis Grupos</h1>
                <div>
                    <ul style="margin-left:0px; font-size:15px;">
                        <g:each var="grupo" in="${grupos}">
                            <li>
                                <div style="display: inline-block; border-style: solid; border-color: #E3E0BB; height: 55px; width: 500px;">
                                    <b><g:link style="color:#85A32F" action="detalle" id="${grupo.id}">${grupo.nombre}</g:link></b>
                                </div>
                            </li>
                        </g:each>
                    </ul>
                </div>
                <label style="color: red">${mensaje}</label>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
