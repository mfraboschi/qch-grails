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
        <h1>Recetas recomendadas</h1>
        <label>Bienvenido ${usuario.nombre}</label>
        <ul>
            <g:each var="receta" in="${recetas}">
                <li>
                    <g:link action="detalle" id="${receta.id}">${receta.nombre}</g:link>
                </li>
            </g:each>
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