package qch.strategy

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.receta.Contraindicacion


/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDietaYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        def criteria = Contraindicacion.createCriteria()

        def result = criteria.list {
            "receta" {
                eq "dieta", Dieta.valueOf(parametros.dieta)
            }
            eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
        }

        return result.collect { it.receta }
    }
}
