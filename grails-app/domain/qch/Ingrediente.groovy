package qch

class Ingrediente {
    String nombre
    String contraindicaciones  //:DD
    Integer ubEnPiramide  //  La posicion enla piramide
    static mapping = {
        id name: 'nombre'
    }
}
