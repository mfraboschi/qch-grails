package qch.strategy

import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDificultadYDieta implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        Receta.findAllByDificultadAndDieta(parametros.dificultad, parametros.dieta)
    }
}
