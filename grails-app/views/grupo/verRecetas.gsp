<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width" />
        <title>¿Qué comemos hoy? - Buscar Grupos</title>
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
                    <li><a href="/que-comemos-hoy/grupo/index">Mis grupos</a></li>
                	  <li><a href="/que-comemos-hoy/grupo/crearGrupo">Crear Grupo</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Recetas de ${miembro.nombre}</h1>
                <div>
                    <ul style="margin-left:0px; font-size:15px;">
                        <g:each var="receta" in="${recetas}">
                           <li>
                                <div style="display: inline-block; border-style: solid; border-color: #E3E0BB; height: 55px; width: 500px;">
                                    <b><g:link style="color:#85A32F" controller="receta" action="detalle" id="${receta.id}">${receta.nombre}</g:link></b>
                                    <table style="display: block; margin-top: 13px;">
                                        <tbody style="display: block;">
                                        <tr style="display: block;">
                                            <td style="width: 385px; font-size:13px;">Visitas: <b>${receta.cantVisitas}</b></td>
                                            <g:if test="${receta.calificacionPromedio}">
                                                <td style="align-items: right;align-self: right;font-size:12px;">Calificación: <b>${receta.calificacionPromedio}</b></td>
                                            </g:if>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </li>
                        </g:each>
                    </ul>
                </div>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
