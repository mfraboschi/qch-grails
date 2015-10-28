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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
    <script>
    $(document).ready(function() {
        var frm = $('#calificar');
        $('#calificar').submit(function () {
            $.ajax({
                type: frm.attr('method'),
                url: frm.attr('action'),
                data: frm.serialize(),
                success: function (data) {
                    $('#form-calificar').hide();
                    $('#calificacion').text('¡Gracias por dejar tu opinión!');
                }
            });

            return false;
        });

        var frmSelec =  $('#seleccionar');
        frmSelec.submit(function () {
            $.ajax({
                type: frmSelec.attr('method'),
                url: frmSelec.attr('action'),
                data: frmSelec.serialize(),
                success: function (data) {
                    $('#seleccionar-div').hide();
                    $('#mensaje-exito').text('¡Seleccionaste la Receta!');
                }
            });

            return false;
        });


    });
    </script>
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
            <li><a href="/que-comemos-hoy/grupo/index">Crear Grupo</a></li>
            <li><a href="/que-comemos-hoy/grupo/verGrupos">Ver Grupos</a></li>
        </ul>
    </nav>
    <section id="mainRight">
        <ul>
            <b><h2>${receta.nombre}</h2></b>
            <ul style="list-style:initial">
            <g:each var="procedimiento" in="${receta.procedimientos}">
                <li>${procedimiento}</li>
            </g:each>
            </ul>
            <table>
                <tr>
                    <td style="width: 200px">
                        <b><div style="text-align: center">Ingredientes</div></b>
                        <ul class="lista-ingredientes">
                            <g:each var="ingrediente" in="${receta.ingredientes}">
                                <li>${ingrediente.ingrediente.nombre} ${ingrediente.cantidadGramos}grs</li>
                            </g:each>
                        </ul>
                    </td>
                    <td style="padding-left: 140px;">
                        <div><img src="http://www.cocinerosargentinos.com/images/1_bondiola-con-salsa-de-panceta-y-porotos-con-batatas-agridulces.jpg"></div>
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
        <form action="/que-comemos-hoy/receta/seleccionar/${receta.id}" id="seleccionar" method="post">
            <div style="text-align: center;" id="seleccionar-div">
                        <input style="width: 150px;" type="submit" value="Seleccionar"/>
            </div>
            <div style="text-align: center; margin-top: 10px">
                <label id="mensaje-exito" style="color: green; font-size: large;">${exito}</label>
            </div>
        </form>
        <g:if test="${!calificacion}">
        <div style="text-align:center; margin-top:20px;">
        <div style="width:250px; border: #E3E0BB; border-style: solid; display: inline-block;" id="form-calificar">
            <h1 style="margin-bottom: 5px;">Calificar receta</h1>
            <form id="calificar" action="/que-comemos-hoy/receta/calificar/${receta.id}" method="post">
                <div style="text-align:center;">
                    <span class="rating">
                        <input type="radio" class="rating-input"
                               id="rating-input-1-5" name="calificacion" value="5">
                        <label for="rating-input-1-5" class="rating-star" ></label>
                        <input type="radio" class="rating-input"
                               id="rating-input-1-4" name="calificacion" value="4">
                        <label for="rating-input-1-4" class="rating-star"></label>
                        <input type="radio" class="rating-input"
                               id="rating-input-1-3" name="calificacion" value="3">
                        <label for="rating-input-1-3" class="rating-star"></label>
                        <input type="radio" class="rating-input"
                               id="rating-input-1-2" name="calificacion" value="2">
                        <label for="rating-input-1-2" class="rating-star"></label>
                        <input type="radio" class="rating-input"
                               id="rating-input-1-1" name="calificacion" value="1">
                        <label for="rating-input-1-1" class="rating-star"></label>
                    </span>
                </div>
                <div style="text-align:center; margin-top: 5px;">
                    <input type="submit" value="Enviar"/>
                </div>
            </form>
        </div>
        <div style="text-align: center; margin-top: 10px">
            <label id="calificacion" style="color: green; font-size: large;"></label>
        </div>
        </g:if>
    </section>
    <!-- end mainRight -->
</section>
<!-- end mainContent -->
<footer>
    <p>&copy;2015 UTN - Diseño de Sistemas &nbsp;&nbsp; </p>
</footer>
</body>
</html>