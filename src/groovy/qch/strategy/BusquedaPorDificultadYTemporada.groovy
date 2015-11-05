package qch.strategy

import qch.enums.Dificultad
import qch.receta.Receta
import qch.enums.Temporada
import qch.enums.CategoriaEnum
import qch.receta.TemporadaReceta
import qch.receta.Categoria

/**
 * Created by mfraboschi on 13/10/15.
 */

class BusquedaPorDificultadYTemporada implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Map parametros)
	{
		def result = Receta.withCriteria
		{
			and
			{
				eq "dificultad", Dificultad.valueOf(parametros.dificultad)

				temporadas {
					eq "temporada", Temporada.valueOf(parametros.temporada)
				}
				
			}

		}

		return result
	}
}