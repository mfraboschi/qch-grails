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
import qch.usuario.Grupo
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorContraindicacionYTemporada implements EstrategiaBusqueda {
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
				temporadas
				{
					eq "temporada", Temporada.valueOf(parametros.temporada)
				}
				if(parametros.contraindicacion != CondicionPreexistente.NINGUNA.toString())
				{
					contraindicaciones
					{
						eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
					}
				}
			}
		}
	}
}