package qch.strategy

import qch.enums.Temporada
import qch.receta.TemporadaReceta
import qch.usuario.Usuario
import qch.receta.Receta
import qch.usuario.Grupo

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorTemporada implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Usuario usuario, Map parametros) {
			def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

	        Receta.withCriteria {
	            or {
	                isNull("creador")
	                'in' "creador", creadores
	            }
							temporadas {
								eq "temporada", Temporada.valueOf(parametros.temporada)
							}
	        }
		}
}
