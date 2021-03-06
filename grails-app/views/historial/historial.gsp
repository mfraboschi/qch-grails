<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width" />
        <title>¿Qué comemos hoy? - Historial</title>
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
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Tu historial</h1>
                <table>
                    <tr>
                        <td><h4><a style="color: black">Receta</a></h4></td>
                        <td><h4><a style="color: black">Fecha Selección</a></h4></td>
                    </tr>
                    <g:each var="historia" in="${historial}">
                        <tr>
                            <td><label>${historia.receta.nombre}</label></td>
                            <td><label><g:formatDate format="dd-MM-yyyy, HH:mm:ss" date="${historia.fechaCreacion}"/></label></td>
                        </tr>
                    </g:each>
                </table>
                <label style="color: #cc0000">${mensaje}</label>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
