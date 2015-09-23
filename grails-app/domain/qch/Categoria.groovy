package qch

import qch.enums.CategoriaEnum

class Categoria {
    CategoriaEnum nombre

    static belongsTo = Receta
    static hasMany = [ recetas: Receta ]
    static mapping = {
        id name: 'nombre'
        nombre sqlType: 'enum'
    }
}
