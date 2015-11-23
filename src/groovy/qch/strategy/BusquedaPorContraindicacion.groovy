package qch.strategy

import qch.enums.CondicionPreexistente
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.usuario.Grupo
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Usuario usuario, Map parametros) {
        def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

        def result = Receta.withCriteria {
            or {
                isNull("creador")
                'in' "creador", creadores
            }
            contraindicaciones {
                eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
            }
        }

        result
    }
}
