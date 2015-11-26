import qch.usuario.Usuario
import qch.receta.Receta
import qch.enums.Dificultad
import qch.enums.Dieta
import qch.reporte.strategy.EstrategiaReporte

class ReportesController {
	def reporteService
	
	def main() {
		def userActual = session.user
		render(view:"reportes", model: [usuario: userActual])
	}

	def obtenerRecetasPorPreferencias()
	{
		def recetasBaja = Receta.countByDificultad(BAJA)
		def recetasMedia = Receta.countByDificultad(MEDIA)
		def recetasDificil = Receta.countByDificultad(DIFICIL)
		def recetasMuyDificil = Receta.countByDificultad(MUY_DIFICIL)
		
		def recetasVegetariano = Receta.countByDificultad(VEGETARIANO)
		def recetasVegano = Receta.countByDificultad(VEGANO)
		def recetasOvolacto = Receta.countByDificultad(OVOLACTO)
		def recetasNaturista = Receta.countByDificultad(NATURISTA)
		def recetasDeporte = Receta.countByDificultad(DEPORTE)
		def recetasNormal = Receta.countByDificultad(NORMAL)
		
		render(reportesService.obtenerHtml(results))
	}
	
	def obtenerRecetasNuevas() 
	{		
		def recetasNuevas = Receta.countByCreadorIsNotNull()

		render(reportesService.obtenerHtml(results))
	}
	
	def obtenerRecetasConsultadas()
	{
		Usuario userActual = session.user

		userActual.cantVistas
		
		render(reportesService.obtenerHtml(results))
	}
	
	def obtener() {
		Usuario userActual = session.user
		
		EstrategiaReporte estrategiaReporte = reporteService.obtenerEstrategiaEstadistica(params.tipo_reporte)
		
		def results = estrategiaReporte.obtenerResultadoReporte(params, userActual)

		render(estrategiaReporte.obtenerHtml(results))
	}
}
