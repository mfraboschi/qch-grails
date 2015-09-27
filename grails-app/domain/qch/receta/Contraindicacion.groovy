package qch.receta

import qch.enums.CondicionPreexistente

class Contraindicacion {
    static belongsTo = [receta: Receta]

    CondicionPreexistente condicionPreexistente
}
