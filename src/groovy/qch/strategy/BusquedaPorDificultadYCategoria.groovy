package qch.strategy

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.enums.Temporada
import qch.enums.CategoriaEnum
import qch.receta.TemporadaReceta
import qch.receta.Categoria

/**
 * Created by mfraboschi on 13/10/15.
 */

class BusquedaPorDificultadYCategoria implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Map parametros) 
	{
		def result = Receta.withCriteria
		{
			and {
				eq "dificultad", Dificultad.valueOf(parametros.dificultad)

				categorias {
					eq "nombre", CategoriaEnum.valueOf(parametros.categoria)
				}
			}

		}

		return result
	}
}