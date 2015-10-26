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
            <li><a href="/que-comemos-hoy/grupo/index">Crear Grupo</a></li>
            <li><a href="/que-comemos-hoy/historial/historialRecetas">Tu historial</a></li>
            <li><a href="/que-comemos-hoy/grupo/verGrupos">Ver Grupos</a></li>
        </ul>
    </nav>
    <section id="mainRight">
        <h1>Buscador de Recetas</h1>
        <div>
            <g:form controller="receta" action="buscar">
                <g:select name="dificultad" from="${qch.enums.Dificultad.values()}" noSelection="['':'Dificultad']"></g:select>
                <g:select name="dieta" from="${qch.enums.Dieta.values()}" noSelection="['':'Dieta']"></g:select>
                <g:select name="contraindicacion" from="${qch.enums.CondicionPreexistente.values()}" noSelection="['':'Contraindicacion']"></g:select>
                <g:submitButton name="submit">Buscar</g:submitButton>
            </g:form>
        </div>
        <div>
        <ul style="margin-left:0px; font-size:15px;">
            <g:each var="receta" in="${recetas}">
                <li>
                    <div style="display: inline-block; border-style: solid; border-color: #E3E0BB; height: 55px; width: 500px;">
                        <b><g:link style="color:#85A32F" action="detalle" id="${receta.id}">${receta.nombre}</g:link></b>
                    </div>
                </li>
            </g:each>
        </ul>
        </div>
    </section>
    <!-- end mainRight -->
</section>
<!-- end mainContent -->
<footer>
    <p>&copy;2015 UTN - Diseño de Sistemas &nbsp;&nbsp; </p>
</footer>
</body>
</html>