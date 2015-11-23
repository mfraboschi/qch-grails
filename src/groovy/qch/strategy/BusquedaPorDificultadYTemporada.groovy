package qch.strategy

import qch.enums.Dificultad
import qch.receta.Receta
import qch.enums.Temporada
import qch.enums.CategoriaEnum
import qch.receta.TemporadaReceta
import qch.receta.Categoria
import qch.usuario.Grupo
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */

class BusquedaPorDificultadYTemporada implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Usuario usuario, Map parametros)
	{
        def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

        Receta.withCriteria {
            or {
                isNull("creador")
                'in' "creador", creadores
            }
			and
			{
				eq "dificultad", Dificultad.valueOf(parametros.dificultad)

				temporadas {
					eq "temporada", Temporada.valueOf(parametros.temporada)
				}
				
			}

		}
	}
}