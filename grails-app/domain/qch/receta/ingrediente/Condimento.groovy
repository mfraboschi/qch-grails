package qch.receta.ingrediente

class Condimento {

    String nombre
    String tipo

    static constraints = {
        tipo nullable: true
    }
    static mapping = {
        id generator: 'assigned', name: 'nombre'
    }
}
