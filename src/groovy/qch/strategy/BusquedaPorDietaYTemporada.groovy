package qch.strategy

import qch.enums.Dieta
import qch.enums.CategoriaEnum
import qch.enums.Temporada
import qch.receta.TemporadaReceta
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.receta.Categoria

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDietaYTemporada implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Map parametros)
	{
		def result = Receta.withCriteria
		{
			and {
				eq "dieta", Dieta.valueOf(parametros.dieta)

				temporadas {
					eq "temporada", Temporada.valueOf(parametros.temporada)
				}
			}

		}

		return result
	}
}
