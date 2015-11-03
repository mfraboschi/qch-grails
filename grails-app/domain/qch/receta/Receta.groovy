package qch.receta

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.enums.Temporada
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.IngredienteReceta
import qch.usuario.Usuario

class Receta {
    String nombre
    Dificultad dificultad
    Integer caloriasTotal
    Float calificacionPromedio = 0
    Integer porciones
    String creador
    Integer cantVisitas = 0
    Dieta dieta
    String urlImagen = ""
    List procedimientos

    static hasMany = [ingredientes: IngredienteReceta,
                      condimentos: CondimentoReceta,
                      categorias: Categoria,
                      calificaciones: Calificacion,
                      contraindicaciones: Contraindicacion,
                      temporadas: TemporadaReceta,
                      procedimientos: String]

    static constraints = {
        creador nullable: true
    }

    def obtenerIngredientePrincipal() {
        def ingredienteReceta = this.ingredientes.find { it.esIngredientePrincipal }

        return ingredienteReceta.ingrediente
    }

    static Receta buscarPorId(id) {
        Receta.findById(id)
    }

    def actualizarCalificacionPromedio() {
        def calificacionesReceta = Calificacion.findAllByReceta(this)
        Integer promedio = 0
        calificacionesReceta.each() {
            promedio += it.puntaje
        }

        this.calificacionPromedio = promedio / calificacionesReceta.size()
        this.save(flush: true)
    }

    def aumentarVisitas() {
        this.cantVisitas++
        this.save(flush: true)
    }

}
