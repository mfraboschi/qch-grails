import qch.receta.Calificacion
import qch.receta.Receta
import qch.receta.ingrediente.Ingrediente
import qch.receta.ingrediente.IngredienteReceta
import qch.receta.TemporadaReceta
import qch.receta.Categoria
import qch.receta.Contraindicacion
import qch.strategy.EstrategiaBusqueda
import qch.usuario.HistorialUsuario
import qch.usuario.Usuario
import qch.enums.Temporada
import qch.enums.CategoriaEnum

class RecetaController {

    def recetaService

    /**
     * Listado total de recetas creadas
     * @return
     */
    def index() {
        List recetas = Receta.findAll()
        Usuario usuario = session.user
        render(view:"main", model: [usuario: usuario, recetas: recetas])
    }

    /**
     * Detalle de receta para cierto id
     * @return
     */
   	def detalle(){
   		if(params.id){
    		Long id = params.id.toLong()
    		Receta recetaActual = Receta.findById(id)
            recetaActual.cantVisitas = recetaActual.cantVisitas + 1

            recetaActual.save(flush: true)

			def calificacion = Calificacion.findByRecetaAndUsuario(recetaActual, session.user)

    		return render(view:"detalleReceta", model: [receta: recetaActual, calificacion: calificacion])
    	}
   	}

    def seleccionar() {
        if(params.id) {
            Long id = params.id.toLong()
            Receta recetaActual = Receta.findById(id)

            HistorialUsuario historial = new HistorialUsuario()
            historial.receta = recetaActual
            historial.usuario = session.user
            historial.fechaCreacion = new Date()

            historial.save()

            return render(view:"detalleReceta", model:[receta: recetaActual, exito:"Seleccionaste la receta!"])
        }

        Receta.findAllByCantVisitasGreaterThan()
    }

    def todas() {
        Usuario usuario = session.user
        List recetas = Receta.findAllByCreador(usuario.nickName)

        def mensaje
        if(!recetas) mensaje = "No tienes ninguna receta asociada"
        render (view:"misRecetas", model:[usuario: usuario, recetas: recetas, mensaje: mensaje])
    }

    def nueva() {
        def ingredientes = Ingrediente.findAll()
        render (view:"crearReceta", model:[usuario: session.user, ingredientes: ingredientes])
    }

    /**
     * Crea y guarda una nueva receta
     * @return
     */
    def crear() {
        Receta nuevaReceta = new Receta()
        Usuario usuario = session.user

        if(!params.nombre) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar el nombre"])
        }
        if(!params.caloriasTotal) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes completar las calorías"])
        }
        if(!params.procedimientos) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes agregar al menos un procedimiento"])
        }
        if(!params.ingredientes) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes agregar al menos un ingrediente"])
        }
        if(!params.cantidades) {
            return render(view:"crearReceta", model: [usuario: usuario, error: "Debes especificar las cantidades"])
        }

        nuevaReceta.nombre = params.nombre
        nuevaReceta.caloriasTotal = Integer.valueOf(params.caloriasTotal)
        nuevaReceta.porciones = Integer.valueOf(params.porciones)
        nuevaReceta.dificultad = params.dificultad
        nuevaReceta.creador = usuario.nickName
        nuevaReceta.dieta = params.dieta
        nuevaReceta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: params.precondicion))

        def invierno = params.boxInvierno
        if (invierno == Temporada.INVIERNO) nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
        def verano = params.boxVerano
        if (verano == Temporada.VERANO) nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))
        def otonio = params.boxOtonio
        if (otonio == Temporada.OTONIO) nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
        def primavera = params.boxPrimavera
        if (primavera == Temporada.PRIMAVERA) nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
        def desayuno = params.boxDesayuno
        if (desayuno == CategoriaEnum.DESAYUNO) nuevaReceta.addToTemporadas(new Categoria(nombre: CategoriaEnum.DESAYUNO))
        def almuerzo = params.boxAlmuerzo
        if (almuerzo == CategoriaEnum.ALMUERZO) nuevaReceta.addToTemporadas(new Categoria(nombre: CategoriaEnum.ALMUERZO))
        def merienda = params.boxMerienda
        if (merienda == CategoriaEnum.MERIENDA) nuevaReceta.addToTemporadas(new Categoria(nombre: CategoriaEnum.MERIENDA))
        def cena = params.boxCena
        if (cena == CategoriaEnum.CENA) nuevaReceta.addToTemporadas(new Categoria(nombre: CategoriaEnum.CENA))

        def ingredientes = params.ingredientes instanceof String[] ? params.ingredientes : [params.ingredientes]
        def cantidades = params.cantidades instanceof String[] ? params.cantidades : [params.cantidades]
        def procedimientos = params.procedimientos instanceof String[] ? params.procedimientos : [params.procedimientos]

        procedimientos.each {
            nuevaReceta.addToProcedimientos(it)
        }

        [ingredientes, cantidades].transpose().each() {
            nuevaReceta.addToIngredientes(new IngredienteReceta(ingrediente: Ingrediente.findById(it[0]), cantidadGramos: it[1], calorias: 1234, esIngredientePrincipal: false))
        }

        nuevaReceta.save(flush:true)

        render(view:"crearReceta", model: [usuario: usuario, exito: "La receta ha sido creada!"])
    }

    def buscar() {

        def recetas = []


        EstrategiaBusqueda estrategiaDeBusqueda = recetaService.obtenerEstrategiaDeBusqueda(params.findAll { it.value != 'null'}.keySet())

        if (estrategiaDeBusqueda) {
            recetas = estrategiaDeBusqueda.obtenerResultados(params)
        }

        render(view:"buscarReceta", model: [recetas: recetas])
    }

	/*def estadisticas()
	{
		def recetas = []


		EstrategiaEstadistica estrategiaDeEstadisticas = recetaService.obtenerEstrategiaDeEstadisticas(params.estadistica)

		if (estrategiaDeEstadisticas) {
			recetas = estrategiaDeEstadisticas.obtenerEstadisticas(params)
		}

		render(view:"estadisticas", model: [recetas: recetas])
	}*/

    def calificar() {
        def calificacion = new Calificacion()

        calificacion.receta = Receta.findById(params.id)
        calificacion.usuario = session.user

		calificacion.puntaje = Integer.valueOf(params.calificacion)

        calificacion.save(flush: true)

        def calificacionesReceta = Calificacion.findAllByReceta(calificacion.receta)
        Integer promedio = 0
        calificacionesReceta.each() {
            promedio += it.puntaje
        }
        def receta = calificacion.receta
        receta.calificacionPromedio = promedio / calificacionesReceta.size()

        receta.save(flush: true)

        render(status: 200)
    }

}
