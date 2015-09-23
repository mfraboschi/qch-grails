package qch

import qch.enums.CondicionPreexistente
import qch.enums.Dificultad
import qch.enums.Temporada

class Receta {
    String nombre
    Dificultad dificultad
    Integer caloriasTotal
    Integer calificacion
    Integer porciones
    Usuario duenio
    Temporada temporada
    Integer cantVisitas = 0
    CondicionPreexistente condicionPreexistente

    static hasMany = [ingredientes: IngredienteReceta,
                      condimentos: CondimentoReceta,
                      categorias: Categoria]

    static constraints = {
        duenio nullable: true
        calificacion nullable: true
        condicionPreexistente nullable: true
    }

    static mapping = {
        dificultad sqlType: 'enum'
        temporada sqlType: 'enum'
        condicionPreexistente sqlType: 'enum', column: 'condicion_preexistente'
    }

    //    Hay q agregarle los procedimientos. Son hasta 5
}
