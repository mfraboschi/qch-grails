package qch.strategy

import qch.enums.CategoriaEnum
import qch.receta.Categoria
import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorCategoria implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Map parametros) {
		def categoria = Categoria.findByNombre(parametros.categoria)
		return categoria.recetas
	}
}
