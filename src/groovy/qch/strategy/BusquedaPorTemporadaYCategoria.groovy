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
class BusquedaPorTemporadaYCategoria implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Map parametros) 
	{
		def categoria = Categoria.findByNombre(parametros.categoria)
		Receta.withCriteria {
			temporadas 
			{
				eq "temporada", Temporada.valueOf(parametros.temporada)
			}
			categorias 
			{
				eq "nombre", CategoriaEnum.valueOf(parametros.categoria)
			}
		}
	}
}
