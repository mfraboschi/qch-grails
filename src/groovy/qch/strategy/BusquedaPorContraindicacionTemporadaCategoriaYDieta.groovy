package qch.strategy

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.enums.CategoriaEnum
import qch.enums.Temporada
import qch.receta.TemporadaReceta
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.receta.Categoria

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorContraindicacionTemporadaCategoriaYDieta implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Map parametros)
	{
		def criteria = Contraindicacion.createCriteria()

		def result = criteria.list
		{
			"receta"
			{
				eq "dieta", Dieta.valueOf(parametros.dieta)
			}
			eq "temporada", Temporada.valueOf(parametros.temporada)
			eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
			eq "categoria", Categoria.valueOf(parametros.categoria)
			
		}

		return result.collect { it.receta }
	}
}
