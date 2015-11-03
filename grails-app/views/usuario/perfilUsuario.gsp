<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width"/>
        <title>¿Qué comemos hoy? - Mi perfil</title>
        <asset:stylesheet href="default.css"/>
    </head>
    <body>
        <header>
            <h1><a href="/que-comemos-hoy/receta/index"></a></h1>
            <h2>¿Qué comemos hoy?</h2>
            <h4><a style="color: #2E5C8A" href="/que-comemos-hoy/">Log Out</a></h4>
        </header>
        <section id="mainContent" class="clear">
            <nav>
                <h3>Menu</h3>
                <ul>
                  <li><a href="/que-comemos-hoy/receta/index">Home</a></li>
                  <li><a href="/que-comemos-hoy/receta/todas">Mis recetas</a></li>
                  <li><a href="/que-comemos-hoy/grupo/index">Mis grupos</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Mis datos</h1>
                <g:form name="formActualizarUsuario" controller="usuario" action="actualizar">
                    &nbspNombre: <b>${usuario.nombre}</b><br>
                    &nbspID Usuario: <b>${usuario.nickName}</b><br><br>
                    &nbspFecha de Nacimiento: <b><g:formatDate format="dd-MM-yyyy" date="${usuario.fechaNacimiento}"/></b><br>
                    &nbspAltura (cm): <b>${usuario.alturaEnCentimetros}</b><br>
                    &nbspSexo: <b>${usuario.sexo}</b><br><br>
                    <table>
                        <tr>
                            <td>Condiciones Prexistentes: </td>
                                <g:each var="condicion" in="${usuario.condiciones}">
                                    <td><b>${condicion}</b></td>
                                    </tr><tr><td></td>
                                </g:each>
                                <td><label><b>${ninguna}</b></label></td>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="weight">Peso (g):</label></td>
                            <td><g:textField id="weight" name="pesoEnGramos" value="${usuario.pesoEnGramos}"/></td>
                        </tr>
                        <tr>
                            <td><label>Contextura:</label></td>
                            <td><g:select name="contextura" from="${Contextura.values()}" value="${usuario.contextura}" valueMessagePrefix="ENUM.Contextura"/></td>
                        </tr>
                        <tr>
                            <td><label>Dieta:</label></td>
                            <td><g:select name="dieta" from="${Dieta.values()}" value="${usuario.dieta}" valueMessagePrefix="ENUM.Dieta"/></td>
                        </tr>
                        <tr>
                            <td><label>Rutina:</label></td>
                            <td><g:select name="rutina" from="${Rutina.values()}" value="${usuario.rutina}" valueMessagePrefix="ENUM.Rutina"/></td>
                        </tr>
                        <tr><td></td></tr>
                        <tr>
                            <td><g:submitButton name="ingresar" value="Guardar"/></td>
                        </tr>
                    </table>
                </g:form>
                <label style="color: red">${error}</label>
                <label style="color: green">${exito}</label>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
