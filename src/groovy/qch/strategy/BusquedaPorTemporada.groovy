package qch.strategy

import qch.enums.Temporada
import qch.receta.TemporadaReceta
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorTemporada implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Usuario usuario, Map parametros) {
		def criteria = TemporadaReceta.createCriteria()

		def result = criteria.list {
			eq 'temporada', Temporada.valueOf(parametros.temporada)
		}

		return result.collect { it.receta }
	}
}


