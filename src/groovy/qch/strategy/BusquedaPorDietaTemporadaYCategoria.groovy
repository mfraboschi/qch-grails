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
class BusquedaPorDietaTemporadaYCategoria implements EstrategiaBusqueda {
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
				categorias {
					eq "nombre", CategoriaEnum.valueOf(parametros.categoria)
				}
			}

		}

		return result
	}
}
