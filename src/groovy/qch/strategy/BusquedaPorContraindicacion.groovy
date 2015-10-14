package qch.strategy

import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        Receta.findAllByContraindicacionesInList([parametros.contraindicacion])
    }
}
