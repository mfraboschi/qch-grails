package qch.reporte.strategy
import qch.enums.Sexo
import qch.usuario.Usuario
import qch.receta.Receta
import qch.enums.Dificultad
import qch.enums.Dieta
/**
 * Created by mfraboschi on 5/11/15.
 */
class NuevasReporte implements EstrategiaReporte {
	@Override
	def obtenerResultadoReporte(Object parametros, Usuario userActual) {

		def result = Receta.countByCreadorIsNotNull()


		return result
	}

	@Override
	def obtenerHtml(Object results) {
        if(!results) {
            return ""
        }

        StringBuilder sb = new StringBuilder()

        sb.append("<table class=\"estadistica-table\"><tr><td><b>Total de Recetas Nuevas</b></td></tr>")
        results.each {
            sb.append("<tr><td>${results}</td></tr>")
        }
        sb.append("</table>")

        return sb.toString()

    }
}
