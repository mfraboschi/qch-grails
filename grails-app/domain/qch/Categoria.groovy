package qch

class Categoria {
    String nombre

    static belongsTo = Receta
    static hasMany = [ recetas: Receta ]
    static mapping = {
        id name: 'nombre'
    }
}
