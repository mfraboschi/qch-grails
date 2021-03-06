<%@ page import="qch.enums.CategoriaEnum" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width" />
        <title>¿Qué comemos hoy? - ${receta.nombre}</title>
        <asset:stylesheet href="default.css"/>
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

                var frmSelec =  $('#formSeleccionar');
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
            <h1><a href="/que-comemos-hoy/receta/index"></a></h1>
            <h2>¿Qué comemos hoy?</h2>
            <h4><a style="color: black" href="/que-comemos-hoy/usuario/perfil">${usuario.nombre}</a>  |  <a style="color: #2E5C8A" href="/que-comemos-hoy/">Log Out</a></h4>
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
                <ul>
                    <b style="font-size: 1.4em"><h2>${receta.nombre}</h2></b>
                 
                    </ul>
                    
                    <td><img src="${receta.urlImagen}" style="width: 55%; height: 55%"></td>
                    <p>
                    </p><p>
                    </p>
                    <table>
                        <tr>                            
                            <td style="width: 240px">
                                <b><div>Ingredientes</div></b>
                                <ul class="lista-ingredientes">
                                    <g:each var="ingrediente" in="${receta.ingredientes}">
                                        <li>${ingrediente.ingrediente.nombre} ${ingrediente.cantidadGramos} grs</li>
                                    </g:each>
                                </ul>
                            </td>
                            <td style="width: 210px">
                                <b><div>Condimentos</div></b>
                                <ul class="lista-ingredientes">
                                    <g:each var="condimento" in="${receta.condimentos}">
                                        <li>${condimento.condimento.nombre} ${condimento.cantidadEnMiligramos} mgrs</li>
                                    </g:each>
                                </ul>
                            </td>
                        </tr>
                    </table>
                    <div style="text-align: center">----------------------------------------------------------------------------------------</div><br>
                    <table style="margin-left: 3%">
                        <tr>
                            <td>
                             <ul>
                    <h4><u><b>Procedimiento:</b></u></h4>
                    <ul style="list-style:initial">
                    <g:each var="procedimiento" in="${receta.procedimientos}">
                        <li>${procedimiento}</li>
                    </g:each>
                    </ul>
                    <p>
                    </p>
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
                <p>
                    </p>
                <g:form name="formSeleccionar" controller="receta" action="seleccionar">
                    <div style="text-align: center;">
                        <input type="hidden" name="id" value="${receta.id}" />
                        <input style="width: 150px;" type="submit" value="Seleccionar"/>
                    </div>
                    <div style="text-align: center; margin-top: 10px">
                        <label id="mensaje-exito" style="color: green; font-size: large;">${exito}</label>
                    </div>
                </g:form>
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
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
