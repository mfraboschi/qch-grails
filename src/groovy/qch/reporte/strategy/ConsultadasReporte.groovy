package qch.reporte.strategy
import qch.enums.Sexo
import qch.usuario.Usuario
import qch.receta.Receta
import qch.enums.Dificultad
import qch.enums.Dieta
/**
 * Created by mfraboschi on 5/11/15.
 */
class ConsultadasReporte implements EstrategiaReporte {
	@Override
	def obtenerResultadoReporte(Object parametros, Usuario userActual) {

		def result = userActual.cantVistas

		return result
	}

	 @Override
    def obtenerHtml(Object results) {
        if(!results) {
            return ""
        }
        StringBuilder sb = new StringBuilder()

        sb.append("<table class=\"estadistica-table\"><tr><td><b>Consultadas en los ultimos 7 dias</b></td></tr>")

            sb.append("<tr><td>${results}</td></tr>")

        sb.append("</table>")

        return sb.toString()
    }
}
