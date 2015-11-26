import qch.reporte.strategy.ConsultadasReporte
import qch.reporte.strategy.NuevasReporte

/**
 * Created by mfraboschi on 5/11/15.
 */
class ReporteService {
	def obtenerEstrategiaEstadistica(tipoReporte) {
		def estrategiaEstadistica

		switch(tipoReporte) {
			case "consultas": estrategiaEstadistica = new ConsultadasReporte()
				break
			case "nuevas": estrategiaEstadistica = new NuevasReporte()
				break
		}

		return estrategiaEstadistica
	}
}
