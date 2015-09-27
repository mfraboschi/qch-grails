package qch.receta.ingrediente

import qch.enums.PiramideAlimenticia

class Ingrediente {
    String nombre
    PiramideAlimenticia nivelPiramide

    static mapping = {
        id generator:'assigned', name: 'nombre'
    }
}
