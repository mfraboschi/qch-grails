package qch.receta.ingrediente

import qch.receta.Receta
import qch.receta.ingrediente.Condimento

class CondimentoReceta implements Serializable {

    Condimento condimento
    Integer cantidadEnMiligramos

    static belongsTo = [receta: Receta]

    static mapping = {
        id composite: ['receta', 'condimento']
    }
}
