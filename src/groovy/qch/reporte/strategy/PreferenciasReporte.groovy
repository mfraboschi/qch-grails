package qch.reporte.strategy
import qch.enums.Sexo
import qch.usuario.Usuario
import qch.receta.Receta
import qch.enums.Dificultad
import qch.enums.Dieta
/**
 * Created by mfraboschi on 5/11/15.
 */
class PreferenciasReporte implements EstrategiaReporte {

	@Override
	def obtenerResultadoReporte(Object parametros, Usuario userActual) {
		def c = Receta.createCriteria()
		def results = c {
			
				projections {
					groupProperty "dieta"
					count "dieta", 'contador' //Implicit alias is created here !
				}
			
			order 'contador','desc'
		}

		return results
		/*def recetasVegetariano = Receta.countByDieta(Dieta.VEGETARIANO)
		def recetasVegano = Receta.countByDieta(Dieta.VEGANO)
		def recetasOvolacto = Receta.countByDieta(Dieta.OVOLACTO)
		def recetasNaturista = Receta.countByDieta(Dieta.NATURISTA)
		def recetasDeporte = Receta.countByDieta(Dieta.DEPORTE)
		def recetasNormal = Receta.countByDieta(Dieta.NORMAL)
		def results = recetasVegetariano

		
		if(recetasVegano > results)
		{
			results = recetasVegano
		}
		if(recetasOvolacto > results)
		{
			results = recetasOvolacto
		}
		if(recetasNaturista > results)
		{
			results = recetasNaturista
		}
		if(recetasDeporte > results)
		{
			results = recetasDeporte
		}
		if(recetasNormal > results)
		{
			results = recetasNormal
		}
		
		return results*/

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
