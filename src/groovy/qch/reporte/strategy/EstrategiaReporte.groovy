package qch.reporte.strategy
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 5/11/15.
 */
interface EstrategiaReporte {
	def obtenerResultadoReporte(parametros, Usuario user);

	def obtenerHtml(results);
}
