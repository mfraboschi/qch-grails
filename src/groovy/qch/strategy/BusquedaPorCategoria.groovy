package qch.strategy

import qch.enums.CategoriaEnum
import qch.receta.Categoria
import qch.receta.Receta
import qch.usuario.Grupo
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorCategoria implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Usuario usuario, Map parametros) {
		def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

        Receta.withCriteria {
            or {
                isNull("creador")
                'in' "creador", creadores
            }
            categorias {
                eq "nombre", CategoriaEnum.valueOf(parametros.categoria)
            }
        }
	}
}
