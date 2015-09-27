package qch.receta

import qch.enums.CategoriaEnum

class Categoria {
    CategoriaEnum nombre

    static belongsTo = Receta
    static hasMany = [ recetas: Receta ]

    static constraints = {
        nombre unique: true
    }
}
