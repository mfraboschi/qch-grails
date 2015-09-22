package qch

class Receta {
    String nombre
    Integer dificultad
    Integer caloriasTotal
    Usuario dueño
    String temporada
    Integer cantVisitas

    static hasMany = [ingredientes: IngredienteReceta,
                      condimentos: CondimentoReceta,
                      categorias: Categoria]

    static constraints = {
        usuario nullable: true
    }

    static mapping = {

    }
}
