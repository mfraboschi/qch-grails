package qch.receta

import qch.enums.Temporada

class TemporadaReceta {

    Temporada temporada

    static belongsTo = [receta: Receta]

}
