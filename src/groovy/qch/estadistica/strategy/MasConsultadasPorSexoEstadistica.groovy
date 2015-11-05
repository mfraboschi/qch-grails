package qch.estadistica.strategy

import qch.enums.Sexo
import qch.usuario.HistorialUsuario

/**
 * Created by mfraboschi on 5/11/15.
 */
class MasConsultadasPorSexoEstadistica implements EstrategiaEstadistica {
    @Override
    def obtenerResultadoEstadistica(Object parametros) {
        def result = [:]
        def c = HistorialUsuario.createCriteria()
        def masculino = c {
            usuario {
                eq "sexo", Sexo.valueOf("MASCULINO")
            }
            projections {
                groupProperty "receta"
                count "receta", 'contador' //Implicit alias is created here !
            }
            order 'contador','desc'
        }
        result.masculino = masculino

        c = HistorialUsuario.createCriteria()
        def femenino = c {
            usuario {
                eq "sexo", Sexo.valueOf("FEMENINO")
            }
            projections {
                groupProperty "receta"
                count "receta", 'contador' //Implicit alias is created here !
            }
            order 'contador','desc'
        }

        result.femenino = femenino

        return result
    }

    @Override
    def obtenerHtml(Object results) {
        if(!results) {
            return ""
        }
        StringBuilder sb = new StringBuilder()
        if(results.masculino) {
            sb.append("<h2>Masculino</h2>")
            sb.append("<table class=\"estadistica-table\"><tr><td><b>Receta</b></td><td><b>Consultas</b></td>")
            results.masculino.each {
                sb.append("<tr><td>${it[0].nombre}</td><td>${it[1]}</td>")
            }
            sb.append("</table>")
        }

        if(results.femenino) {
            sb.append("<h2>Femenino</h2>")
            sb.append("<table class=\"estadistica-table\"><tr><td><b>Receta</b></td><td><b>Consultas</b></td>")
            results.femenino.each {
                sb.append("<tr><td>${it[0].nombre}</td><td>${it[1]}</td>")
            }
            sb.append("</table>")
        }

        return sb.toString()
    }
}
