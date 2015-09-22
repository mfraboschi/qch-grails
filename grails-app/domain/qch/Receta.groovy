package qch

class Receta {
    String nombre
    Integer dificultad
    Integer caloriasTotal
    Usuario dueño          //Lo llame dueño
    String temporada
    Integer cantVisitas   //Acumular las veces que un Usuario visito la receta

    static hasMany = [ingredientes: IngredienteReceta,
                      condimentos: CondimentoReceta,
                      categorias: Categoria]   //Cena, almuerzo, ...

    /*static constraints = {
        usuario nullable: true
    }*/

    static mapping = {

    }

    //    Hay q agregarle los procedimientos. Son hasta 5
}
