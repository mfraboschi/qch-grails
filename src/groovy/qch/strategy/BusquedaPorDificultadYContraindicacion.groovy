package qch.strategy

import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDificultadYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        Receta.findAllByContraindicacionesInListAndDificultad([parametros.contraindicacion], parametros.dificultad)
    }
}
