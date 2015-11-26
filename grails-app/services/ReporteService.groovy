import qch.reporte.strategy.ConsultadasReporte
import qch.reporte.strategy.NuevasReporte
import qch.reporte.strategy.PreferenciasReporte
import qch.reporte.strategy.CaloriasReporte

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
			case "preferencias": estrategiaEstadistica = new PreferenciasReporte()
				break
			case "calorias": estrategiaEstadistica = new CaloriasReporte()
				break
		}

		return estrategiaEstadistica
	}
}
