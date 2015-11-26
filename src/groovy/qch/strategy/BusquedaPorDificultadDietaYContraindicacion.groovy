package qch.strategy

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.receta.Contraindicacion
import qch.receta.Receta
import qch.usuario.Usuario
import qch.usuario.Grupo

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDificultadDietaYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Usuario usuario, Map parametros) {
          def creadores = Grupo.obtenerUsuariosDeSusGrupos(usuario)

          Receta.withCriteria {
              or {
                  isNull("creador")
                  'in' "creador", creadores
              }
              and {
                eq "dieta", Dieta.valueOf(parametros.dieta)
                eq "dificultad", Dificultad.valueOf(parametros.dificultad)

                if(parametros.contraindicacion != CondicionPreexistente.NINGUNA.toString()) {
                    contraindicaciones {
                        eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
                    }
                }
              }

          }
    }
}
