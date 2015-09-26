package qch.receta

import qch.enums.CondicionPreexistente
import qch.enums.Dificultad
import qch.enums.Temporada
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.IngredienteReceta
import qch.usuario.Usuario

class Receta {
    String nombre
    Dificultad dificultad
    Integer caloriasTotal
    Integer calificacionPromedio
    Integer porciones
    Usuario duenio
    Temporada temporada
    Integer cantVisitas = 0
    CondicionPreexistente condicionPreexistente

    static hasMany = [ingredientes: IngredienteReceta,
                      condimentos: CondimentoReceta,
                      categorias: Categoria,
                      calificaciones: Calificacion]

    static constraints = {
        duenio nullable: true
        calificacionPromedio nullable: true
        condicionPreexistente nullable: true
    }

    static mapping = {
        dificultad sqlType: 'enum'
        temporada sqlType: 'enum'
        condicionPreexistente sqlType: 'enum', column: 'condicion_preexistente'
    }

    //    Hay q agregarle los procedimientos y las fotos. Son hasta 5
}
