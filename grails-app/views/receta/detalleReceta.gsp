<%@ page import="qch.enums.CategoriaEnum" %>
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
            <li><a href="/que-comemos-hoy/receta/index">Home</a></li>
            <li><a href="/que-comemos-hoy/historial/historialRecetas">Tu historial</a></li>
        </ul>
    </nav>
    <section id="mainRight">
        <ul>
            <b><h2>${receta.nombre}</h2></b>
            <label style="color: green">${exito}</label>
            <ul style="list-style:initial">
            <g:each var="procedimiento" in="${receta.procedimientos}">
                <li>${procedimiento}</li>
            </g:each>
            </ul>
            <table>
                <tr>
                    <td>
                        <b><label>Ingredientes:</label></b>
                        <ul style="list-style:initial">
                            <g:each var="ingrediente" in="${receta.ingredientes}">
                                <li>${ingrediente.ingrediente.nombre} ${ingrediente.cantidadGramos}grs</li>
                            </g:each>
                        </ul>
                    </td>
                    <td style="padding-left: 180px;">
                        <table>
                            <tr>
                                <td><label><b>Dificultad: </b></label></td>
                                <td><label>${receta.dificultad}</label></td>
                            </tr>
                            <tr>
                                <td><label><b>Dieta: </b></label></td>
                                <td><label>${receta.dieta}</label></td>
                            </tr>
                            <tr>
                                <td><label><b>Contraindicaciones: </b></label></td>
                                <td><label><g:each var="contraind" in="${receta.contraindicaciones}">${contraind.condicionPreexistente} </g:each></label></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </ul>
        <form action="/que-comemos-hoy/receta/seleccionar/${receta.id}">
        <table>
            <tr>
                <td>
                    <input type="submit" value="Seleccionar"/>
                </td>
            </tr>
        </table>
        </form>
    </section>
    <!-- end mainRight -->
</section>
<!-- end mainContent -->
<footer>
    <p>&copy;2015 UTN - Diseño de Sistemas &nbsp;&nbsp; </p>
</footer>
</body>
</html>