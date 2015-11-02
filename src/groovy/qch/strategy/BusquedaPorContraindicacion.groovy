package qch.strategy

import qch.enums.CondicionPreexistente
import qch.receta.Contraindicacion

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        def criteria = Contraindicacion.createCriteria()

        def result = criteria.list {
            eq 'condicionPreexistente', CondicionPreexistente.valueOf(parametros.contraindicacion)
        }

        return result.collect { it.receta }
    }
}
