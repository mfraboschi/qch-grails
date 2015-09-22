package qch

class Condimento {

    String nombre
    String tipo    //   Se ve q es string esto, pero no creo q nos interese
    static constraints = {
    }

    static mapping = {
        id name: 'nombre'
        version false
    }
}
