<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width"/>
        <title>¿Qué comemos hoy? - Crear Grupo</title>
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
                    <li><a href="/que-comemos-hoy/grupo/index">Mis grupos</a></li>
                    <li><a href="/que-comemos-hoy/grupo/verGrupos">Buscar Grupos</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Ingrese los datos del Grupo</h1>
                <g:form name="guardarGrupo" controller="grupo" action="nuevoGrupo">
                    <table>
                        <tr>
                            <td><label for="name">Nombre:</label></td>
                            <td><g:textField id="name" name="nombre"/></td>
                        </tr>
                        <tr>
                            <td><label for="description">Descripcion:</label></td>
                            <td><g:textArea rows="4" cols="55" id="description" name="descripcion"/></td>
                        </tr>
                        <tr>
                            <td colspan="3"></td>
                        </tr>
                        <tr>
                            <td><g:submitButton name="ingresar" value="Crear"/></td>
                        </tr>
                    </table>
                </g:form>
                <label style="color: #cc0000">${error}</label>
                <label style="color: green">${exito}</label>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
