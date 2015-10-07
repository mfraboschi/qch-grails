<%@ page import="qch.enums.Sexo" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Rutina" %>
<%@ page import="qch.enums.Contextura" %>
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
    <h1><a href="index.html"></a></h1>
    <h2>¿Qué comemos hoy?</h2>
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
        <g:each var="historia" in="${historial}">
            <tr>
                <td><label>${historia.receta.nombre}</label></td>
                <td><label>${historia.fechaCreacion}</label></td>
            </tr>
        </g:each>
        </table>
        <label style="color: #cc0000">${mensaje}</label>
    </section>
    <!-- end mainRight -->
</section>
<!-- end mainContent -->
<footer>
    <p>&copy;2015 UTN - Diseño de Sistemas &nbsp;&nbsp; </p>
</footer>
</body>
</html>