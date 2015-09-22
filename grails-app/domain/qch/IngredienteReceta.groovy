package qch

class IngredienteReceta implements Serializable {

    static belongsTo = [receta: Receta]

    Ingrediente ingrediente
    Integer cantidadEnMiligramos

    static mapping = {
        id composite: ['receta', 'ingrediente']
        version false
    }
}
