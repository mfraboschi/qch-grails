package qch.receta.ingrediente

import qch.receta.Receta
import qch.receta.ingrediente.Condimento

class CondimentoReceta implements Serializable {

    Integer cantidadEnMiligramos
    Condimento condimento

    static belongsTo = [receta: Receta]

    static mapping = {
        id composite: ['receta', 'condimento']
    }
}
