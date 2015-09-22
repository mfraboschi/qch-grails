package qch

class CondimentoReceta implements Serializable {

    Condimento condimento
    Integer cantidadEnMiligramos

    static belongsTo = [receta: Receta]

    static mapping = {
        id composite: ['receta', 'condimento']
        version false
    }
}
