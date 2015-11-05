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
        <title>¿Qué comemos hoy? - Estadisticas</title>
        <asset:stylesheet href="default.css"/>
        <style>

            .estadistica-table {
                border: solid;
                border-width: 3px;
                border-color: #E3E0BB;
            }

            .estadistica-table tr td {
                border: solid;
                border-width: 3px;
                border-color: #E3E0BB;
            }

            #estadisticas {
                margin:4px;

                float:left;
            }

            #estadisticas label {
                float:left;
                width:170px;
                margin:4px;
                background-color:#EFEFEF;
                border-radius:4px;
                border:1px solid #D0D0D0;
                overflow:auto;

            }

            #estadisticas label span {
                text-align:center;
                font-size: 15px;
                padding:13px 0px;
                display:block;
            }

            #estadisticas label input {
                position:absolute;
                top:-20px;
            }

            #estadisticas input:checked + span {
                background-color:#404040;
                color:#F7F7F7;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <script>
            $(document).ready( function() {
                var frm = $('#obtener-estadistica');
                $('#obtener-estadistica').submit(function () {
                    $.ajax({
                        type: frm.attr('method'),
                        url: frm.attr('action'),
                        data: frm.serialize(),
                        success: function (data) {
                            $('#estadistica-resultado').html(data);
                        }
                    });
                    return false;
                });
                $('[name=tipo_estadistica]').live('click', function () {
                    $('#obtener-estadistica').submit();
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
                    <li><a href="/que-comemos-hoy/historial/historialRecetas">Historial</a></li>
                </ul>
            </nav>
            <section id="mainRight">
                <h1>Estadisticas</h1>
                <div>
                    <form id="obtener-estadistica" action="/que-comemos-hoy/estadisticas/obtener">
                    <div id="estadisticas">
                        <label><input type="radio" name="tipo_estadistica" value="consultas"><span>Mas consultadas</span></label>
                        <label><input type="radio" name="tipo_estadistica" value="sexo"><span>Por sexo</span></label>
                        <label><input type="radio" name="tipo_estadistica" value="dificultad"><span>Por dificultad</span></label>
                    </div>
                    </form>
                </div>
                <div id="estadistica-resultado">
                </div>
            </section> <!-- end mainRight -->
        </section> <!-- end mainContent -->
        <footer>
            <p>&copy; 2015 UTN - Diseño de Sistemas</p>
        </footer>
    </body>
</html>
