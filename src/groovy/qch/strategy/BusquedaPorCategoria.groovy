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
		Receta.withCriteria {
            categorias {
                eq "nombre", CategoriaEnum.valueOf(parametros.categoria)
            }
        }
	}
}
