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
            <li><a href="/que-comemos-hoy/login">Login</a></li>
            <li><a href="/que-comemos-hoy/crearUsuario">Crear usuario</a></li>
            <li><a href="about.html">Últimas recetas</a></li>
        </ul>
    </nav>
    <section id="mainRight">
        <ul>
            <h1>${receta.nombre}</h1>
            <ul>
            <g:each var="procedimiento" in="${receta.procedimientos}">
                <li>${procedimiento}</li>
            </g:each>
            </ul>
            <table>
                <tr>
                    <td><label>Dificultad: </label></td>
                    <td><label>${receta.dificultad}</label></td>
                </tr>
                <tr>
                    <td><label>Dieta: </label></td>
                    <td><label>${receta.dieta}</label></td>
                </tr>
                <tr>
                    <td><label>Contraindicaciones: </label></td>
                    <td><label><g:each var="contraind" in="${receta.contraindicaciones}">${contraind.condicionPreexistente} </g:each></label></td>
                </tr>
            </table>
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