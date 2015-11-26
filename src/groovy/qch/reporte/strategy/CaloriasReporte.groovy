
package qch.reporte.strategy
import qch.enums.Sexo
import qch.usuario.Usuario
import qch.receta.Receta
import qch.enums.Dificultad
import qch.enums.Dieta
/**
 * Created by mfraboschi on 5/11/15.
 */
class CaloriasReporte implements EstrategiaReporte {

	@Override
	def obtenerResultadoReporte(Object parametros, Usuario userActual) {
		def result = criteria.list {

               lt "caloriasTotal", variableCaloriasMaxima
           }
       }		
		return results

	}

	 @Override
	def obtenerHtml(Object results) {
		if(!results) {
			return ""
		}
		StringBuilder sb = new StringBuilder()

		sb.append("<table class=\"estadistica-table\"><tr><td><b>Dieta</b></td><td><b>Consultas</b></td>")
		results.each {
			sb.append("<tr><td>${it[0]}</td><td>${it[1]}</td>")
		}
		sb.append("</table>")

		return sb.toString()
	}
}
