<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>
<%@ page import="qch.enums.CondicionPreexistente" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width"/>
        <title>¿Qué comemos hoy? - Nuevo Usuario</title>
        <asset:stylesheet href="default.css"/>
    </head>
    <body>
        <header>
            <h1><a href="/que-comemos-hoy/"></a></h1>
            <h2>¿Qué comemos hoy?</h2>
        </header>
        <section id="mainContent" class="clear">
            <nav>
                <h3>Menu</h3>
                <ul>
                    <li><a href="/que-comemos-hoy/usuario/login">Login</a></li>
                    <li><a href="/que-comemos-hoy/usuario/crearUsuario">Crear usuario</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Ingrese sus datos</h1>
                <g:form name="formNuevoUsuario" controller="usuario" action="guardarUsuario">
                    <table>
                        <tr>
                            <td><label for="name">Nombre:</label></td>
                            <td><g:textField id="name" name="nombre"/></td>
                        </tr>
                        <tr>
                            <td><label for="surname">Apellido:</label></td>
                            <td><g:textField id="surname" name="apellido"/></td>
                        </tr>
                        <tr><td></td></tr>
                        <tr><td></td></tr>
                        <tr>
                            <td><label for="nick">Nombre de Usuario:</label></td>
                            <td><g:textField id="nick" name="nickName"/></td>
                        </tr>
                        <tr>
                            <td><label for="pass">Contraseña:</label></td>
                            <td><g:passwordField id="pass" name="password"/></td>
                        </tr>
                        <tr><td></td></tr>
                        <tr><td></td></tr>
                        <tr>
                            <td><label>Fecha de Nacimiento:</label></td>
                            <td><g:datePicker name="fechaNacimiento" value="${new Date()}" precision="day" years="${1930..2010}"/></td>
                        </tr>
                        <tr>
                            <td><label for="height">Altura (cm):</label></td>
                            <td><g:textField id="height" name="alturaEnCentimetros"/></td>
                        </tr>
                        <tr>
                            <td><label for="weight">Peso (g):</label></td>
                            <td><g:textField id="weight" name="pesoEnGramos"/></td>
                        </tr>
                        <tr>
                            <td><label>Sexo:</label></td>
                            <td><g:select name="sexo" from="${Sexo.values()}" valueMessagePrefix="ENUM.Sexo"/></td>
                        </tr>
                        <tr>
                            <td><label>Contextura:</label></td>
                            <td><g:select name="contextura" from="${Contextura.values()}" valueMessagePrefix="ENUM.Contextura"/></td>
                        </tr>
                        <tr>
                            <td><label>Dieta:</label></td>
                            <td><g:select name="dieta" from="${Dieta.values()}" valueMessagePrefix="ENUM.Dieta"/></td>
                        </tr>
                        <tr>
                            <td><label>Rutina:</label></td>
                            <td><g:select name="rutina" from="${Rutina.values()}" valueMessagePrefix="ENUM.Rutina"/></td>
                        </tr>
                        <tr><td></td></tr>
                        <tr>
                            <td><label>Condiciones Prexistentes:</label></td>
                            <td><g:checkBox name="boxDiabetes" value="${CondicionPreexistente.DIABETES}"/> Diabetes</td>
                            <!--td><g:checkBox name="boxDiabetes" value="${CondicionPreexistente.DIABETES}"/> Diabetes</td-->
                        </tr>
                        <tr>
                            <td></td>
                            <td><g:checkBox name="boxHipertenso" value="${CondicionPreexistente.HIPERTENSION}"/> Hipertensión</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><g:checkBox name="boxCeliaco" value="${CondicionPreexistente.CELIAQUIA}"/> Celiaquia</td>
                        </tr>
                        <tr><td></td></tr>
                        <tr>
                            <td><g:submitButton name="ingresar" value="Crear"/></td>
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
