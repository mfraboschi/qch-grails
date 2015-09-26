package qch.receta.ingrediente

import qch.receta.Receta
import qch.receta.ingrediente.Ingrediente

class IngredienteReceta implements Serializable {

    static belongsTo = [receta: Receta]

    Ingrediente ingrediente
    Integer cantidadEnMiligramos
    Integer calorias

    static mapping = {
        id composite: ['receta', 'ingrediente']
        version false
    }
}
