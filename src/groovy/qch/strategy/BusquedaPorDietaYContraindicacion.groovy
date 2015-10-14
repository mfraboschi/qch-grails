package qch.strategy

import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDietaYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        Receta.findAllByContraindicacionesInListAndDieta([parametros.contraindicacion], parametros.dieta)
    }
}
