package qch.estadistica.strategy

import qch.usuario.HistorialUsuario

/**
 * Created by mfraboschi on 5/11/15.
 */
class MasConsultadasPorDificultadEstadistica implements EstrategiaEstadistica {

    @Override
    def obtenerResultadoEstadistica(Object parametros) {
        def c = HistorialUsuario.createCriteria()
        def results = c {
            receta {
                projections {
                    groupProperty "dificultad"
                    count "dificultad", 'contador' //Implicit alias is created here !
                }
            }
            order 'contador','desc'
        }

        return results
    }

    @Override
    def obtenerHtml(Object results) {
        if(!results) {
            return ""
        }
        StringBuilder sb = new StringBuilder()

        sb.append("<table class=\"estadistica-table\"><tr><td><b>Dificultad</b></td><td><b>Consultas</b></td>")
        results.each {
            sb.append("<tr><td>${it[0]}</td><td>${it[1]}</td>")
        }
        sb.append("</table>")

        return sb.toString()
    }
}
