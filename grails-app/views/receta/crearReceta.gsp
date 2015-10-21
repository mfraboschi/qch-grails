<%@ page import="qch.enums.Dificultad" %>
<%@ page import="qch.enums.Dieta" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width"/>
        <title>¿Qué comemos hoy? - Nueva Receta</title>
        <asset:stylesheet href="default.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <script>
            $(function() {
                var scntDiv = $('#p_scents');
                var i = $('#p_scents p').size() + 1;

                $('#addScnt').live('click', function() {
                        $('<p><label for="p_scnts">Paso '+i+': &emsp;<input type="text" size="80" id="p_scnt" name="paso'+i+'"/></label><a href="#" id="remScnt"> Quitar paso</a></p>').appendTo(scntDiv);
                        i++;
                        return false;
                });

                $('#remScnt').live('click', function() {
                        if( i > 2 ) {
                                $(this).parents('p').remove();
                                i--;
                        }
                        return false;
                });
            });
        </script>
        <style>
            span {font-size:20px;}
        </style>
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
                  <li><a href="/que-comemos-hoy/receta/buscar">Buscar recetas</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Ingrese los datos de la receta</h1>
                <g:form name="formNuevaReceta" controller="receta" action="crear">
                    <table>
                        <tr>
                            <td><label for="name">Nombre:</label></td>
                            <td><g:textField id="name" name="nombre"/></td>
                        </tr>
                        <tr>
                            <td><label for="calories">Calorias Total:</label></td>
                            <td><g:textField id="calories" name="caloriasTotal"/></td>
                        </tr>
                        <tr>
                            <td><label for="portion">Porciones:</label></td>
                            <td><g:textField id="portion" name="porciones"/></td>
                        </tr>
                        <tr>
                            <td><label>Dieta:</label></td>
                            <td><g:select name="dieta" from="${Dieta.values()}" valueMessagePrefix="ENUM.Dieta"/></td>
                        </tr>
                        <tr>
                            <td><label>Dificultad:</label></td>
                            <td><g:select name="dificultad" from="${Dificultad.values()}" valueMessagePrefix="ENUM.Dificultad"/></td>
                        </tr>
                    </table>
                    <br><b><span>Procedimiento: </span></b><a href="#" id="addScnt">(Agregar otro Paso)</a><br><br>
                    <div id="p_scents">
                        <p><label for="p_scnts">Paso 1: &emsp;<input type="text" size="80" id="p_scnt" name="paso1"/></label></p>
                    </div>
                    <g:submitButton name="ingresar" value="Crear"/>
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