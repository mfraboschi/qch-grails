package qch.receta.ingrediente

class Condimento {

    String nombre
    String tipo
    static constraints = {
    }

    static mapping = {
        id name: 'nombre'
        version false
    }
}
