package qch.receta

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.enums.Temporada
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.IngredienteReceta
import qch.usuario.Usuario

class Receta {
    String nombre
    Dificultad dificultad
    Integer caloriasTotal
    Integer calificacionPromedio = 0
    Integer porciones
    String creador
    Integer cantVisitas = 0
    Integer cantVisitasHembras = 0
    Integer cantVisitasMachos = 0
    Dieta dieta
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
}
