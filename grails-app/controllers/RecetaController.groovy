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
    		Receta recetaActual = Receta.buscarPorId(id)

            recetaActual.aumentarVisitas()

			def calificacion = Calificacion.findByRecetaAndUsuario(recetaActual, session.user)

    		return render(view:"detalleReceta", model: [usuario: session.user, receta: recetaActual, calificacion: calificacion])
    	}
   	}

    def seleccionar() {
        if(params.id) {
            Long id = params.id.toLong()

            Receta recetaActual = Receta.buscarPorId(id)

            HistorialUsuario.guardarHistorialUsuario(recetaActual, session.user)

            return render(view:"detalleReceta", model:[receta: recetaActual, exito:"Seleccionaste la receta!"])
        }
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
        nuevaReceta.urlImagen = params.url
        nuevaReceta.addToContraindicaciones(new Contraindicacion(condicionPreexistente: params.precondicion))

        if (params.boxInvierno == "INVIERNO") nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.INVIERNO))
        if (params.boxVerano == "VERANO") nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.VERANO))
        if (params.boxOtonio == "OTONIO") nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.OTONIO))
        if (params.boxPrimavera == "PRIMAVERA") nuevaReceta.addToTemporadas(new TemporadaReceta(temporada: Temporada.PRIMAVERA))
/*
        if (params.boxDesayuno == "DESAYUNO") nuevaReceta.addToCategorias(new Categoria(nombre: CategoriaEnum.DESAYUNO))
        if (params.boxAlmuerzo == "ALMUERZO") nuevaReceta.addToCategorias(new Categoria(nombre: CategoriaEnum.ALMUERZO))
        if (params.boxMerienda == "MERIENDA") nuevaReceta.addToCategorias(new Categoria(nombre: CategoriaEnum.MERIENDA))
        if (params.boxCena == "CENA") nuevaReceta.addToCategorias(new Categoria(nombre: CategoriaEnum.CENA))
*/
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


        EstrategiaBusqueda estrategiaDeBusqueda = recetaService.obtenerEstrategiaDeBusqueda(params.findAll { it.value }.keySet())

        if (estrategiaDeBusqueda) {
            recetas = estrategiaDeBusqueda.obtenerResultados(params)
        }

        render(view:"buscarReceta", model: [usuario: session.user, recetas: recetas, dificultad: params.dificultad, dieta: params.dieta, contraindicacion: params.contraindicacion])
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

    def recomendadas() {
        Usuario userActual = session.user

    }

    def calificar() {
        def calificacion = Calificacion.crearCalificacion(Receta.buscarPorId(params.id), session.user, Integer.valueOf(params.calificacion))

        calificacion.receta.actualizarCalificacionPromedio()

        render(status: 200)
    }

}
