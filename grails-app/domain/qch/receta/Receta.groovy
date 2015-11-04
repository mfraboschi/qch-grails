package qch.receta

import qch.enums.CondicionPreexistente
import qch.enums.Dieta
import qch.enums.Dificultad
import qch.enums.Temporada
import qch.enums.CategoriaEnum
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.CondimentoReceta
import qch.receta.ingrediente.IngredienteReceta
import qch.receta.Categoria
import qch.receta.Contraindicacion
import qch.receta.TemporadaReceta
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

	public guardarReceta(parametro, Usuario usuario)
	{
        this.nombre = parametro.nombre
        this.caloriasTotal = Integer.valueOf(parametro.caloriasTotal)
        this.porciones = Integer.valueOf(parametro.porciones)
        this.dificultad = parametro.dificultad
        this.creador = usuario.nickName
        this.dieta = parametro.dieta
        this.urlImagen = parametro.url
        this.addToContraindicaciones(new Contraindicacion(condicionPreexistente: parametro.precondicion))

		if (parametro.boxInvierno == "INVIERNO") this.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
		if (parametro.boxVerano == "VERANO") this.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))
		if (parametro.boxOtonio == "OTONIO") this.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
		if (parametro.boxPrimavera == "PRIMAVERA") this.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))

		if (parametro.boxDesayuno == "DESAYUNO") this.addToCategorias(new Categoria(nombre: CategoriaEnum.DESAYUNO))
		if (parametro.boxAlmuerzo == "ALMUERZO") this.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
		if (parametro.boxMerienda == "MERIENDA") this.addToCategorias(new Categoria(nombre: CategoriaEnum.MERIENDA))
		if (parametro.boxCena == "CENA") this.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
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
