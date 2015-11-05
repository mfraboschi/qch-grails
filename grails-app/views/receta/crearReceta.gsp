<%@ page import="qch.enums.CondicionPreexistente" %>
<%@ page import="qch.enums.Dificultad" %>
<%@ page import="qch.enums.Dieta" %>
<%@ page import="qch.enums.Temporada" %>
<%@ page import="qch.enums.CategoriaEnum" %>

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
                var j = $('#div_ingredientes p').size() + 1;
                var k = $('#div_condimentos p').size() + 1;

                $('#addScnt').live('click', function() {
                        $('<p><label for="p_scnts">Paso '+i+': &emsp;<input type="text" size="80" id="p_scnt" name="procedimientos"/></label><a href="#" id="remScnt"> Quitar paso</a></p>').appendTo(scntDiv);
                        i++;
                        return false;
                });
                $('#remScnt').live('click', function() {
                    if (i > 2) {
                        $(this).parents('p').remove();
                        i--;
                    }
                    return false;
                });


                $('#addIngrediente').live('click', function() {
                    var elclon = $('#p_ingrediente').clone();
                    elclon.attr('id', j);
                    $('<a href="#" id="remIngrediente"> Quitar ingrediente</a>').appendTo(elclon);
                    elclon.appendTo($('#div_ingredientes'));
                    j++;
                    return false;
                });
                $('#remIngrediente').live('click', function() {
                    if (j > 2) {
                        $(this).parents('p').remove();
                        j--;
                    }
                    return false;
                });


                $('#addCondimento').live('click', function() {
                    var elclon2 = $('#p_condimento').clone();
                    elclon2.attr('id2', k);
                    $('<a href="#" id="remCondimento"> Quitar condimento</a>').appendTo(elclon2);
                    elclon2.appendTo($('#div_condimentos'));
                    k++;
                    return false;
                });
                $('#remCondimento').live('click', function() {
                    if (k > 2) {
                        $(this).parents('p').remove();
                        k--;
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
                <label style="color: red">${error}</label>
                <label style="color: green">${exito}</label>
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
                            <td><g:select id="portion" name="porciones" from="${1..10}"/></td>
                        </tr>
                        <tr>
                            <td><label>Dieta:</label></td>
                            <td><g:select name="dieta" from="${Dieta.values()}" valueMessagePrefix="ENUM.Dieta" noSelection="['':'Seleccionar']"/></td>
                        </tr>
                        <tr>
                            <td><label>Dificultad:</label></td>
                            <td><g:select name="dificultad" from="${Dificultad.values()}" valueMessagePrefix="ENUM.Dificultad" noSelection="['':'Seleccionar']"/></td>
                        </tr>
                        <tr>
                            <td><label>Condicion especial:</label></td>
                            <td><g:select name="precondicion" from="${CondicionPreexistente.values()}" valueMessagePrefix="ENUM.CondicionPreexistente"/></td>
                        </tr>
                        <tr>
                            <td><label>Temporada:</label></td>
                            <td><g:checkBox name="boxInvierno" value="${Temporada.INVIERNO}"/> Invierno</td>
                            <td><label>Categoria:</label></td>
                            <td><g:checkBox name="boxDesayuno" value="${CategoriaEnum.DESAYUNO}"/> Desayuno</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><g:checkBox name="boxVerano" value="${Temporada.VERANO}"/> Verano</td>
                            <td></td>
                            <td><g:checkBox name="boxAlmuerzo" value="${CategoriaEnum.ALMUERZO}"/> Almuerzo</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><g:checkBox name="boxOtonio" value="${Temporada.OTONIO}"/> Otoño</td>
                            <td></td>
                            <td><g:checkBox name="boxMerienda" value="${CategoriaEnum.MERIENDA}"/> Merienda</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><g:checkBox name="boxPrimavera" value="${Temporada.PRIMAVERA}"/> Primavera</td>
                            <td></td>
                            <td><g:checkBox name="boxCena" value="${CategoriaEnum.CENA}"/> Cena</td>
                        </tr>
                    </table>
                    &nbspURL Imagen: &nbsp&nbsp&nbsp<input type="text" size="62" name="url"/><br><br>
                    <br><b><span>Procedimiento: </span></b><a href="#" id="addScnt">(Agregar otro Paso)</a><br><br>
                    <div id="p_scents">
                        <p><label for="p_scnts">Paso 1: &emsp;<input type="text" size="80" id="p_scnt" name="procedimientos"/></label></p>
                    </div>
                    <br><b><span>Ingredientes: </span></b><a href="#" id="addIngrediente">(Agregar otro)</a><br><br>
                    <div id="div_ingredientes">
                        <p id="p_ingrediente"><g:select name="ingredientes" id="ingrediente" from="${ingredientes}" optionKey="id" optionValue="nombre" noSelection="['':'Seleccionar']"/><label>&nbsp&nbsp Cantidad: (g/cm³) </label><input type="text" name="cantidades" size="5"/></p>
                    </div>
                    <br><b><span>Condimentos: </span></b><a href="#" id="addCondimento">(Agregar otro)</a><br><br>
                    <div id="div_condimentos">
                        <p id="p_condimento"><g:select name="condimentos" id="condimento" from="${condimentos}" optionKey="id" optionValue="nombre" noSelection="['':'Seleccionar']"/><label>&nbsp&nbsp Cantidad: (mg) </label><input type="text" name="cantidades2" size="5"/></p>
                    </div>
                    <g:submitButton name="ingresar" value="Crear"/>
                </g:form>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
