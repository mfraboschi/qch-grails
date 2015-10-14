package qch.strategy

import qch.enums.CondicionPreexistente
import qch.receta.Contraindicacion
import qch.receta.Receta

/**
 * Created by mfraboschi on 13/10/15.
 */
class BusquedaPorDificultadDietaYContraindicacion implements EstrategiaBusqueda {
    @Override
    def obtenerResultados(Map parametros) {
        def contraindicacion = new Contraindicacion(condicionPreexistente: CondicionPreexistente.valueOf(parametros.contraindicacion))
        //Receta.findAllByDificultadAndDietaAndContraindicacionesInList(parametros.dificultad, parametros.dieta, [contraindicacion])

        def criteria = Receta.createCriteria()

        def result = criteria.list {
            eq "dificultad", parametros.dificultad
            eq "dieta", parametros.dieta
            eq 'contraindicaciones.condicionPreexistente',parametros.contraindicacion
        }

        return result
    }
}
