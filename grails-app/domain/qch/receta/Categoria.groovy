package qch.receta

import qch.enums.CategoriaEnum

class Categoria {
    CategoriaEnum nombre

    static belongsTo = [receta: Receta]
}
