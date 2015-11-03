package qch.strategy

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.receta.Contraindicacion
import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
/*
class BusquedaPorDificultadYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        Receta.findAllByContraindicacionesInListAndDificultad([parametros.contraindicacion], parametros.dificultad)
    }
}
*/

class BusquedaPorDificultadYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {

        def criteria = Contraindicacion.createCriteria()

        def result = criteria.list {
            "receta" {
                eq "dificultad", Dificultad.valueOf(parametros.dificultad)
            }
            eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
        }

        return result.collect { it.receta }
    }
}

	