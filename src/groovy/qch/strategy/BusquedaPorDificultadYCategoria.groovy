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
import qch.usuario.Grupo
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */

class BusquedaPorDificultadYCategoria implements EstrategiaBusqueda {
	@Override
	def obtenerResultados(Usuario usuario, Map parametros)
	{
        def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

        Receta.withCriteria {
            or {
                isNull("creador")
                'in' "creador", creadores
            }
			and {
				eq "dificultad", Dificultad.valueOf(parametros.dificultad)

				categorias {
					eq "nombre", CategoriaEnum.valueOf(parametros.categoria)
				}
			}

		}
	}
}