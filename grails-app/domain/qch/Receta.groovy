package qch

class Receta {
    String nombre
    Integer dificultad
    Integer calorias
    Usuario usuario

    static hasMany = [ingredientes: IngredienteReceta,
                      condimentos: CondimentoReceta,
                      categorias: Categoria]

    static constraints = {
        usuario nullable: true
    }

    static mapping = {

    }
}
