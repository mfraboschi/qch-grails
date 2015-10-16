<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width" />
        <title>¿Qué comemos hoy? - Login</title>
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
                <h1>Ingresar</h1>
                <g:form name="formLogin" controller="usuario" action="autenticar">
                    <table>
                        <tr>
                            <td><label for="nick">Usuario:</label></td>
                            <td><g:textField id="nick" name="nickname"/></td>
                        </tr>
                        <tr>
                            <td><label for="pass">Contraseña:</label></td>
                            <td><g:passwordField id="pass" name="password"/></td>
                        </tr>
                        <tr>
                            <td colspan="3"></td>
                        </tr>
                        <tr>
                            <td><g:submitButton name="ingresar" value="Aceptar"/></td>
                        <tr>
                    </table>
                </g:form>
                <label style="color: red">${mensaje}</label>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
