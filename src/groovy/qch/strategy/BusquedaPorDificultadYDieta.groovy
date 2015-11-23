package qch.strategy

import qch.enums.Dieta
import qch.enums.Dificultad
import qch.receta.Receta
import qch.usuario.Grupo
import qch.usuario.Usuario

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDificultadYDieta implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Usuario usuario, Map parametros) {
        def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

        Receta.withCriteria {
            or {
                isNull("creador")
                'in' "creador", creadores
            }
            eq "dificultad", Dificultad.valueOf(parametros.dificultad)
            eq "dieta", Dieta.valueOf(parametros.dieta)
        }
    }
}
